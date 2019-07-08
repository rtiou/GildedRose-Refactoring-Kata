package com.gildedrose.service.impl;

import com.gildedrose.Item;
import com.gildedrose.service.ItemUpdateQuality;

public class DefaultImpl implements ItemUpdateQuality {
    @Override
    public void updateQuality(Item item) {

        if (!ITEMS_NAMES.contains( item.name )) {
            updateDay( item );
            updateQualityAttribute( item );
        }
    }
}