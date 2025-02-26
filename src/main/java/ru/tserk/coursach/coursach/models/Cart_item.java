package ru.tserk.coursach.coursach.models;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class Cart_item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private int cart_item_id;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
    private Cart cart_id;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item_id;

    private int quantity;


    public int getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(int cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Cart getCart_id() {
        return cart_id;
    }

    public void setCart_id(Cart cart_id) {
        this.cart_id = cart_id;
    }

    public Item getItem_id() {
        return item_id;
    }

    public void setItem_id(Item item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart_item() {
    }

    @Override
    public String toString() {
        return "Cart_item{" +
                "cart_item_id=" + cart_item_id +
                ", quantity=" + quantity +
                '}';
    }
}
