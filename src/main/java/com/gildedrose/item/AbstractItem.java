package com.gildedrose.item;

import com.gildedrose.Item;

public abstract class AbstractItem extends Item {

    public AbstractItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        this.sellIn--;
        if (this.sellIn < 0)
            this.quality -= 2;
        else
            this.quality -= 1;

        if (this.quality < 0)
            this.quality = 0;
    }

}
