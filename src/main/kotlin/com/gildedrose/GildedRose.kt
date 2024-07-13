package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                "Sulfuras, Hand of Ragnaros" -> continue
                "Aged Brie" -> {
                    item.upgradeQuality(1)
                    if (item.sellIn < 1) item.upgradeQuality(1)
                }

                "Backstage passes to a TAFKAL80ETC concert" -> {
                    item.upgradeQuality(1)
                    if (item.sellIn < 11) item.upgradeQuality(1)
                    if (item.sellIn < 6) item.upgradeQuality(1)
                    if (item.sellIn < 1) item.degradeQuality(item.quality)
                }

                "Conjured" -> {
                    item.degradeQuality(2)
                    if (item.sellIn < 1) item.degradeQuality(2)
                }

                else -> {
                    item.degradeQuality(1)
                    if (item.sellIn < 1) item.degradeQuality(1)
                }
            }

            item.degradeSellIn()
        }
    }
}

