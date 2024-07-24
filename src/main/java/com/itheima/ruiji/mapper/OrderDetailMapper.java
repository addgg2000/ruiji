package com.itheima.ruiji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.ruiji.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}
