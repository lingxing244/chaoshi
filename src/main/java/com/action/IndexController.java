package com.action;

import com.entity.Bill;
import com.entity.BillData;
import com.entity.Provider;
import com.entity.Users;
import com.service.IBillService;
import com.service.IProviderService;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    private IBillService bs;
    @Autowired
    private IProviderService ps;
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
    @RequestMapping(value = "/getProname",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object getProname(){
        String js = "";
        List<Provider> plist = ps.selectAllProvice();
        js = JSON.toJSONString(plist);
        System.out.println("----------json = " +js);
        return js;
    }
    @RequestMapping(value = "/selectAll",produces = {"application/json; charset=UTF-8"})
    @ResponseBody
    public Object selectAll(HttpSession session,String page,String rows,String sort,String order,Bill bill) throws Exception{
        String js = "";
        //Users user = (Users) session.getAttribute("userinfo");
        //System.out.println("----------------hahha ");
        System.out.println("--------"+bill);
        //boolean ck = bill.getProname()==null&&bill.getProductname()==null&&bill.getIspayment()==null;
        BillData bd = new BillData();
        List<Bill> list = us.selectAllBill(bill);
        List<Bill> slist = us.selectPageBill(page,rows,bill);
        for(Bill bi:slist){
            Provider pr = bi.getProvider();
            bi.setProname(pr.getProname());
        }
        bd.setTotal(list.size());
        bd.setRows(slist);
        //System.out.println(slist);
        js = JSON.toJSONString(bd);
        System.out.println("----------json = " +js);

        return js;

    }
    @RequestMapping("/updateBill")
    public void updateBill(HttpServletResponse response,Bill bill){
        System.out.println("---------UPDATE");
        System.out.println("---------"+bill);
    }
    @RequestMapping("/getUserName")
    public void getUserName(HttpServletResponse response, HttpSession session) throws Exception{
        //request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //System.out.println("-----------------getUserName");
        PrintWriter out = response.getWriter();
        Users u = (Users) session.getAttribute("userinfo");
        String username = u.getUsername();
        //System.out.println("-----------------"+username);
        out.print(username);
        out.flush();
        out.close();
    }
    @RequestMapping("/delBill")
    public void delDemo(HttpServletResponse response, String billcode) throws Exception{

        System.out.println("-----------------delBill");
        PrintWriter out = response.getWriter();
        System.out.println("-----------------billcode = "+billcode);
        Integer num = bs.delBill(billcode);
        System.out.println("-------------num = "+num);
        if(num > 0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
    @RequestMapping("/login")
    public void login(HttpServletResponse response, HttpSession session, String username, String password) throws IOException {
        PrintWriter out = response.getWriter();
        Users user = new Users();
        user.setUsercode(username);
        user.setUserpassword(password);
        Users u = us.selectUser(user);
        System.out.println("--------"+u);
        if (u!=null){
            session.setAttribute("userinfo",u);
            out.print("true");
        }else{
            out.print("false");
        }
        out.flush();
        out.close();
    }
}
