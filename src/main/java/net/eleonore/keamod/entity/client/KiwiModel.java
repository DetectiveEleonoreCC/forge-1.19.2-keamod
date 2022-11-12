package net.eleonore.keamod.entity.client;

import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KiwiModel extends AnimatedGeoModel<KiwiEntity> {
    @Override
    public ResourceLocation getModelResource(KiwiEntity object) {
        return new ResourceLocation(KeaMod.MODID, "geo/kiwi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KiwiEntity object) {
        return new ResourceLocation(KeaMod.MODID, "textures/entity/kiwi_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KiwiEntity animatable) {
        return new ResourceLocation(KeaMod.MODID, "animations/kiwi.animation.json");
    }
}
