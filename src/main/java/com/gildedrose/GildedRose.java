package com.gildedrose;

import com.gildedrose.service.ItemUpdateQuality;
import com.gildedrose.service.impl.AgedBrieImpl;
import com.gildedrose.service.impl.BackstagePassesImpl;
import com.gildedrose.service.impl.ConjuredImpl;
import com.gildedrose.service.impl.DefaultImpl;
import com.gildedrose.service.impl.SulfurasImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private List<ItemUpdateQuality> itemUpdateQualities;

    public GildedRose(Item[] items) {
        this.items = items;
        this.itemUpdateQualities = new ArrayList<>( Arrays.asList(
                new AgedBrieImpl(),
                new BackstagePassesImpl(),
                new ConjuredImpl(),
                new SulfurasImpl(),
                new DefaultImpl() ) );
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            itemUpdateQualities.stream().forEach( itemUpdateQuality -> itemUpdateQuality.updateQuality( item ) );
        }
    }
}