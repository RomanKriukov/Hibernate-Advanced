package org.kriukov.service;

import org.kriukov.dao.CategoryDao;
import org.kriukov.dmo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public void save(Category category){
        categoryDao.save(category);
    }

    @Transactional(readOnly = true)
    public List<Category> getAll(){
        return categoryDao.getAll();
    }
}
