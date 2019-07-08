package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieImplTest {
    private static final String AGED_BRIE_NAME = "Aged Brie";

    private ItemUpdateQuality itemUpdateQuality = new AgedBrieImpl();

    @Test
    public void testHappyFlowUpdateQuality() {
        Item item = new Item( AGED_BRIE_NAME, 1, 2 );

        itemUpdateQuality.updateQuality( item );

        assertEquals( 0, item.sellIn );
        assertEquals( 3, item.quality );

    }

    @Test
    public void testUpCornerCaseUpdateQuality() {
        Item item = new Item( AGED_BRIE_NAME, 1, 51 );

        itemUpdateQuality.updateQuality( item );

        assertEquals( 0, item.sellIn );
        assertEquals( 50, item.quality );
    }

    @Test
    public void testDownCornerCaseUpdateQuality() {
        Item item = new Item( AGED_BRIE_NAME, 0, 51 );

        itemUpdateQuality.updateQuality( item );

        assertEquals( -1, item.sellIn );
        assertEquals( 50, item.quality );
    }
}
