package com.gildedrose.item;

public class ImmutableItem extends ItemWrapper {

    public ImmutableItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

    }
}
