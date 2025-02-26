package ru.tserk.coursach.coursach.models;

import javax.persistence.*;

@Entity
@Table(name = "Shop_item")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_item_id")
    private int shop_item_id;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop SId;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item itId;

    @Column(name = "count")
    private int count;

    public ShopItem() {
    }

    public ShopItem(Shop shop_id, Item itId, int count) {
        this.SId = shop_id;
        this.itId = itId;
        this.count = count;
    }

    public int getShop_item_id() {
        return shop_item_id;
    }

    public void setShop_item_id(int shop_item_id) {
        this.shop_item_id = shop_item_id;
    }

    public Shop getShop_id() {
        return SId;
    }

    public void setShop_id(Shop shop_id) {
        this.SId = shop_id;
    }

    public Item getItem_id() {
        return itId;
    }

    public void setItem_id(Item item_id) {
        this.itId = item_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "shop_item_id=" + shop_item_id +
                ", shop_id=" + SId +
                ", item_id=" + itId +
                ", count=" + count +
                '}';
    }
}
