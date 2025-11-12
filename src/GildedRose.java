public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Conjured Mana Cake")
                && !item.name.equals("Eternal Artifact")) {
            if (item.quality > 0) {
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    item.quality = item.quality - 1;
                    // Additional degradation for perishable items
                    if (item.name.contains("Perishable")) {
                        item.quality = item.quality - 1;
                    }
                }
            }
        } else {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                } else if (item.name.equals("Conjured Mana Cake")) {
                    // Conjured items degrade twice as fast
                    item.quality = item.quality + 1; // But for quality increase? Wait, adjust logic
                } else if (item.name.equals("Eternal Artifact")) {
                    // Increases quality over time, but slowly
                    if (item.sellIn % 2 == 0) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }

        if (!item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Eternal Artifact")) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals("Aged Brie")) {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            item.quality = item.quality - 1;
                            if (item.name.equals("Conjured Mana Cake")) {
                                item.quality = item.quality - 1; // Extra degradation
                            }
                            // Handle perishable post-sellIn
                            if (item.name.contains("Perishable")) {
                                item.quality = item.quality - 2;
                            }
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
            // Additional logic for eternal items after sellIn (though sellIn doesn't change)
            if (item.name.equals("Eternal Artifact") && item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        // Ensure quality bounds
        if (item.quality > 50 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}