package net.eleonore.keamod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KiwiRenderer extends GeoEntityRenderer<KiwiEntity> {

    public KiwiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KiwiModel());
        this.shadowRadius = 0.2f;
    }

    @Override
    public ResourceLocation getTextureLocation(KiwiEntity animatable) {
        return new ResourceLocation(KeaMod.MODID, "textures/entity/kiwi_texture.png");
    }

    @Override
    public RenderType getRenderType(KiwiEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {
        //poseStack.scale(0.8f, 0.8f, 0.8f); (makes model 80% of actual size)

        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
