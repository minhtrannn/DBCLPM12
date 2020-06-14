package com.neymarjr.websecond.controller;

import com.neymarjr.websecond.domain.User;
import com.neymarjr.websecond.model.Borrow;
import com.neymarjr.websecond.model.Customer;
import com.neymarjr.websecond.model.Interest;
import com.neymarjr.websecond.repository.BorrowRepo;
import com.neymarjr.websecond.repository.CustomerRepo;
import com.neymarjr.websecond.repository.UserRepository;
import com.neymarjr.websecond.service.*;
import com.neymarjr.websecond.validator.BorrowValidator;
import com.neymarjr.websecond.validator.ValidDeclareInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@org.springframework.stereotype.Controller
public class CustomerController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    UserService userService;
    @Autowired
    BorrowRepo borrowRepo;
    @Autowired
    InterestServer interestServer;
    @Autowired
    ValidDeclareInfo validDeclareInfo;
    @Autowired
    BorrowValidator borrowValidator;

    @GetMapping("/")
    public String index(){ return "home"; }

    @GetMapping("/home")
    public  String home(){
        return "home";
    }

    @GetMapping("/declareInfo")
    public String info(Model model)
    {
        String username = userService.getCurrentUsername();
        User user = userRepository.findByEmail(username);
        System.out.println("declare info: "+ user.getEmail());
        Long customer_id = user.getCustomer_id();
        Customer customer = null;
        customer = customerRepo.findCustomerById(customer_id);
        if (customer == null) {
            customer = new Customer();
        }
        model.addAttribute("customerGet", customer);
        return "declare_information";
    }

    @PostMapping("/declareInfo")
    public String info(@ModelAttribute Customer customerPost, Model model){
        String username = userService.getCurrentUsername();
        User user = userRepository.findByEmail(username);
        System.out.printf(user.getEmail());
        customerPost.setUser_id(user.getId());

        ArrayList<String> listError = validDeclareInfo.getListErr(customerPost);
        model.addAttribute("listError", listError);
        if (listError.size() > 0) {
            model.addAttribute("customerGet", customerPost);
            return "declare_information";
        }

        Customer customerSave = customerRepo.save(customerPost);
        user.setCustomer_id(customerSave.getId());
        userRepository.save(user);
        System.out.println("Save customer done.");
        System.out.println(customerPost.getFullname()+" "+customerPost.getSalary());
        return "home";
    }

    @GetMapping("/borrow")
    public String borrow(Model model){
        String username = userService.getCurrentUsername();
        User user = userRepository.findByEmail(username);
        Long borrow_id = user.getBorrow_id();
        System.out.println(borrow_id);
        Borrow borrow = null;
        borrow = borrowRepo.findBorrowById(borrow_id);
        if (borrow == null){
            borrow = new Borrow();
        }
        model.addAttribute("borrowGet", borrow);
        return "borrow";
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Borrow borrowPost, Model model){

        ArrayList<String> listError = borrowValidator.getListError(borrowPost);

        if (listError.size() > 0){
            model.addAttribute("borrowGet", borrowPost);
            model.addAttribute("listError", listError);
            return "borrow";
        }

        String username = userService.getCurrentUsername();
        User user = userRepository.findByEmail(username);
        borrowPost.setUser_id(user.getId());
        Borrow borrowSaved = borrowRepo.save(borrowPost);
        user.setBorrow_id(borrowSaved.getId());
        userRepository.save(user);
        System.out.println(borrowPost.getDuration());
        System.out.println("save borrow done.");
        return "home";
    }

    @GetMapping("/bill")
    public  String billInfo(Model model){
        ArrayList<Interest> interestList = interestServer.getInterestList();
        Long totalInterest = (long) 0;
        Long totalPay;
        for (Interest in : interestList){
            System.out.println(in.getMonth()+" "+in.getTotalRemain()+" "+in.getOrigin()+" "+in.getInterest()+" "+in.getOriginAndInterest());
            totalInterest += in.getInterest();
        }
        totalPay = interestList.get(0).getTotalRemain()+totalInterest;
        model.addAttribute("totalPay", totalPay);
        model.addAttribute("totalInterest", totalInterest);
        model.addAttribute("interestList", interestList);
        return "bill";
    }
}
