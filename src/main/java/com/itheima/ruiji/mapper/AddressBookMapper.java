package com.itheima.ruiji.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.ruiji.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 地址管理 Mapper 接口
 * </p>
 *
 * @author anyi
 * @since 2022-05-25
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {

}
