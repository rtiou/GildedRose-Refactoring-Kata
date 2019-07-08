package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultImplTest {

    private ItemUpdateQuality itemUpdateQuality = new DefaultImpl();

    @Test
    public void testUpdateQuality() throws Exception {
        Item item = new Item( "Oliebollen", 0, 0 );
        itemUpdateQuality.updateQuality( item );
        assertEquals( -1, item.sellIn );
        assertEquals( 0, item.quality );
    }

    @Test
    public void testTopCornerCaseUpdateQuality() throws Exception {
        Item item = new Item( "Pannekoeken", 10, 50 );
        itemUpdateQuality.updateQuality( item );
        assertEquals( 9, item.sellIn );
        assertEquals( 49, item.quality );
    }

    @Test
    public void testBottomCornerCaseUpdateQuality() throws Exception {
        Item item = new Item( "Stroopwafels", 0, 1 );
        itemUpdateQuality.updateQuality( item );
        itemUpdateQuality.updateQuality( item );
        assertEquals( -2, item.sellIn );
        assertEquals( 0, item.quality );
    }
}