package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class ItemWrapper {

    private Item item;

    private final int MIN_QUALITY = 0;
    private final int MAX_QUALITY = 50;

    public ItemWrapper(String name, int sellIn, int quality) {
        this.item = new Item(name, sellIn, quality);
    }

    public abstract void update();

    public String getName() {
        return this.item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void decreaseSellIn() {
        this.item.sellIn -= 1;
    }

    public boolean isPastSellIn() {
        return this.item.sellIn < 0;
    }

    public int getQuality() {
        return item.quality;
    }

    public void setQuality(int quality) {
        this.item.quality = quality;
    }

    public void decreaseQualityBy(int amount) {
        this.item.quality -= amount;
    }

    public void increaseQualityBy(int amount) {
        this.item.quality += amount;
    }

    public void checkQualityBoundaries() {
        if (this.item.quality < this.MIN_QUALITY) {
            this.item.quality = this.MIN_QUALITY;
        } else if (this.item.quality > this.MAX_QUALITY) {
            this.item.quality = this.MAX_QUALITY;
        }
    }

    @Override
    public String toString() {
        return this.item.toString();
    }
}
