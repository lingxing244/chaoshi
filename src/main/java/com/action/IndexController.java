package com.action;

import com.entity.Bill;
import com.entity.BillData;
import com.entity.Users;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSON;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    private IUserService us;

    @RequestMapping(value = "/testUs",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object testUs() throws Exception{
        String js = "";
        System.out.println("----------------hahha ");
        List<Users> list = us.selectAll();

        js = JSON.toJSONString(list);
        System.out.println("----------json = " +js);

        return js;

    }
    @RequestMapping(value = "/selectAll",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object selectAll(String page,String rows,String sort,String order) throws Exception{
        String js = "";
        System.out.println("----------------hahha ");
        List<Bill> list = us.selectAllBill();
        List<Bill> slist = us.selectPageBill(page,rows);
        BillData bd = new BillData();
        bd.setTotal(list.size());
        bd.setRows(slist);
        js = JSON.toJSONString(bd);
        System.out.println("----------json = " +js);

        return js;

    }
}
