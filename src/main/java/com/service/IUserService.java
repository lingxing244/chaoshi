package com.service;

import com.entity.Bill;
import com.entity.Users;

import java.util.List;

public interface IUserService {

    List<Users> selectAll();

    List<Bill> selectAllBill(Bill bill);

    List<Bill> selectPageBill(String page,String rows,Bill bill);

    Users selectUser(Users user);
}
