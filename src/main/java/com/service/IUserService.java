package com.service;

import com.entity.Bill;
import com.entity.Users;

import java.util.List;

public interface IUserService {

    List<Users> selectAll();

    List<Bill> selectAllBill();

    List<Bill> selectPageBill(String page,String rows);
}
