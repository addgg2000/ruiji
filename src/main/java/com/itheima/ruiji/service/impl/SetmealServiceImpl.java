package com.itheima.ruiji.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.ruiji.dto.SetmealDto;
import com.itheima.ruiji.entity.Setmeal;
import com.itheima.ruiji.mapper.SetmealMapper;
import com.itheima.ruiji.service.SetmealService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Override
    public void add(SetmealDto setmealDto) {

    }

    @Override
    public Page<SetmealDto> getPage(Integer page, Integer pageSize, String name) {
        return null;
    }

    @Override
    public SetmealDto getSetmeal(Long ids) {
        return null;
    }

    @Override
    public void updateSetmeal(SetmealDto setmealDto) {

    }

    @Override
    public void delete(String ids) {

    }

    @Override
    public boolean save(Setmeal entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<Setmeal> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Setmeal> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Setmeal> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<Setmeal> queryWrapper) {
        return false;
    }

    @Override
    public boolean updateById(Setmeal entity) {
        return false;
    }

    @Override
    public boolean update(Setmeal entity, Wrapper<Setmeal> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Setmeal> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Setmeal entity) {
        return false;
    }

    @Override
    public Setmeal getOne(Wrapper<Setmeal> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public Object getObj(Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public int count(Wrapper<Setmeal> queryWrapper) {
        return 0;
    }

    @Override
    public List<Setmeal> list(Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Setmeal> page(IPage<Setmeal> page, Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<Setmeal> queryWrapper) {
        return null;
    }

    @Override
    public IPage<Map<String, Object>> pageMaps(IPage<Setmeal> page, Wrapper<Setmeal> queryWrapper) {
        return null;
    }
}
