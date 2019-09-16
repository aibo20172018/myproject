package com.example.springboot.serivce;

import com.example.springboot.entity.ProcessElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.ThreadLocals;

import java.util.Date;

@Service
public class doTestService {

    @Autowired
    IprocessElementService service;

    //异常类测试
    @Transactional(rollbackFor = RuntimeException.class)
    public void  transacation(){

/*        ProcessElement processElement = new ProcessElement();
        processElement.setCElcode("gognfu panda");
        processElement.setCDatatype("film");
        processElement.setCElname("abao");
        processElement.setCreatedBy("aib");
        processElement.setCreatedTime(new Date());
        int result = service.insert(processElement);
        System.out.println("插入执行成功，id=："+result);
        ProcessElement returnprocess = service.querybyid((long)result);
        processElement.setCElcode("kongfu panda2");
        int updateresult = service.update(processElement);
        System.out.println("更新返回结果："+updateresult);*/

    }

    public static void main(String[] args) {




    }


}
