package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Shop")
public class  Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int shop_id;

    @Column(name = "address")
    @NotEmpty(message = "Адресс магазина не может быть пустым")
    private String address;

    @Column(name = "director_name")
    private String director_name;

    @OneToMany(mappedBy = "shop_id")
    private List<Order> orders = new ArrayList<>();


    @OneToMany(mappedBy = "shop_id")
    private List<ShopItem> shopItemList = new ArrayList<>();

    public Shop() {
    }

    public Shop(String address, String director_name) {
        this.address = address;
        this.director_name = director_name;
    }

    public List<ShopItem> getShopItemList() {
        return shopItemList;
    }

    public void setShopItemList(List<ShopItem> shopItemList) {
        this.shopItemList = shopItemList;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirector_name() {
        return director_name;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shop_id=" + shop_id +
                ", address='" + address + '\'' +
                ", director_name='" + director_name + '\'' +
                '}';
    }
}
