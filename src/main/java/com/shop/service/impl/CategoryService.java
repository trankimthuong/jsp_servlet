package com.shop.service.impl;

import com.shop.dao.ICategoryDAO;
import com.shop.dao.impl.CategoryDAO;
import com.shop.model.CategoryModel;
import com.shop.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
//    //cách simple để sử dụng DI
//    private ICategoryDAO categoryDAO;
//
//    public CategoryService(){
//        categoryDAO = new CategoryDAO();
//    }
//
//    @Override
//    public List<CategoryModel> findAll() {
//        return categoryDAO.findAll();
//    }
//    //

    @Inject
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
