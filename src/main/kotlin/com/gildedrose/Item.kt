package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }

    fun degradeQuality(value: Int) {
        this.quality = (this.quality - value).takeIf { it >= 0 } ?: 0
    }

    fun upgradeQuality(value: Int) {
        this.quality = (this.quality + value).takeIf { it <= 50 } ?: 50
    }

    fun degradeSellIn() {
        this.sellIn -= 1
    }

}