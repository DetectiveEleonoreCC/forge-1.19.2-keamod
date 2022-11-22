package net.eleonore.keamod.event;


import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.entity.ModEntityTypes;
import net.eleonore.keamod.entity.custom.KeaEntity;
import net.eleonore.keamod.entity.custom.KiwiEntity;
import net.eleonore.keamod.item.ModItems;
import net.eleonore.keamod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModEvents {

    @Mod.EventBusSubscriber(modid = KeaMod.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            //after "stack": max uses, EXP that villager is gunna get, multiplier for the price
           /** if (event.getType() == VillagerProfession.CARTOGRAPHER) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.KEA_FEATHER.get(), 6);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5), stack, 10, 0, 0.02F));
            } **/

            if (event.getType() == ModVillagers.TRANSLATOR.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.KEA_FEATHER.get(), 6);
                int villagerLevel = 1;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 5), stack, 10, 0, 0.02F));
            }
            if (event.getType() == ModVillagers.TRANSLATOR.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
                ItemStack stack = new ItemStack(ModItems.KEA_FEATHER_TAIL.get(), 12);
                int villagerLevel = 2;

                trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                        new ItemStack(Items.EMERALD, 10), stack, 10, 0, 0.02F));
            }
        }


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
