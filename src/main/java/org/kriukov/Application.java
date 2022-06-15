package org.kriukov;

import org.kriukov.config.ApplicationConfiguration;
import org.kriukov.dmo.Category;
import org.kriukov.service.CategoryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ApplicationConfiguration.class
        );

        CategoryService categoryService = context.getBean(CategoryService.class);

        categoryService.save(new Category("Action"));
        categoryService.save(new Category("Fantastic"));
        categoryService.save(new Category("Comedy"));

        List<Category> categoryList = categoryService.getAll();
        for(Category category : categoryList){
            System.out.println(category);
        }

        context.close();
    }
}
