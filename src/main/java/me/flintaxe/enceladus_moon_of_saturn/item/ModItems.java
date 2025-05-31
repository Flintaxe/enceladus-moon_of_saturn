package me.flintaxe.enceladus_moon_of_saturn.item;

import me.flintaxe.enceladus_moon_of_saturn.EnceladusMoonOfSaturn;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EnceladusMoonOfSaturn.MOD_ID);

    public static final DeferredItem<Item> ICE_CUBE = ITEMS.registerItem("ice_cube", Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> BLUE_ICE_CUBE = ITEMS.registerItem("blue_ice_cube", Item::new,
            new Item.Properties());

    public static final DeferredItem<Item> DARK_BLUE_ICE_CUBE = ITEMS.registerItem("dark_blue_ice_cube", Item::new,
            new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}