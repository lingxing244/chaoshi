package com.service.impl;

import com.dao.IBillDao;
import com.dao.IUsersDao;
import com.entity.Bill;
import com.entity.Users;
import com.service.IUserService;
import java.util.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private IUsersDao usersDao;
    @Autowired
    private IBillDao billDao;

    public List<Users> selectAll() {
        return usersDao.selectAll();
    }

    public List<Bill> selectAllBill(Bill bill) {
        return billDao.selectAll(bill);
    }

    public List<Bill> selectPageBill(String page, String rows, Bill bill) {
        Integer pages = Integer.parseInt(page);
        Integer row = Integer.parseInt(rows);
        Map<String,Object> mp = new HashMap<String,Object>();
        Integer pag = (pages-1)*row;
        mp.put("page", pag);
        mp.put("rows", row);
        mp.put("productname",bill.getProductname());
        mp.put("ispayment",bill.getIspayment());
        mp.put("proname",bill.getProname());
        System.out.println("--page = "+pag+"--rows = "+row);
        return billDao.selectPageBill(mp);
    }

    public Users selectUser(Users user) {
        return usersDao.selectUser(user);
    }
}
