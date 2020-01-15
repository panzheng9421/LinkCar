package com.linkcar.user.dao.read;

import com.linkcar.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserReadDao {

    User getById(Integer id);

}