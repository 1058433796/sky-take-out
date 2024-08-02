package com.sky.service;


import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DishService {
    /**
     * 保存菜品信息及其配料信息
     * @param dishDTO
     */
    @Transactional
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 分页查询菜品信息
     * @param dishPageQueryDTO
     * @return
     */
    PageResult page(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 根据ID删除菜品信息及其配料信息
     * @param ids
     */
    @Transactional
    void delete(List<Long> ids);
}
