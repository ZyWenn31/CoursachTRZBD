package ru.tserk.coursach.coursach.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_title")
    private String category_title;

    @OneToMany(mappedBy = "category_id")
    private List<Item> itemList = new ArrayList<>();

    public Category() {
    }

    public Category(String category_title) {
        this.category_title = category_title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", category_title='" + category_title + '\'' +
                '}';
    }
}
