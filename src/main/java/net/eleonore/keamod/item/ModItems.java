package net.eleonore.keamod.item;

import net.eleonore.keamod.KeaMod;
//import net.minecraft.world.item.CreativeModeTab;
import net.eleonore.keamod.entity.ModEntityTypes;
import net.eleonore.keamod.item.custom.InspectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KeaMod.MODID);

    public static final RegistryObject<Item> KEA_FEATHER = ITEMS.register("kea_feather",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> KEA_FEATHER_TAIL = ITEMS.register("kea_feather_tail",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> TIME_RUBBER = ITEMS.register("time_rubber",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> TEMPORALIUM_ALLOY = ITEMS.register("temporalium_alloy",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> TEMPORALIUM_ALLOY_SMELTED = ITEMS.register("temporalium_alloy_smelted",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> KIWI_SPAWN_EGG = ITEMS.register("kiwi_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KIWI, 0x765340, 0xfaddc9,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> KEA_SPAWN_EGG = ITEMS.register("kea_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.KEA, 0x8a822c, 0x5b8026,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> ENERGIZED_TEMPORALIUM = ITEMS.register("energized_temporalium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> PEN_N_GLASS = ITEMS.register("pen_n_glass",
            () -> new InspectorItem(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));

    public static final RegistryObject<Item> SCROLL1 = ITEMS.register("scroll1",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> SCROLL2 = ITEMS.register("scroll2",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> SCROLL3 = ITEMS.register("scroll3",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static final RegistryObject<Item> SCROLL4 = ITEMS.register("scroll4",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_KEA)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
