package me.flintaxe.enceladus_moon_of_saturn.dimension;


import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;

@EventBusSubscriber(modid = EnceladusMoonOfSaturn.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DimensionEffectsHandler {

    @SubscribeEvent
    public static void registerDimensionEffects(RegisterDimensionSpecialEffectsEvent event) {
        event.register(
                ResourceLocation.fromNamespaceAndPath(EnceladusMoonOfSaturn.MOD_ID, "enceladus"),
                new EnceladusDimensionEffects()
        );
    }
}