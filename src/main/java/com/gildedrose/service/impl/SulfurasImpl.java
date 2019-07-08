package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;

public class SulfurasImpl implements ItemUpdateQuality {
    private static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";

    public SulfurasImpl() {
        ITEMS_NAMES.add( SULFURAS_NAME );
    }

    @Override
    public void updateQuality(Item item) {
        if (SULFURAS_NAME.equalsIgnoreCase( item.name )) {
            updateDay( item );
            updateQualityAttribute( item );
        }
    }

    @Override
    public void updateDay(Item item) {

    }

    @Override
    public void updateQualityAttribute(Item item) {

    }
}