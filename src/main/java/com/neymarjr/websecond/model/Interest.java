package com.neymarjr.websecond.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

/*
 *created 10/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Data
public class Interest implements Serializable {
    public static final long serialVersionUID = 1L;
    private Long month;
    private Long totalRemain;
    private Long origin;
    private Long interest;
    private Long originAndInterest;

    public Interest(Long month, Long totalRemain, Long origin, Long interest, Long originAndInterest) {
        this.month = month;
        this.totalRemain = totalRemain;
        this.origin = origin;
        this.interest = interest;
        this.originAndInterest = originAndInterest;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getTotalRemain() {
        return totalRemain;
    }

    public void setTotalRemain(Long totalRemain) {
        this.totalRemain = totalRemain;
    }

    public Long getOrigin() {
        return origin;
    }

    public void setOrigin(Long origin) {
        this.origin = origin;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getOriginAndInterest() {
        return originAndInterest;
    }

    public void setOriginAndInterest(Long originAndInterest) {
        this.originAndInterest = originAndInterest;
    }
}
