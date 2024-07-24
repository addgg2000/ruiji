package com.itheima.ruiji.dto;

import com.itheima.ruiji.entity.Dish;
import com.itheima.ruiji.entity.DishFlavor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 安逸i
 * @version 1.0
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}

