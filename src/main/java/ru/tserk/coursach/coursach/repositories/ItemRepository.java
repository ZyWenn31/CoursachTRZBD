package ru.tserk.coursach.coursach.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tserk.coursach.coursach.models.Item;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByLabel(String label);
    List<Item> findByLabelStartingWith(String label);
}
