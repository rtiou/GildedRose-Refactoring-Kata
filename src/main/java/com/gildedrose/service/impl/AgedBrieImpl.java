package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;

public class AgedBrieImpl implements ItemUpdateQuality {
    private static final String AGED_BRIE_NAME = "Aged Brie";

    public AgedBrieImpl() {
        ITEMS_NAMES.add( AGED_BRIE_NAME );
    }

    @Override
    public void updateQuality(Item item) {
        if (AGED_BRIE_NAME.equalsIgnoreCase( item.name )) {
            updateDay( item );
            updateQualityAttribute( item );
            normalizeQualityValue( item );
        }
    }

    @Override
    public void updateQualityAttribute(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }

        if (item.sellIn < 0) {
            item.quality += 1;
        }
    }
}