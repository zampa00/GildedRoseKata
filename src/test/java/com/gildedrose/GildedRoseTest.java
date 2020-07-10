package com.gildedrose;

import static org.junit.Assert.assertEquals;

import com.gildedrose.item.*;
import org.junit.Test;


public class GildedRoseTest {

    @Test
    public void appKeepItems() {
        ItemWrapper[]  items = new ItemWrapper[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("Normal Item", app.items[0].getName());
    }

    @Test
    public void timePasses() {
        ItemWrapper[]  items = new ItemWrapper[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(1, app.items[0].getSellIn());
    }

    @Test
    public void qualityDegradesForNormalItems() {
        ItemWrapper[]  items = new ItemWrapper[]  { new NormalItem("Normal Item", 2, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(19, app.items[0].getQuality());
    }

    @Test
    public void qualityDegradesTwiceAsFastAfterSellDate() {
        ItemWrapper[]  items = new ItemWrapper[]  { new NormalItem("Normal Item", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(18, app.items[0].getQuality());
    }

    @Test
    public void qualityIsNeverNegative() {
        ItemWrapper[]  items = new ItemWrapper[]  { new NormalItem("Normal Item", 2, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    public void agedBrieIncreasesQuality() {
        ItemWrapper[]  items = new ItemWrapper[]  { new AgedBrie("Aged Brie", 1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].getQuality());
    }

    @Test
    public void agedBrieIncreasesQualityTwiceAsFastAfterSellIn() {
        ItemWrapper[]  items = new ItemWrapper[]  { new AgedBrie("Aged Brie", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].getQuality());
    }

    @Test
    public void qualityNeverOver50() {
        ItemWrapper[]  items = new ItemWrapper[]  { new AgedBrie("Aged Brie", -1, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].getQuality());
    }

    @Test
    public void sulfurasIsImmutable() {
        ItemWrapper[]  items = new ItemWrapper[]  { new ImmutableItem("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].getSellIn());
        assertEquals(80, app.items[0].getQuality());
    }

    @Test
    public void backstageTicketsAreNormalBefore10days() {
        ItemWrapper[]  items = new ItemWrapper[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 12, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(21, app.items[0].getQuality());
    }

    @Test
    public void backstageTicketsIncrease2between10and5() {
        ItemWrapper[]  items = new ItemWrapper[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(22, app.items[0].getQuality());
    }

    @Test
    public void backstageTicketsIncrease3between5and1() {
        ItemWrapper[]  items = new ItemWrapper[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(23, app.items[0].getQuality());
    }

    @Test
    public void backstageTicketsDropsTo0AfterConcert() {
        ItemWrapper[]  items = new ItemWrapper[]  { new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 0, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].getQuality());
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFast() {
        ItemWrapper[]  items = new ItemWrapper[]  { new ConjuredItem("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(18, app.items[0].getQuality());
    }

    @Test
    public void conjuredItemsDegradeTwiceAsFastWhenPastSellIn() {
        ItemWrapper[]  items = new ItemWrapper[]  { new ConjuredItem("Conjured Mana Cake", -1, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(16, app.items[0].getQuality());
    }
}
