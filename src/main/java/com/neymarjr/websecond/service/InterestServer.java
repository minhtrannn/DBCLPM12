package com.neymarjr.websecond.service;


import com.neymarjr.websecond.domain.User;
import com.neymarjr.websecond.model.Borrow;
import com.neymarjr.websecond.model.Interest;
import com.neymarjr.websecond.repository.BorrowRepo;
import com.neymarjr.websecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
 *created 15/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class InterestServer {
    @Autowired
    BorrowRepo borrowRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;



    public ArrayList<Interest> getInterestList(){
        System.out.println("start tính lãi.");
        ArrayList<Interest> interestList = new ArrayList<>();
        User user = userService.getCurrentUser();
        Long borrow_id = user.getBorrow_id();
        Borrow borrow = borrowRepo.findBorrowById(borrow_id);
        double rate = 11.2/12;
        String pay_method=borrow.getInterest_pay_medthod();

        if (pay_method.equals("Tính lãi theo dư nợ gốc ban đầu")){
            System.out.println("Tính lãi theo dư nợ gốc ban đầu");
                interestList=getInterestBaseOnTotal(borrow);
        }
        else {
            System.out.println("Tính lãi theo dư nợ giảm dần");
            interestList=getBaseOnRemain(borrow);
        }
        return interestList;
    }

    private ArrayList<Interest> getInterestBaseOnTotal(Borrow borrow){
        Long duration = borrow.getDuration();
        double total = borrow.getTotalMoney();
        ArrayList<Interest> interestList = new ArrayList<>();
        double rate = 11.2/duration;
        Interest temp = new Interest((long) 0, (long) total, (long) 0, (long) 0, (long) 0);
        interestList.add(temp);
        double originPerMonth = total/duration;
        double totalRemain = total;
        for (int i = 1; i<= duration ; i++ ){
            double interestPerMon = total * rate/100;
            double interestAndOrigin = interestPerMon + originPerMonth;
            totalRemain = totalRemain - originPerMonth;
            temp = new Interest( (long) i, Math.round(totalRemain), Math.round(originPerMonth), Math.round(interestPerMon) , Math.round(interestAndOrigin));
            interestList.add(temp);
        }
        return interestList;
    }

    private ArrayList<Interest> getBaseOnRemain(Borrow borrow){
        Long duration = borrow.getDuration();
        double total = borrow.getTotalMoney();
        ArrayList<Interest> interestList = new ArrayList<>();
        double rate = 11.2/duration;
        Interest temp = new Interest((long) 0, (long) total, (long) 0, (long) 0, (long) 0);
        interestList.add(temp);
        double originPerMon = total/duration;
        double totalRemain = total;
        for (int i = 1; i<= duration ; i++){
            double interestThisMon = totalRemain * rate /100;
            double interestAndOrigin = originPerMon + interestThisMon;
            totalRemain -= originPerMon;
            temp = new Interest((long) i, Math.round(totalRemain), Math.round(originPerMon), Math.round(interestThisMon), Math.round(interestAndOrigin));
            interestList.add(temp);
        }
        return interestList;
    }
}

