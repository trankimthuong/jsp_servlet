package com.shop.service;

import com.shop.model.CategoryModel;
import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
}
