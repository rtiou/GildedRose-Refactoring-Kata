package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfurasImplTest {
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";

    private ItemUpdateQuality itemUpdateQuality = new SulfurasImpl();

    @Test
    public void testUpdateQuality() throws Exception {
        Item item = new Item( SULFURAS_NAME, 1, 1 );
        itemUpdateQuality.updateQuality( item );

        assertEquals( 1, item.sellIn );
        assertEquals( 1, item.quality );
    }
}
