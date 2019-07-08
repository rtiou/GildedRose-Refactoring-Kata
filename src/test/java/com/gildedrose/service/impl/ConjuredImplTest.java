package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredImplTest {
    private static final String CONJURED_NAME = "Conjured Mana Cake";

    private ItemUpdateQuality itemUpdateQuality = new ConjuredImpl();

    @Test
    public void testUpdateQuality() {
        Item item = new Item( CONJURED_NAME, 0, 0 );
        itemUpdateQuality.updateQuality( item );

        assertEquals( -1, item.sellIn );
        assertEquals( 0, item.quality );
    }

    @Test
    public void testBottomCornerCaseUpdateQuality() {
        Item item = new Item( CONJURED_NAME, 0, 50 );
        itemUpdateQuality.updateQuality( item );

        assertEquals( -1, item.sellIn );
        assertEquals( 46, item.quality );
    }

    @Test
    public void test2DaysBottomCornerCaseUpdateQuality() {
        Item item = new Item( CONJURED_NAME, 1, 50 );
        itemUpdateQuality.updateQuality( item );
        itemUpdateQuality.updateQuality( item );

        assertEquals( -1, item.sellIn );
        assertEquals( 44, item.quality );
    }
}

