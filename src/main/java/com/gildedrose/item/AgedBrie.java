package com.gildedrose.item;

public class AgedBrie extends AbstractItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;
        if (this.sellIn < 0)
            this.quality += 2;
        else
            this.quality += 1;

        if (this.quality > 50)
            this.quality = 50;
    }
}
