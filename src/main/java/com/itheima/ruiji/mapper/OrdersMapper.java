package com.itheima.ruiji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.ruiji.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {

}
