package ru.tserk.coursach.coursach.services;

import org.springframework.stereotype.Service;
import ru.tserk.coursach.coursach.models.Category;
import ru.tserk.coursach.coursach.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
