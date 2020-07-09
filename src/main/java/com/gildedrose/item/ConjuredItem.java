package com.gildedrose.item;

public class ConjuredItem extends AbstractItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        this.sellIn--;
        if (this.sellIn < 0)
            this.quality -= 4;
        else
            this.quality -= 2;

        if (this.quality < 0)
            this.quality = 0;
    }
}
