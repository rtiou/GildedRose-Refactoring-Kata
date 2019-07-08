package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassesImplTest {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private ItemUpdateQuality itemUpdateQuality = new BackstagePassesImpl();

    @Test
    public void testUpdateQuality() {
        Item item = new Item( BACKSTAGE_PASSES, 2, 5 );

        itemUpdateQuality.updateQuality( item );
        assertEquals( 1, item.sellIn );
        assertEquals( 8, item.quality );
    }

    @Test
    public void testUpCornerCaseUpdateQuality() {
        Item item = new Item( BACKSTAGE_PASSES, 2, 51 );

        itemUpdateQuality.updateQuality( item );
        assertEquals( 1, item.sellIn );
        assertEquals( 50, item.quality );
    }

    @Test
    public void testDownCornerCaseUpdateQuality() {
        Item item = new Item( BACKSTAGE_PASSES, 0, 51 );

        itemUpdateQuality.updateQuality( item );
        assertEquals( -1, item.sellIn );
        assertEquals( 0, item.quality );
    }

    @Test
    public void test10DaysUpdateQuality() {
        Item item = new Item( BACKSTAGE_PASSES, 10, 51 );

        itemUpdateQuality.updateQuality( item );
        assertEquals( 9, item.sellIn );
        assertEquals( 50, item.quality );
    }

    @Test
    public void test11DaysUpdateQuality() {
        Item item = new Item( BACKSTAGE_PASSES, 11, 51 );

        itemUpdateQuality.updateQuality( item );
        assertEquals( 10, item.sellIn );
        assertEquals( 50, item.quality );
    }
}