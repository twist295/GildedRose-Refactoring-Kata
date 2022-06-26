package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void 

    @Test
    void qualityNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);
    }

    @Test
    void qualityDegrades2xAfterSellByDate() {
        Item[] items = new Item[] { new Item("foo", 1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 9);
        app.updateQuality();
        assertEquals(app.items[0].quality, 7);
    }

    @Test
    void qualityIncreasesForAgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 1);
    }

    @Test
    void qualityNeverPasses50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 50);
    }

    @Test
    void legendaryItemsBehaveAsExpected() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 80);
    }

    @Test
    void qualityBehavesAsExpectedForBackstagePasses() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 7);

        app.updateQuality(); // sellIn 8
        app.updateQuality(); // sellIn 7
        app.updateQuality(); // sellIn 6
        app.updateQuality(); // sellIn 5

        assertEquals(app.items[0].quality, 15);

        app.updateQuality(); // sellIn 4
        app.updateQuality(); // sellIn 3
        app.updateQuality(); // sellIn 2
        app.updateQuality(); // sellIn 1
        app.updateQuality(); // sellIn 0
        app.updateQuality(); // sellIn -1

        assertEquals(app.items[0].quality, 0);
    }
}
