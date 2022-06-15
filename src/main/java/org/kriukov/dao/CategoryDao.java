package org.kriukov.dao;

import org.kriukov.dmo.Category;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Category category){
        entityManager.persist(category);
    }

    public Category getById(Long id){
        return entityManager.find(Category.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll(){
        return entityManager.createQuery("select c from Category c").getResultList();
    }
}
