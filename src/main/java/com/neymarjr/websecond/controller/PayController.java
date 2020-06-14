//package com.neymarjr.websecond.controller;
//
//import com.neymarjr.websecond.model.Borrow;
//import com.neymarjr.websecond.model.Customer;
//import com.neymarjr.websecond.model.Month;
//import com.neymarjr.websecond.model.Status;
//import com.neymarjr.websecond.service.BorrowService;
//import com.neymarjr.websecond.service.CustomerService;
//import com.neymarjr.websecond.service.InterestServer;
//import com.neymarjr.websecond.service.PayService;
//import javafx.util.Pair;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//
///*
// *created 23/03/2020
// *project IntelliJ IDEA
// *author NeymarJr
// */
//@Controller
//public class PayController {
//    @Autowired
//    CustomerService customerService;
//
//    @Autowired
//    InterestServer interestServer;
//
//    @Autowired
//    BorrowService borrowService;
//
//    @Autowired
//    PayService payService;
//
//    @GetMapping("/payMoney")
//    public String payMoney(Model model,
//                           @RequestParam(value = "id", required = false) String cmnd){
//        Customer customer = customerService.findCustomerByCmnd(cmnd);
//        String nameGet = customer.getFullname();
//
//
//        Borrow borrowGet = borrowService.findBorrowByCustomerId(customer.getId());
//        String payMethod = interestServer.getPayMethod(borrowGet.getInterest_pay_medthod());
//
//        String borrowDate = interestServer.getBorrowDate(borrowGet);
//        System.out.println(borrowDate);
//
//        ArrayList<Status<String, Number, String>> listMonthMoneyStatus = payService.getStatus(borrowGet);
//
//        Month thang = new Month(12, "12345");
//
//        thang.setCm(customer.getCmnd());
//
//        ArrayList<Integer> totalMon = new ArrayList<>();
//        for (int i = 1; i<= borrowGet.getMonth();i++){
//            totalMon.add(i);
//        }
//
//        model.addAttribute("payMethod", payMethod);
//        model.addAttribute("nameGet", nameGet);
//        model.addAttribute("cmndGet", cmnd);
//        model.addAttribute("borrowGet", borrowGet);
//        model.addAttribute("customerGet", customer);
//        model.addAttribute("borrowDate", borrowDate);
//        model.addAttribute("listMonthMoneyStatus", listMonthMoneyStatus);
//        model.addAttribute("typeBorrow", borrowGet.getType_borrow());
//        model.addAttribute("debt", borrowGet.getDebt());
//        model.addAttribute("thang", thang);
//        model.addAttribute("totalMon", totalMon);
//        return "payMoney";
//    }
//
//    @PostMapping("/payMoney")
//    public String payMoney(@ModelAttribute  Month months ){
//        System.out.println(months.getMonths());
//        System.out.println("Cmnd customer: "+months.getCm());
//        String cmnd = months.getCm();
//        Customer customer = customerService.findCustomerByCmnd(cmnd);
//        Borrow borrow = borrowService.findBorrowByCustomerId(customer.getId());
//        borrow = payService.payMoneyMonth(months.getMonths(), borrow);
//        borrowService.updateBorrow(borrow);
//        System.out.println("Tra tien thang: "+months.getMonths());
//        return "success";
//    }
//}
