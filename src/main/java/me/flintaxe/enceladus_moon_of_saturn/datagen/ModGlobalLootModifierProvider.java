package me.flintaxe.enceladus_moon_of_saturn.datagen;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import me.flintaxe.enceladus_moon_of_saturn.item.ModItems;
import me.flintaxe.enceladus_moon_of_saturn.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, EnceladusMoonOfSaturn.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("ice_cube_to_packed_ice",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.PACKED_ICE).build()
                }, ModItems.ICE_CUBE.get(),1 , 4));
        this.add("blue_ice_cube_to_blue_ice",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BLUE_ICE).build()
                }, ModItems.BLUE_ICE_CUBE.get(),1 , 3));



        /*this.add("chisel_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.CHISEL.get()));

        this.add("berry_from_creeper",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper")).build()
                }, ModItems.GOJI_BERRIES.get()));*/


    }
}