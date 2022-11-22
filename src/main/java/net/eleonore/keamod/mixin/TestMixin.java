/** package net.eleonore.keamod.mixin;

import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.ai.goal.MoveThroughVillageGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.ZombieAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.BushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.world.entity.ai.goal.GoalSelector;

@Mixin(LightningBolt.class)
public abstract class TestMixin {
    private GoalSelector targetSelector;

    @Inject(at = @At(value = "HEAD"), method = "setDamage", cancellable = true)
    protected void onSetDamage(CallbackInfo info) {
        info.cancel();

        this.damage = damage + 10.0F;


    }

    @Shadow private float damage = 5.0F;
    
} **/
