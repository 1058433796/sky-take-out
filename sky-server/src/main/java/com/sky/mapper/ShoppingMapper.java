package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingMapper {
    /**
     * 根据条件查询购物车列表
     * @param shoppingCart
     * @return
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 更新购物车信息
     * @param cart
     */
    @Update("update shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart cart);

    /**
     * 向购物车中插入新商品
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);
}
