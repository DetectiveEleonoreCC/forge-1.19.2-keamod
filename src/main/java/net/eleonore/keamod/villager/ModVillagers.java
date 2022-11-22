package net.eleonore.keamod.villager;

import com.google.common.collect.ImmutableSet;
import net.eleonore.keamod.KeaMod;
import net.eleonore.keamod.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, KeaMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, KeaMod.MODID);

    public static final RegistryObject<PoiType> TRANSLATOR_BLOCK_POI = POI_TYPES.register("translator_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.COPPER_CAGE.get().getStateDefinition().getPossibleStates()), 1, 1));
    //maxTickets: how many villagers can take a job from this block, validRange: range of the block

    public static final RegistryObject<VillagerProfession> TRANSLATOR = VILLAGER_PROFESSIONS.register("translator",
            () -> new VillagerProfession("translator", x -> x.get() == TRANSLATOR_BLOCK_POI.get(),
                    x -> x.get() == TRANSLATOR_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CARTOGRAPHER));


    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, TRANSLATOR_BLOCK_POI);

        }
        catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
