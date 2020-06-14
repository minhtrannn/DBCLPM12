//package com.neymarjr.websecond.controller;
//
//import com.neymarjr.websecond.model.Borrow;
//import com.neymarjr.websecond.model.Customer;
//import com.neymarjr.websecond.service.BorrowService;
//import com.neymarjr.websecond.service.CustomerService;
//import com.neymarjr.websecond.service.InterestServer;
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
//import java.util.Optional;
//import java.util.stream.StreamSupport;
//
///*
// *created 14/03/2020
// *project IntelliJ IDEA
// *author NeymarJr
// */
//@Controller
//public class InterestController {
//
//    @Autowired
//    BorrowService borrowService;
//
//    @Autowired
//    CustomerService customerService;
//
//    @Autowired
//    InterestServer interestServer;
//
//    @GetMapping("/interest")
//    public String interest(Model model, @RequestParam(value = "cmnd", required = false) String cmnd){
//
//        Customer customer = customerService.findCustomerByCmnd(cmnd);
//        String nameGet = customer.getFullname();
//
//        Borrow borrowGet = borrowService.findBorrowByCustomerId(customer.getId());
//        String payMethod = interestServer.getPayMethod(borrowGet.getInterest_pay_medthod());
//
//        String borrowDate = interestServer.getBorrowDate(borrowGet);
//        System.out.println(borrowDate);
//
//        ArrayList<Pair<String, Number>> listMoneyMonth = interestServer.getListPairMoneyMonth(borrowGet);
//
//        model.addAttribute("payMethod", payMethod);
//        model.addAttribute("nameGet", nameGet);
//        model.addAttribute("cmndGet", cmnd);
//        model.addAttribute("borrowGet", borrowGet);
//        model.addAttribute("customerGet", customer);
//        model.addAttribute("borrowDate", borrowDate);
//        model.addAttribute("listMonMon", listMoneyMonth);
//        model.addAttribute("typeBorrow", borrowGet.getType_borrow());
//        return "interest";
//    }
//}
