package com.neymarjr.websecond.validator;

import com.neymarjr.websecond.model.Borrow;
import com.neymarjr.websecond.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *created 14/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class BorrowValidator {
        public ArrayList<String> getListError(Borrow borrow){
            ArrayList<String> listError = new ArrayList<>();
            if (!isTotalMoneyValid(borrow.getTotalMoney()))
                listError.add("Số tiền vay không hợp lệ");

            String date = "";
            date += borrow.getDay()  + "/";
            date += borrow.getMonth() + "/";
            date += borrow.getYear();
            if (!isDateValid(date))
                listError.add("Ngày vay không hợp lệ.");

            if (!isTypeBorrow(borrow.getType_borrow()))
                listError.add("Loại vay không hợp lệ.");

            if (!isDurationValid(borrow.getDuration()))
                listError.add("Thời hạn không hợp lệ.");

            if(!isPayMethodValid(borrow.getInterest_pay_medthod()))
                listError.add("Hình thức tính lãi không hợp lệ");
            return  listError;
        }

        private boolean isPayMethodValid(String payMethod){
            if (payMethod.equals("Tính lãi theo dư nợ gốc ban đầu"))
                return  true;
            if (payMethod.equals("Tính lãi theo dư nợ giảm dần"))
                return  true;
            return  false;
        }

        private  boolean isTypeBorrow(String type){
            if (type.equals("Vay mua bất động sản"))
                return  true;
            if (type.equals("Vay mua ô tô"))
                return  true;
            if (type.equals("Vay tiêu dùng tín chấp"))
                return  true;
            return  false;
        }

        private boolean isDurationValid(Long duration){
            if (duration == 6 || duration == 12 || duration == 18 || duration == 24)
                return  true;
            return  false;
        }

        private boolean isDateValid(String date){
            String regx = "";
            regx += "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)"
                    + "(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?"
                    + "\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?"
                    + "(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|"
                    + "[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)"
                    + "(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(date);
            return matcher.find();
        }
        private  boolean  isTotalMoneyValid(Long money) {
            if (money < 0)
                return false;
            return true;
        }

}
