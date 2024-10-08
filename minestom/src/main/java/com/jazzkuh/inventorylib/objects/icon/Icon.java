package com.jazzkuh.inventorylib.objects.icon;

import lombok.Data;
import net.kyori.adventure.nbt.CompoundBinaryTag;
import net.minestom.server.event.inventory.InventoryPreClickEvent;
import net.minestom.server.item.ItemComponent;
import net.minestom.server.item.ItemStack;
import net.minestom.server.item.component.CustomData;

import java.util.UUID;
import java.util.function.Consumer;

@Data
public final class Icon {

    private UUID uniqueId;
    private ItemStack item;
    private Consumer<InventoryPreClickEvent> clickEvent;
    private boolean sound;

    private Integer slot;
    
    public Icon(int slot, ItemStack item) {
        this.slot = slot;
        this.item = item;
        this.sound = true;
        this.clickEvent = null;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(int slot, ItemStack item, Consumer<InventoryPreClickEvent> clickEvent) {
        this.slot = slot;
        this.item = item;
        this.sound = true;
        this.clickEvent = clickEvent;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(int slot, ItemStack item, boolean hasSound) {
        this.slot = slot;
        this.item = item;
        this.sound = hasSound;
        this.clickEvent = null;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(int slot, ItemStack item, boolean hasSound, Consumer<InventoryPreClickEvent> clickEvent) {
        this.slot = slot;
        this.item = item;
        this.sound = hasSound;
        this.clickEvent = clickEvent;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(ItemStack item) {
        this.slot = null;
        this.item = item;
        this.sound = true;
        this.clickEvent = null;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(ItemStack item, Consumer<InventoryPreClickEvent> clickEvent) {
        this.slot = null;
        this.item = item;
        this.sound = true;
        this.clickEvent = clickEvent;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(ItemStack item, boolean hasSound) {
        this.slot = null;
        this.item = item;
        this.sound = hasSound;
        this.clickEvent = null;
        this.uniqueId = UUID.randomUUID();
    }

    public Icon(ItemStack item, boolean hasSound, Consumer<InventoryPreClickEvent> clickEvent) {
        this.item = item;
        this.sound = hasSound;
        this.clickEvent = clickEvent;
        this.uniqueId = UUID.randomUUID();
    }

    public ItemStack getItem() {
        return this.getItem(true);
    }

    public ItemStack getItem(boolean withIdentifier) {
        if (!withIdentifier) return this.item;

        return this.item.with(ItemComponent.CUSTOM_DATA, new CustomData(CompoundBinaryTag.builder().putString("icon_identifier", this.uniqueId.toString()).build()));
    }

}
