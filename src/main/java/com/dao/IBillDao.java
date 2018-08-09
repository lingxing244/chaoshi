package com.dao;

import com.entity.Bill;

import java.util.List;
import java.util.Map;

public interface IBillDao {

    List<Bill> selectAll(Bill bill);

    List<Bill> selectPageBill(Map<String,Object> mp);

    Integer delBill(String billcode);

    Integer innertBill(Bill bill);

}
