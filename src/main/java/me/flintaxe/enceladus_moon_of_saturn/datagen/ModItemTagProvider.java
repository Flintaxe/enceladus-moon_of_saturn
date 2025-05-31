package me.flintaxe.enceladus_moon_of_saturn.datagen;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, EnceladusMoonOfSaturn.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ADD TAGS HERE
    }
}