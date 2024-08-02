package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Slf4j
@Api(tags = "后台-商铺管理")
public class ShopController {

    @Autowired
    private RedisTemplate redisTemplate;

    private static final String SHOP_STATUS = "shop_status";

    @GetMapping("/status")
    @ApiOperation(value = "获取商铺状态")
    public Result<Integer> getStatus(){
        log.info("获取商铺状态");
        Integer status = (Integer) redisTemplate.opsForValue().get(SHOP_STATUS);
        return Result.success(status);
    }

    @PutMapping("/{status}")
    @ApiOperation(value = "修改商铺状态")
    public Result<Void> updateStatus(@PathVariable("status") Integer status) {
        log.info("修改商铺状态, status={}", status);
        redisTemplate.opsForValue().set(SHOP_STATUS, status);
        return Result.success();
    }
}
