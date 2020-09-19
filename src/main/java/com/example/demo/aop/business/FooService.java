package com.example.demo.aop.business;

import com.example.demo.aop.data.FooDao;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    private final FooDao fooDao;

    public FooService(FooDao fooDao) {
        this.fooDao = fooDao;
    }

    public String calculateSomething(){
        return fooDao.retrieveSomething();
    }
}
