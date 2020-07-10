package com.gildedrose.item;

public class ConjuredItem extends ItemWrapper {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isPastSellIn())
            decreaseQualityBy(4);
        else
            decreaseQualityBy(2);

        checkQualityBoundaries();
    }
}
