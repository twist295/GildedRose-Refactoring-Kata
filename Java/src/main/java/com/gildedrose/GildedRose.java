package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            // legendaries don't change stats on update
            if (item.name.contains("Sulfuras")) {
                continue;
            }

            // aged brie increases quality as it ages
            if (item.name.contains("Aged Brie")) {
                if (item.quality < 50) {
                    item.quality++;
                }
            } else if (item.name.contains("Backstage passes")) {
                if (item.sellIn <= 0) {
                    item.quality = 0;
                } else if (item.sellIn <= 5) {
                    item.quality += 3;
                } else if (item.sellIn <= 10) {
                    item.quality += 2;
                }
            } else if (item.sellIn <= 0) {
                item.quality -= 2;
            } else {
                item.quality--;
            }

            if (item.quality < 0) {
                item.quality = 0;
            }

            item.sellIn--;
        }
    }
}
