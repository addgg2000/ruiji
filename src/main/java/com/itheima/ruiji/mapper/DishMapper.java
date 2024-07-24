package com.itheima.ruiji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.ruiji.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品管理 Mapper 接口
 * </p>
 *
 * @author anyi
 * @since 2022-05-24
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {

}
