package com.gildedrose.item;

public class NormalItem extends ItemWrapper {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();

        if (isPastSellIn())
            decreaseQualityBy(2);
        else
            decreaseQualityBy(1);

        checkQualityBoundaries();
    }
}
