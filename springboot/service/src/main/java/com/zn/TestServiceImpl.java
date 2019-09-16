package com.zn;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
   // @Transactional(rollbackFor = RuntimeException.class)
    public String test() {
        System.out.println("complete" );
        return "一个测试方法";
    }
}
