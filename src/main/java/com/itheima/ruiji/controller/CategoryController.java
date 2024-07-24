package com.itheima.ruiji.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.ruiji.common.BaseContext;
import com.itheima.ruiji.common.R;
import com.itheima.ruiji.common.UserContext;
import com.itheima.ruiji.entity.Category;
import com.itheima.ruiji.entity.Employee;
import com.itheima.ruiji.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    protected CategoryService categoryService;

    /**
     * 新增分类
     */
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     * 分页查询
     */
    @GetMapping("/page")
    public R<Page> page(Integer page,Integer pageSize){
        //分页构造器
        Page<Category> pageInfo = new Page<>(page,pageSize);
        QueryWrapper<Category> categoryQueryWrapper = new QueryWrapper<>();
        categoryQueryWrapper.orderByDesc("sort");
        //进行分页查询
        categoryService.page(pageInfo,categoryQueryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 删除分类
     */
    @DeleteMapping
    public R delete(Long ids){

        categoryService.removeById(ids);
        return R.success("删除成功");

    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        category.setUpdateTime(new Date());
        category.setUpdateUser(BaseContext.getCurrentId());
        log.info("category" + category.toString());
        categoryService.updateById(category);
        return R.success("修改分类信息成功");
    }
}
