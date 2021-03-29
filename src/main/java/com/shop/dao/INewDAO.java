package com.shop.dao;

import com.shop.model.NewModel;
import java.util.List;

public interface INewDAO {
    List<NewModel> findByCategoryId(Long categoryId);
}
