package com.dao;

import com.entity.Users;

import java.util.List;

public interface IUsersDao {

    List<Users> selectAll();
}
