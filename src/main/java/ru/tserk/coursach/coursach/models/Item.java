package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int item_id;

    @NotEmpty(message = "Название не может быть пустым")
    @Column(name = "item_label")
    private String label;

//    @NotEmpty(message = "Для товара должна быть указана стоимость")
    @Min(value = 0, message = "Цена не может быть ниже чем 0")
    @Column(name = "price")
    private Integer price;

    @OneToMany(mappedBy = "itemId")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @OneToMany(mappedBy = "itId")
    private List<ShopItem> shopItemList = new ArrayList<>();

    public Item() {
    }

    public Item(String label, int price) {
        this.label = label;
        this.price = price;
    }

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }

    public void setShopItemList(List<ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", item_label='" + label + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return item_id == item.item_id && Objects.equals(label, item.label) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, label, price);
    }
}
