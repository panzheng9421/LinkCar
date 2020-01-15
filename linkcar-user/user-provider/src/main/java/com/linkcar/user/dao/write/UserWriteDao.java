package com.linkcar.user.dao.write;

import com.linkcar.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserWriteDao {

    int deleteById(Integer id);

    int insert(User record);

    int updateById(User record);

}