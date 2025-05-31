package me.flintaxe.enceladus_moon_of_saturn.datagen;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, EnceladusMoonOfSaturn.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}