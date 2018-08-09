package com.service;

import com.entity.Bill;

import java.util.List;

public interface IBillService {

    Integer delBill(String billcode);

    Long selectProId(String proname);

    Integer innertBill(Bill bill);
}
