package net.eleonore.keamod.entity.client;

import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.custom.KeaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class KeaModel extends AnimatedGeoModel<KeaEntity> {
    @Override
    public ResourceLocation getModelResource(KeaEntity object) {
        return new ResourceLocation(KeaMod.MODID, "geo/kea.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KeaEntity object) {
        return new ResourceLocation(KeaMod.MODID, "textures/entity/kea_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KeaEntity animatable) {
        return new ResourceLocation(KeaMod.MODID, "animations/kea.animation.json");
    }
}
