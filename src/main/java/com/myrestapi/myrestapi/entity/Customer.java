package com.myrestapi.myrestapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "customername")
    private String name;

    private String email;

    private String address;

    private String city;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "birthday")
    private Date birthday;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "created_date")
    private Date created_date;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "modify_date")
    private Date modify_date;

    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_day) {
        this.created_date = created_day;
    }

    public Date getModify_date() {
        return modify_date;
    }

    public void setModify_date(Date modify_day) {
        this.modify_date = modify_day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }
}