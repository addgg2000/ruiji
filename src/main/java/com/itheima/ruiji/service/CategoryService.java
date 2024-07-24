package com.itheima.ruiji.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.ruiji.entity.Category;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品及套餐分类 服务类
 * </p>
 *
 * @author anyi
 * @since 2022-05-24
 */

public interface CategoryService extends IService<Category> {

    void delete(Long ids);

}
