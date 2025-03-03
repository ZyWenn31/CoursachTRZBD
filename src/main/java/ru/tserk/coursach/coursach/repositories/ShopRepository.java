package ru.tserk.coursach.coursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tserk.coursach.coursach.models.Shop;

import java.util.List;

@Repository
public interface  ShopRepository extends JpaRepository<Shop, Integer> {
    Shop findById(int id); // add optional
    List<Shop> findByAddressStartingWith(String address);
}
