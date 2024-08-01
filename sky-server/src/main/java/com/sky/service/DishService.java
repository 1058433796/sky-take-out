package com.sky.service;


import com.sky.dto.DishDTO;
import org.springframework.transaction.annotation.Transactional;

public interface DishService {
    /**
     * 保存菜品信息及其配料信息
     * @param dishDTO
     */
    @Transactional
    void saveWithFlavor(DishDTO dishDTO);
}
