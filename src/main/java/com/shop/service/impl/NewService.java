package com.shop.service.impl;

import com.shop.dao.INewDAO;
import com.shop.model.NewModel;
import com.shop.service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDAO newDAO;

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDAO.findByCategoryId(categoryId);
    }
}
