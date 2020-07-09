package com.gildedrose;

import static org.junit.Assert.assertEquals;

import com.gildedrose.item.*;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void appKeepItems() {
        AbstractItem[]  items = new AbstractItem[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal Item", app.items[0].name);
    }

    @Test
    public void timePasses() {
        AbstractItem[]  items = new AbstractItem[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void qualityDegradesForNormalItems() {
        AbstractItem[]  items = new AbstractItem[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].quality);
    }

    @Test
    public void qualityDegradesTwiceAsFastAfterSellDate() {
        AbstractItem[]  items = new AbstractItem[]  { new NormalItem("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(18, app.items[0].quality);
    }

    @Test
    public void qualityIsNeverNegative() {
        AbstractItem[]  items = new AbstractItem[]  { new NormalItem("Normal Item", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedBrieIncreasesQuality() {
        AbstractItem[]  items = new AbstractItem[]  { new AgedBrie("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void qualityNeverOver50() {
        AbstractItem[]  items = new AbstractItem[]  { new AgedBrie("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasIsImmutable() {
        AbstractItem[]  items = new AbstractItem[]  { new ImmutableItem("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void backstageTicketsAreNormalBefore10days() {
        AbstractItem[]  items = new AbstractItem[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, app.items[0].quality);
    }

    @Test
    public void backstageTicketsIncrease2between10and5() {
        AbstractItem[]  items = new AbstractItem[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].quality);
    }

    @Test
    public void backstageTicketsIncrease3between5and1() {
        AbstractItem[]  items = new AbstractItem[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, app.items[0].quality);
    }

    @Test
    public void backstageTicketsDropsTo0AfterConcert() {
        AbstractItem[]  items = new AbstractItem[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }
}
