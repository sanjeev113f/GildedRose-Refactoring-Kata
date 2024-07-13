package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun `For more than Ten days updates`() {
        val days = 12
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        )
        val expectedResponse = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 3, 41),
        )

        val app = GildedRose(items)
        for (i in 0 until days) app.updateQuality()

        assertThat(expectedResponse).usingRecursiveFieldByFieldElementComparatorIgnoringFields().isEqualTo(app.items)
    }

    @Test
    fun `For 5 days update`() {
        val days = 5
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        )
        val expectedResponse = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 10, 25),
        )

        val app = GildedRose(items)
        for (i in 0 until days) app.updateQuality()

        assertThat(expectedResponse).usingRecursiveFieldByFieldElementComparatorIgnoringFields().isEqualTo(app.items)
    }

    @Test
    fun `For 7 days update`() {
        val days = 7
        val items = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        )
        val expectedResponse = listOf(
            Item("Sulfuras, Hand of Ragnaros", 5, 80),
            Item("Backstage passes to a TAFKAL80ETC concert", 8, 29),
        )

        val app = GildedRose(items)
        for (i in 0 until days) app.updateQuality()

        assertThat(expectedResponse).usingRecursiveFieldByFieldElementComparatorIgnoringFields().isEqualTo(app.items)
    }

    @Test
    fun `Max quality test`() {
        val days = 15
        val items = listOf(
            Item("Aged Brie", 2, 40), Item("Sulfuras, Hand of Ragnaros", 0, 80)
        )
        val expectResponse = listOf(
            Item("Aged Brie", -13, 50), Item("Sulfuras, Hand of Ragnaros", 0, 80)
        )

        val app = GildedRose(items)
        for (i in 0 until days) app.updateQuality()

        assertThat(expectResponse).usingRecursiveComparison().isEqualTo(app.items)
    }

    @Test
    fun `Min quality test`() {
        val days = 15
        val items = listOf(
            Item("Elixir of the Mongoose", 2, 5)
        )
        val expectResponse = listOf(
            Item("Elixir of the Mongoose", -13, 0)
        )

        val app = GildedRose(items)
        for (i in 0 until days) app.updateQuality()

        assertThat(expectResponse).usingRecursiveComparison().isEqualTo(app.items)
    }

}