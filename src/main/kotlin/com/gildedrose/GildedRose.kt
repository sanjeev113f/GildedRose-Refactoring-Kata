package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                "Sulfuras, Hand of Ragnaros" -> continue
                "Aged Brie" -> item.upgradeQuality(1)
                "Backstage passes to a TAFKAL80ETC concert" -> {
                    item.upgradeQuality(1)
                    if (item.sellIn < 11) item.upgradeQuality(1)
                    if (item.sellIn < 6) item.upgradeQuality(1)
                }

                else -> item.degradeQuality(1)
            }

            item.degradeSellIn()

            if (item.sellIn < 0) {
                when (item.name) {
                    "Aged Brie" -> item.upgradeQuality(1)
                    "Backstage passes to a TAFKAL80ETC concert" -> item.degradeQuality(item.quality)
                    else -> item.degradeQuality(1)
                }
            }
        }
    }

}

