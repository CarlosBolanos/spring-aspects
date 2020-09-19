package com.example.demo.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class FooDao {

    public String retrieveSomething(){
        return "FooDao";
    }
}
