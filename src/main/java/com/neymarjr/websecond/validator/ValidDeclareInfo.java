package com.neymarjr.websecond.validator;

import com.neymarjr.websecond.model.Customer;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.xml.ws.ServiceMode;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidDeclareInfo {
    public ArrayList<String> getListErr(Customer customer){
        ArrayList<String> listError = new ArrayList<>();
        String name = customer.getFullname();
        if (!isNameValid(name))
            listError.add("Họ tên không hợp lệ.");

        String household = customer.getHousehold();
        if (!isHouseholdValid(household))
            listError.add("Hộ khẩu không hợp lệ.");

        String date= "";
        date += customer.getDay() + "/";
        date += customer.getMonth() + "/";
        date += customer.getYear();
        if (!isDateValid(date))
            listError.add("Ngày sinh không hợp lệ.");

        System.out.println("validating Chứng minh: "+customer.getCmnd() );
        if (!isCmndValid(customer.getCmnd()))
            listError.add("Chứng minh nhân dân không hợp lệ.");

        if (!isSexValid(customer.getSex()))
            listError.add("Giới tính không hợp lệ.");

        if (!isCityValid(customer.getProvinceCode()))
            listError.add("Mã tĩnh không hợp lệ");

        if (!isSalaryValid(customer.getSalary()))
            listError.add("Mức lương không hợp lệ.");

        if (!isFolkValid(customer.getFolk()))
            listError.add("Dân tộc không hợp lệ");

        if (!isPhoneValid(customer.getPhoneNumber()))
            listError.add("Số điện thoại không hợp lệ.");

        return listError;

    }

    private  boolean isFolkValid(String folk){
        if (folk.equals("kinh"))
            return  true;
        if (folk.equals("tày"))
            return true;
        if (folk.equals("mường"))
            return  true;
        if (folk.equals("hmong"))
            return  true;
        return  false;
    }

    private  boolean isSalaryValid(Long salary){
        if (salary > 1500000)
            return true;
        return  false;
    }
    private  boolean isSexValid(String sex){
        if (sex.equals("male") || sex.equals("female")) return true;
        return false;
    }

    private  boolean isCityValid(String city){
        if (city.equals("Hà Nội"))
            return true;
        if (city.equals("Hồ Chí Minh"))
            return true;
        if (city.equals("Hải Phòng"))
            return true;
        if (city.equals("Đà Nẵng"))
            return  true;
        if (city.equals("Hà Giang"))
            return true;
        return  false;
    }
    private  boolean isCmndValid(String cmnd){
        String regx = "^[0-9]{9,12}$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cmnd);
        if (cmnd.equals("123456789")){
            return  false;
        } else if (cmnd.equals("987654321")){
            return  false;
        }
        else {
            return matcher.find();
        }
    }
    private boolean isNameValid(String name){
        if (StringUtils.isEmptyOrWhitespace(name))
            return false;
        String regx = "^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    private  boolean isPhoneValid(String phone){
        String regx = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        regx = "^\\+?(?:0|84)(?:\\d){9}$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.find();
    }

    private  boolean isHouseholdValid(String household){
        if (StringUtils.isEmptyOrWhitespace(household))
            return false;
        String regx = "^(?:[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s[\\p{L}\\p{Mn}\\p{Pd}\\'\\x{2019}]+\\s?)+$";
        Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(household);
        return matcher.find();
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
}
