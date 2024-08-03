package com.sky.service;


import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;
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

    /**
     * 修改菜品及其品料信息
     * @param dishDTO
     */
    @Transactional
    void update(DishDTO dishDTO);

    /**
     * 根据ID查询菜品信息
     *
     * @param id
     * @return
     */
    DishVO get(Long id);

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    List<Dish> list(Long categoryId);

    /**
     * 条件查询菜品和口味
     * @param dish
     * @return
     */
    List<DishVO> listWithFlavor(Dish dish);
}
