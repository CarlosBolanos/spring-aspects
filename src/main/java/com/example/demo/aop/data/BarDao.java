package com.example.demo.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class BarDao {

    public String retrieveSomething(){
        return "BarDao";
    }
}
