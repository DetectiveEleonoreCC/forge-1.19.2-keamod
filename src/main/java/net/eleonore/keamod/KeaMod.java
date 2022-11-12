package net.eleonore.keamod;

import com.mojang.logging.LogUtils;
import net.eleonore.keamod.block.ModBlocks;
import net.eleonore.keamod.entity.ModEntityTypes;
import net.eleonore.keamod.entity.client.KeaRenderer;
import net.eleonore.keamod.entity.client.KiwiRenderer;
import net.eleonore.keamod.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KeaMod.MODID)
public class KeaMod
{
    public static final String MODID = "keamod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public KeaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModEntityTypes.register(modEventBus);


        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntityTypes.KIWI.get(), KiwiRenderer::new);
            EntityRenderers.register(ModEntityTypes.KEA.get(), KeaRenderer::new);

        }
    }
}
