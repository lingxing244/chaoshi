package com.dao;

import com.entity.Bill;
import com.entity.Users;

import java.util.List;

public interface IUsersDao {

    List<Users> selectAll();

    Users selectUser(Users user);
}
