package com.gildedrose.item;

public class AgedBrie extends ItemWrapper {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isPastSellIn())
            increaseQualityBy(2);
        else
            increaseQualityBy(1);

        checkQualityBoundaries();
    }
}
