package com.neymarjr.websecond.service;

import com.neymarjr.websecond.model.Borrow;
import com.neymarjr.websecond.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/*
 *created 24/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class PayService {
//    @Autowired
//    InterestServer interestServer;

//    public ArrayList<Status<String, Number, String>> getStatus(Borrow borrow){
//        ArrayList<Status<String, Number, String>> tempAL = new ArrayList<>();
//        int number = borrow.getMonth();
//        ArrayList<String> listMonth = interestServer.getListMonths(number);
//        ArrayList<Number> listMoney = interestServer.getListMoney(borrow);
//        String status = borrow.getStatus();
//        String nameStatus =null;
//        for (int i = 0 ; i < number; i++){
//            if (status.charAt(i) == '0')
//                nameStatus= "Chưa trả";
//            else {
//                nameStatus= "Đã trả";
//            }
//            Status<String, Number, String> temp
//                    = new Status<>(listMonth.get(i), listMoney.get(i), nameStatus );
//            tempAL.add(temp);
//        }
//        return tempAL;
//    }

    public Borrow payMoneyMonth(int month, Borrow borrow){
        String status = borrow.getStatus();
        System.out.println(status);
        char[] tempChar = status.toCharArray();

        tempChar[month-1] = '1';
        for (int i = 0 ; i < month ; i++){
            System.out.print(tempChar[i]);
        }
        String temp = new String(tempChar);
        borrow.setStatus(temp);
        return borrow;
    }
}
