package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }


    // Requirement: All items have a SellIn value which denotes the number of days we have to sell the item and this value should decrease by 1 each day for normal items
    @Test
    void testSellInDecreasesNormally() {
        Item[] items = new Item[]{new Item("normal item", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn, "SellIn should decrease by 1");
    }

    // Requirement: Quality value denotes how valuable the item is and decreased by 1 each day for normal items
    @Test
    void testQualityDecreasesNormally() {
        Item[] items = new Item[]{new Item("normal item", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].quality, "Quality should decrease by 1");
    }

    // Requirement: Once the sell by date has passed, Quality degrades twice as fast
    @Test
    void testQualityDegradesTwiceAsFastAfterSellIn() {
        Item[] items = new Item[]{new Item("normal item", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, items[0].quality, "Quality should decrease by 2 after SellIn date");
    }

    // Requirement: The Quality of an item is never negative
    @Test
    void testQualityNeverNegative() {
        Item[] items = new Item[]{new Item("normal item", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].quality, "Quality should never be negative");
    }


}
