package com.itheima.ruiji.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.ruiji.common.UserContext;
import com.itheima.ruiji.entity.AddressBook;
import com.itheima.ruiji.mapper.AddressBookMapper;
import com.itheima.ruiji.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 地址管理 服务实现类
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    /**
     * 设置默认地址
     * @param addressBook
     */
    @Override
    public void setDefault(AddressBook addressBook) {
        // 首相把所有地址的 isDefault设置为 0
        Long userId = UserContext.getUserId();
        LambdaQueryWrapper<AddressBook> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AddressBook::getUserId,userId);
        AddressBook ad = new AddressBook();
        ad.setIsDefault(false);
        update(ad, wrapper);
        // 把当前id地址设置为1
        addressBook.setIsDefault(true);
        updateById(addressBook);
    }
}
