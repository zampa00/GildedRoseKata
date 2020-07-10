package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstageItem extends ItemWrapper {

    public BackstageItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isPastSellIn())
            setQuality(0);
        else if (getSellIn() < 5)
            increaseQualityBy(3);
        else if (getSellIn() < 10)
            increaseQualityBy(2);
        else
            increaseQualityBy(1);

        checkQualityBoundaries();
    }

}
