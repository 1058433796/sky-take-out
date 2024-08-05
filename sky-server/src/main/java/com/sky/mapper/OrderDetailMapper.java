package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    /**
     * 新增订单详情
     * @param orderDetail
     */
    @Insert("insert into order_detail (name, image, order_id, dish_id, setmeal_id, dish_flavor, amount) " +
            "values (#{name}, #{image}, #{orderId}, #{dishId}, #{setmealId}, #{dishFlavor}, #{amount})")
    void insert(OrderDetail orderDetail);

    /**
     * 批量新增订单详情
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);

    /**
     * 根据订单id查询订单详情
     * @param orderId
     * @return
     */
    @Select("select * from order_detail where order_id = #{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);
}
