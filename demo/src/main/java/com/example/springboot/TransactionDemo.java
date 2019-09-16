package com.example.springboot;

import com.example.springboot.serivce.ProcessElementimpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Transactional.class)//webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
@WebAppConfiguration
//@WebAppConfiguration web模块 ：AppWebApplicatio
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:"})*/
/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = TransactionDemo.class)*/
public class TransactionDemo {
/*
    @Autowired
    private IprocessElementService processElementService;*/

    @Before
 public void before(){

        System.out.println("开始执行测试方法");

    }

    @Test
   public void open(){
        //iprocessElementService= ApplicationContextProvider.getBean(iprocessElementService.getClass());
        ProcessElementimpl processElementimpl = new ProcessElementimpl();

        processElementimpl.transacation();
        System.out.println("事务执行测试");
    }


    @After
    public void after(){
        System.out.println("完成test方法，结束");

    }
}
