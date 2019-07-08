package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item( "foo", 0, 0 )};
        GildedRose app = new GildedRose( items );
        app.updateQuality();
        assertEquals( "foo", items[0].name );
        assertEquals( -1, items[0].sellIn );
        assertEquals( 0, items[0].quality );
    }

    @Test
    public void fullTest() {
        Item[] items = createItemArray();
        GildedRose app = new GildedRose( items );

        app.updateQuality();

        checkReturn( "Aged Brie", items[0].name, 9, items[0].sellIn, 1, items[0].quality );
        checkReturn( "Backstage passes to a TAFKAL80ETC concert", items[1].name, 2, items[1].sellIn, 3, items[1].quality );
        checkReturn( "Conjured Mana Cake", items[2].name, 3, items[2].sellIn, 0, items[2].quality );
        checkReturn( "Oliebollen", items[3].name, 10, items[3].sellIn, 0, items[3].quality );
        checkReturn( "Sulfuras, Hand of Ragnaros", items[4].name, 5, items[4].sellIn, 80, items[4].quality );
        checkReturn( "Aged Brie", items[5].name, 0, items[5].sellIn, 1, items[5].quality );
        checkReturn( "Backstage passes to a TAFKAL80ETC concert", items[6].name, 2, items[6].sellIn, 3, items[6].quality );
        checkReturn( "Conjured Mana Cake", items[7].name, 4, items[7].sellIn, 0, items[7].quality );
        checkReturn( "Oliebollen", items[8].name, 5, items[8].sellIn, 0, items[8].quality );
        checkReturn( "Sulfuras, Hand of Ragnaros", items[9].name, 2, items[9].sellIn, 80, items[9].quality );
    }

    private void checkReturn(String expectName, String actualName, int expectedSellIn, int actualSellIn, int expectedQuality, int actualQuality) {
        assertEquals( expectName, actualName );
        assertEquals( expectedSellIn, actualSellIn );
        assertEquals( expectedQuality, actualQuality );
    }

    private Item[] createItemArray() {
        return new Item[]{
                createItem( "Aged Brie", 10, 0 ),
                createItem( "Backstage passes to a TAFKAL80ETC concert", 3, 0 ),
                createItem( "Conjured Mana Cake", 4, 0 ),
                createItem( "Oliebollen", 11, 0 ),
                createItem( "Sulfuras, Hand of Ragnaros", 5, 80 ),
                createItem( "Aged Brie", 1, 0 ),
                createItem( "Backstage passes to a TAFKAL80ETC concert", 3, 0 ),
                createItem( "Conjured Mana Cake", 5, 0 ),
                createItem( "Oliebollen", 6, 0 ),
                createItem( "Sulfuras, Hand of Ragnaros", 2, 80 )
        };
    }

    private Item createItem(String itemName, int sellIn, int quality) {
        return new Item( itemName, sellIn, quality );
    }
}
