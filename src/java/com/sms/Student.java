/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms;

import java.util.Date;  
  
public class Student {  
    private int sid;  
    private String fname, lname, email, mobile, insertedBy, updatedBy;  
    private Date dob, insertedOn, updatedOn;  
      
    public int getSid() {  
        return sid;  
    }  
    public void setSid(int sid) {  
        this.sid = sid;  
    }  
    public String getFname() {  
        return fname;  
    }  
    public void setFname(String fname) {  
        this.fname = fname;  
    }  
    public String getLname() {  
        return lname;  
    }  
    public void setLname(String lname) {  
        this.lname = lname;  
    }  
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
    public String getMobile() {  
        return mobile;  
    }  
    public void setMobile(String mobile) {  
        this.mobile = mobile;  
    }  
    public String getInsertedBy() {  
        return insertedBy;  
    }  
    public void setInsertedBy(String insertedBy) {  
        this.insertedBy = insertedBy;  
    }  
    public String getUpdatedBy() {  
        return updatedBy;  
    }  
    public void setUpdatedBy(String updatedBy) {  
        this.updatedBy = updatedBy;  
    }  
    public Date getDob() {  
        return dob;  
    }  
    public void setDob(Date dob) {  
        this.dob = dob;  
    }  
    public Date getInsertedOn() {  
        return insertedOn;  
    }  
    public void setInsertedOn(Date insertedOn) {  
        this.insertedOn = insertedOn;  
    }  
    public Date getUpdatedOn() {  
        return updatedOn;  
    }  
    public void setUpdatedOn(Date updatedOn) {  
        this.updatedOn = updatedOn;  
    }  
}  