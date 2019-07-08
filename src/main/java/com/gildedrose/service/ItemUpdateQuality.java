package com.gildedrose.service;

import com.gildedrose.Item;

import java.util.LinkedHashSet;
import java.util.Set;

public interface ItemUpdateQuality {
    Set<String> ITEMS_NAMES = new LinkedHashSet<>();

    void updateQuality(Item item);

    default void updateDay(Item item) {
        item.sellIn -= 1;
    }

    default void updateQualityAttribute(Item item) {
        if (item.sellIn >= 0) {
            item.quality -= 1;
        } else {
            item.quality -= 2;
        }

        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    default void normalizeQualityValue(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
