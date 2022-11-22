package net.eleonore.keamod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class CopperCageBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.create("lit");

    public CopperCageBlock(Properties properties) {
        super(properties);
    }





    @Override
    public BlockState getStateForPlacement(BlockPlaceContext level) {
        return this.defaultBlockState().setValue(LIT, Boolean.valueOf(level.getLevel().hasNeighborSignal(level.getClickedPos())));
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos blockPos, Block block, BlockPos blockPos1, boolean b) {
        if (!level.isClientSide) {
            boolean flag = state.getValue(LIT);
            if (flag != level.hasNeighborSignal(blockPos)) {
                if (flag) {
                    level.scheduleTick(blockPos, this, 4);
                } else {
                    level.setBlock(blockPos, state.cycle(LIT), 2);
                }
            }

        }
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource rand) {
        if (blockState.getValue(LIT) && !serverLevel.hasNeighborSignal(blockPos)) {
            serverLevel.setBlock(blockPos, blockState.cycle(LIT), 2);
        }

    }

    @Override
    public void animateTick(BlockState stateIn, Level level, BlockPos blockPos, RandomSource rand) {
        float chance = 0.10f;
        BooleanProperty lit = LIT;
        if (stateIn.getValue(LIT)) {
            if (chance < rand.nextFloat()) {
                level.addParticle(ParticleTypes.ELECTRIC_SPARK, blockPos.getX() + rand.nextDouble(),
                        blockPos.getY() + 0.5d, blockPos.getZ() + rand.nextDouble(), 0.04d, 0.05d, 0.04d);
            }

        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
