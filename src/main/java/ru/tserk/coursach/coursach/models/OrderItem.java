package ru.tserk.coursach.coursach.models;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item itemId;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order_id;

    @Column(name = "count")
    private int count;

    public OrderItem() {
    }

    public OrderItem(Item itemId, Order order_id, int count, int shop_id) {
        this.itemId = itemId;
        this.order_id = order_id;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem_id() {
        return itemId;
    }

    public void setItem_id(Item item_id) {
        this.itemId = item_id;
    }

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", item_id=" + itemId +
                ", order_id=" + order_id +
                ", count=" + count +
                '}';
    }
}
