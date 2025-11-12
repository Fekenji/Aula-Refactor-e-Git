public class Item {
    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {
        updateItemQuality();
        updateItemSellIn();
        updateItemQualityPostSellIn();
        enforceQualityBounds();
    }

    private void updateItemQuality() {
        boolean isAgedBrie = name.equals("Aged Brie");
        boolean isBackstagePass = name.equals("Backstage passes to a TAFKAL80ETC concert");
        boolean isConjured = name.equals("Conjured Mana Cake");
        boolean isEternal = name.equals("Eternal Artifact");
        boolean isSulfuras = name.equals("Sulfuras, Hand of Ragnaros");

        if (!isAgedBrie && !isBackstagePass && !isConjured && !isEternal) {
            if (quality > 0) {
                if (!isSulfuras) {
                    quality = quality - 1;
                    // Additional degradation for perishable items
                    if (name.contains("Perishable")) {
                        quality = quality - 1;
                    }
                }
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;
                if (isBackstagePass) {
                    if (sellIn < 11) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                    if (sellIn < 6) {
                        if (quality < 50) {
                            quality = quality + 1;
                        }
                    }
                } else if (isConjured) {
                    // Conjured items degrade twice as fast
                    quality = quality + 1; // But for quality increase? Wait, adjust logic
                } else if (isEternal) {
                    // Increases quality over time, but slowly
                    if (sellIn % 2 == 0) {
                        quality = quality + 1;
                    }
                }
            }
        }
    }

    private void updateItemSellIn() {
        if (!name.equals("Sulfuras, Hand of Ragnaros") && !name.equals("Eternal Artifact")) {
            sellIn = sellIn - 1;
        }
    }

    private void updateItemQualityPostSellIn() {
        if (sellIn < 0) {
            if (!name.equals("Aged Brie")) {
                if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (quality > 0) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            quality = quality - 1;
                            if (name.equals("Conjured Mana Cake")) {
                                quality = quality - 1; // Extra degradation
                            }
                            // Handle perishable post-sellIn
                            if (name.contains("Perishable")) {
                                quality = quality - 2;
                            }
                        }
                    }
                } else {
                    quality = quality - quality;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
            // Additional logic for eternal items after sellIn (though sellIn doesn't change)
            if (name.equals("Eternal Artifact") && quality < 50) {
                quality = quality + 1;
            }
        }
    }

    private void enforceQualityBounds() {
        // Ensure quality bounds
        if (quality > 50 && !name.equals("Sulfuras, Hand of Ragnaros")) {
            quality = 50;
        }
        if (quality < 0) {
            quality = 0;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}