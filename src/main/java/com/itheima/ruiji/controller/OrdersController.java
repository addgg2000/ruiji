package com.itheima.ruiji.controller;


import cn.hutool.db.sql.Order;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.ruiji.common.R;
import com.itheima.ruiji.dto.OrdersDto;
import com.itheima.ruiji.entity.Orders;
import com.itheima.ruiji.service.OrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 订单表 前端控制器
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@RestController
@RequestMapping("/order")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    /**
     * 添加订单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R addOrders(@RequestBody Orders orders){
        ordersService.addOrders(orders);
        return R.success("下单成功！");
    }

    /**
     * 获取订单详情
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R getOrders(Integer page, Integer pageSize){
        Page<OrdersDto> ordersDtoPage = ordersService.userPage(page,pageSize);
        return R.success(ordersDtoPage);
    }

}

