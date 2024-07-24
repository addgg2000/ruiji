package com.itheima.ruiji.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.ruiji.dto.OrdersDto;
import com.itheima.ruiji.entity.Orders;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
public interface OrdersService extends IService<Orders> {

    void addOrders(Orders orders);

    Page<OrdersDto> userPage(Integer page, Integer pageSize);
}
