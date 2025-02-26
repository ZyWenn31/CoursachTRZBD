package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cart_id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person_id;

    @OneToMany(mappedBy = "cart_id")
    private List<Cart_item> cartItems = new ArrayList<>();

    public Cart() {
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                '}';
    }
}
