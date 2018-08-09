package com.service.impl;

import com.dao.IBillDao;
import com.dao.IProviderDao;
import com.entity.Bill;
import com.service.IBillService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@MapperScan(basePackages = "com.dao")
@Service("billService")
public class BillService implements IBillService {
    @Autowired
    private IBillDao billDao;
    @Autowired
    private IProviderDao providerDao;

    public Integer delBill(String billcode) {

        return billDao.delBill(billcode);
    }

    public Long selectProId(String proname) {
        return providerDao.selectProId(proname);
    }

    public Integer innertBill(Bill bill) {
        return billDao.innertBill(bill);
    }
}
