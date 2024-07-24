package com.itheima.ruiji.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.ruiji.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品及套餐分类 Mapper 接口
 * </p>
 *
 * @author anyi
 * @since 2022-05-24
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
