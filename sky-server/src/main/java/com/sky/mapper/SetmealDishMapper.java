package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 查找包含菜品的套餐数量
     * @param dishIds
     * @return
     */
    int countByDishIds(List<Long> dishIds);
}
