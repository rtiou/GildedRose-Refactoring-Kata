package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;

public class BackstagePassesImpl implements ItemUpdateQuality {
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePassesImpl() {
        ITEMS_NAMES.add( BACKSTAGE_PASSES );
    }

    @Override
    public void updateQuality(Item item) {
        if (BACKSTAGE_PASSES.equalsIgnoreCase( item.name )) {
            updateDay( item );
            updateQualityAttribute( item );
            normalizeQualityValue( item );
        }
    }

    @Override
    public void updateQualityAttribute(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else {
            if (item.sellIn >= 10) {
                item.quality += 1;
            }

            if (item.sellIn < 10 && item.sellIn >= 5) {
                item.quality += 2;
            }

            if (item.sellIn < 5) {
                item.quality += 3;
            }
        }

    }
}