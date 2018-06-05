package com.lify.service;

import com.lify.domain.Girl;
import com.lify.enums.GirlExceptionCode;
import com.lify.exception.GirlException;
import com.lify.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        try {
            Girl A = new Girl();
            A.setAge(11);
            A.setCupSize("A");
            girlRepository.save(A);
            Girl B = new Girl();
            B.setAge(12);
            B.setCupSize("BB");
            girlRepository.save(B);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        if (girl == null) {
            throw new GirlException(GirlExceptionCode.EXCEPTION_CODE1);
        }
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(GirlExceptionCode.EXCEPTION_CODE2);
        } else if (age >= 10 && age < 16) {
            throw new GirlException(GirlExceptionCode.EXCEPTION_CODE3);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}

