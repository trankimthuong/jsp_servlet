package com.shop.service;

import com.shop.model.NewModel;
import java.util.List;

public interface INewService {
    List<NewModel> findByCategoryId(Long categoryId);
}
