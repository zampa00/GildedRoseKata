package com.gildedrose;

import com.gildedrose.item.ItemWrapper;

import java.util.Arrays;

class GildedRose {
    ItemWrapper[] items;

    public GildedRose(ItemWrapper[] items) {
        this.items = items;
    }



    public void updateQuality() {
        Arrays.stream(items).forEach(item -> item.update());
    }
}
