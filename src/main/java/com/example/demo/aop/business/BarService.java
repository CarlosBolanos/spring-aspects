package com.example.demo.aop.business;

import com.example.demo.aop.data.BarDao;
import org.springframework.stereotype.Service;

@Service
public class BarService {

    private final BarDao barDao;

    public BarService(BarDao barDao) {
        this.barDao = barDao;
    }

    public String calculateSomething() throws Exception {
        try {
            return barDao.retrieveSomething();
        } catch (Exception ex){
            throw new Exception("BarService failed!");
        }
    }
}
