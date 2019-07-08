package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;

public class ConjuredImpl implements ItemUpdateQuality {
    private static final String CONJURED_NAME = "Conjured Mana Cake";

    public ConjuredImpl() {
        ITEMS_NAMES.add( CONJURED_NAME );
    }

    @Override
    public void updateQuality(Item item) {
        if (CONJURED_NAME.equalsIgnoreCase( item.name )) {
            updateDay( item );
            updateQualityAttribute( item );
        }
    }

    @Override
    public void updateQualityAttribute(Item item) {
        if (item.sellIn >= 0) {
            item.quality -= 2;
        } else {
            item.quality -= 4;
        }

        if (item.quality < 0) {
            item.quality = 0;
        }

    }
}