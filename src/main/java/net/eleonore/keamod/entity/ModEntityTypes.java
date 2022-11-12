package net.eleonore.keamod.entity;

import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.custom.KeaEntity;
import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, KeaMod.MODID);

    public static final RegistryObject<EntityType<KiwiEntity>> KIWI =
            ENTITY_TYPES.register("kiwi",
                    () -> EntityType.Builder.of(KiwiEntity::new, MobCategory.CREATURE)
                            .sized(0.35f, 0.6f)
                            .build(new ResourceLocation(KeaMod.MODID, "kiwi").toString()));

    public static final RegistryObject<EntityType<KeaEntity>> KEA =
            ENTITY_TYPES.register("kea",
                    () -> EntityType.Builder.of(KeaEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.9f)
                            .build(new ResourceLocation(KeaMod.MODID, "kea").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
