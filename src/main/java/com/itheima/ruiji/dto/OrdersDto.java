package com.itheima.ruiji.dto;


import com.itheima.ruiji.entity.OrderDetail;
import com.itheima.ruiji.entity.Orders;
import lombok.Data;
import java.util.List;

@Data
public class OrdersDto extends Orders {

    private List<OrderDetail> orderDetails;
	
}
