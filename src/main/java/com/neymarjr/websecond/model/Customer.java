package com.neymarjr.websecond.model;

import com.neymarjr.websecond.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Entity
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = -297553281792804396L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    private Long user_id;

    //Họ và tên
    private String fullname;

    // số đt
    private String phoneNumber;

    //hộ khẩu
    private String household;

    //Địa chỉ
    private String address;

    // Dân tộc
    private String folk;

    // Mức lương
    private long salary;

    // Giới tính
    private String sex;

    //so cmnd
    private String cmnd;

    //mã tỉnh
    private String provinceCode;

    //ngày tháng năm sinh
    private Long day;
    private Long month;
    private Long year;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHousehold() {
        return household;
    }

    public String getAddress() {
        return address;
    }

    public String getFolk() {
        return folk;
    }

    public long getSalary() {
        return salary;
    }

    public String getSex() {
        return sex;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getProvinceCode() {
        return provinceCode;
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
}
