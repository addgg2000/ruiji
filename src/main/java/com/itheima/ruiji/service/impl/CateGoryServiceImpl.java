package com.itheima.ruiji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.ruiji.common.CustomException;
import com.itheima.ruiji.entity.Category;
import com.itheima.ruiji.entity.Dish;
import com.itheima.ruiji.entity.Setmeal;
import com.itheima.ruiji.mapper.CategoryMapper;
import com.itheima.ruiji.service.CategoryService;
import com.itheima.ruiji.service.DishService;
import com.itheima.ruiji.service.SetmealService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CateGoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Resource
    private DishService dishService;

    @Resource
    private SetmealService setmealService;

    @Override
    public void delete(Long ids) {
        // 查询是否有与该分类关联的菜品和套餐
        List<Dish> dishes = dishService.list(new QueryWrapper<Dish>().eq("category_id", ids));
        if (dishes.size() > 0){
            throw new CustomException("有已管理的菜品，无法删除");
        }
        List<Setmeal> setmeals = setmealService.list(new QueryWrapper<Setmeal>().eq("category_id", ids));
        if (setmeals.size()> 0){
            throw new CustomException("有已管理的套餐，无法删除");
        }
        removeById(ids);
    }

}
