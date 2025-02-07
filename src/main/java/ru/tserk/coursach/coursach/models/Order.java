package ru.tserk.coursach.coursach.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop_id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person_id;

    @OneToMany(mappedBy = "order_id")
    private List<OrderItem> orderItemList = new ArrayList<>();

    @Column(name = "order_status")
    private String order_status;

    public Order() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Shop getShop_id() {
        return shop_id;
    }

    public void setShop_id(Shop shop_id) {
        this.shop_id = shop_id;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", shop_id=" + shop_id +
                ", person_id=" + person_id +
                '}';
    }
}
