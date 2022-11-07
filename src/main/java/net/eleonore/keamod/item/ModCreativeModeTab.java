package net.eleonore.keamod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_KEA= new CreativeModeTab("tab_kea") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.KEA_FEATHER.get());
        }
    };
}
