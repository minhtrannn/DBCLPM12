package com.neymarjr.websecond.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
 *created 13/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Entity
@Data
public class Borrow  implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;

    private Long user_id;

    private Long totalMoney;


    private Long day;
    private Long month;
    private Long year;

    private Long duration;


    private String status;


    // hình thức trả lãi
    // 0 : Tính lãi theo dư nợ gốc ban đầu
    // 1 : Tính lãi theo dư nợ giảm dần
    private String interest_pay_medthod;

    // Loại vay
    // 0: Vay mua bất động sản
    // 1: Vay mua ô tô
    //2: Vay tiêu dùng tín chấp
    private String type_borrow;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public Long getDay() {
        return day;
    }

    public Long getMonth() {
        return month;
    }

    public Long getYear() {
        return year;
    }

    public Long getDuration() {
        return duration;
    }

    public String getStatus() {
        return status;
    }

    public String getInterest_pay_medthod() {
        return interest_pay_medthod;
    }

    public String getType_borrow() {
        return type_borrow;
    }
}
