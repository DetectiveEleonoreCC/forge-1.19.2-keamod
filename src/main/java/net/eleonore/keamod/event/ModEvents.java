package net.eleonore.keamod.event;

import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.ModEntityTypes;
import net.eleonore.keamod.entity.custom.KeaEntity;
import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = KeaMod.MODID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = KeaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.KIWI.get(), KiwiEntity.setAttributes());
            event.put(ModEntityTypes.KEA.get(), KeaEntity.setAttributes());
        }


    }
}
