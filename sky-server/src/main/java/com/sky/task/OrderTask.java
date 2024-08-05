package com.sky.task;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class OrderTask {

    @Autowired
    private final OrderMapper orderMapper;

    public OrderTask(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 定时任务，每分钟执行一次，将超时未支付的订单状态设置为取消
     */
    @Scheduled(cron="0 * * * * ?")
    public void processTimeOutOrder(){
        LocalDateTime now = LocalDateTime.now();
        List<Orders> ordersList = orderMapper.getByStatusAndTimeout(Orders.PENDING_PAYMENT, now.minusMinutes(15));
        if(!CollectionUtils.isEmpty(ordersList)){
            for(Orders orders : ordersList){
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("超时未支付，系统自动取消订单");
                orders.setCancelTime(now);
                orderMapper.update(orders);
            }
        }
    }

    /**
     * 定时任务，每天1点执行一次，将超时未确认的订单状态设置为收货
     */
    @Scheduled(cron="0 0 1 * * ?")
    public void processDeliveryOrder(){
        LocalDateTime now = LocalDateTime.now();
        List<Orders> ordersList = orderMapper.getByStatusAndTimeout(Orders.DELIVERY_IN_PROGRESS, now.minusDays(1));
        if(!CollectionUtils.isEmpty(ordersList)){
            for(Orders orders : ordersList){
                orders.setStatus(Orders.COMPLETED);
                orderMapper.update(orders);
            }
        }
    }
}
