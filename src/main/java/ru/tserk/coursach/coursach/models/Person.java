package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int person_id;

    @NotEmpty(message = "Имя пользователя не может быть пустьм")
    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Integer age;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "person_id")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "person_id")
    private Cart cart;

    public Person() {
    }

    public Person(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getId() {
        return person_id;
    }

    public void setId(int person_id) {
        this.person_id = person_id;
    }

    public  String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + person_id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
