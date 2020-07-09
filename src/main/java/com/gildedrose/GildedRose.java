package com.gildedrose;

import com.gildedrose.item.AbstractItem;

import java.util.Arrays;

class GildedRose {
    AbstractItem[] items;

    public GildedRose(AbstractItem[] items) {
        this.items = items;
    }



    public void updateQuality() {
        Arrays.stream(items).forEach(item -> item.update());
    }
}
