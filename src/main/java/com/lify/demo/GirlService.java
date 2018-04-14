package com.lify.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        try{
            Girl A = new Girl();
            A.setAge(11);
            A.setCupSize("A");
            girlRepository.save(A);
            Girl B = new Girl();
            B.setAge(12);
            B.setCupSize("BB");
            girlRepository.save(B);
        }   catch (Exception e){
            e.printStackTrace();
        }
    }
}

