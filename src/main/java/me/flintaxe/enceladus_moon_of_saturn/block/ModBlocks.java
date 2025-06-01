package me.flintaxe.enceladus_moon_of_saturn.block;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import me.flintaxe.enceladus_moon_of_saturn.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EnceladusMoonOfSaturn.MOD_ID);

    public static final DeferredBlock<Block> DARK_BLUE_ICE = registerBlock("dark_blue_ice",
            (properties) -> new Block(properties
                    .mapColor(MapColor.ICE).strength(3.3F).friction(1.0F).sound(SoundType.GLASS)
            ));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
