package me.flintaxe.enceladus_moon_of_saturn.item;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import me.flintaxe.enceladus_moon_of_saturn.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnceladusMoonOfSaturn.MOD_ID);

    public static final Supplier<CreativeModeTab> ENCELADUS_CREATIVE_TAB = CREATIVE_MODE_TAB.register("enceladus_creative_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ICE_CUBE.get()))
                    .title(Component.translatable("creativetab.enceladus_moon_of_saturn.title"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DARK_BLUE_ICE);
                        output.accept(ModItems.ICE_CUBE);
                        output.accept(ModItems.BLUE_ICE_CUBE);
                        output.accept(ModItems.DARK_BLUE_ICE_CUBE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
