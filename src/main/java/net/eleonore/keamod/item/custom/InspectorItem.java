package net.eleonore.keamod.item.custom;

import net.eleonore.keamod.block.ModBlocks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InspectorItem extends Item {
    public InspectorItem(Properties properties) {
        super(properties);
    }


    /**@Override (used as test)
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            outputRandomNumber(player);
            player.sendSystemMessage(Component.literal("test"));


        }

        return super.use(level, player, hand);
    } **/

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Player player = context.getPlayer();
        if(!level.isClientSide()) {
            if (!blockstate.is(ModBlocks.CARVED_HIEROGLYPHS.get())) {
                player.sendSystemMessage(Component.literal("You can't say there's much to say about this, in regards to glyphs at least.."));
                return InteractionResult.FAIL;
            }
            else {
                player.sendSystemMessage(Component.literal("Interesting.. Better get this deciphered by someone familiar with translations.."));
                player.getCooldowns().addCooldown(this, 25);

            }
        }



        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        if(Screen.hasShiftDown()) {
            list.add(Component.literal("With the humble pen and glass, you're able to observe and write down any strange, ancient writing you might come across.")
                    .withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.ITALIC));
            list.add(Component.literal("Right click on Carved Hieroglyphs to obtain Copied Glyphs.").withStyle(ChatFormatting.AQUA));
        }
        else {
            list.add(Component.literal("Press SHIFT for more information").withStyle(ChatFormatting.YELLOW));
        }

        super.appendHoverText(stack, level, list, flag);
    }

    //Useless
    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal("NUMBER:" + getRandomNumber()));
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
