package com.example.springboot.serivce;

import com.example.springboot.entity.ProcessElement;
import com.example.springboot.mappers.ProcessElementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ProcessElementimpl implements IprocessElementService{


    @Autowired
    ProcessElementMapper mapper;


    @Override
    public int insert(ProcessElement p) {
        return mapper.insertSelective(p);
    }

    @Override
    public int update(ProcessElement q) {
        return mapper.updateByPrimaryKeySelective(q);
    }

    @Override
    public ProcessElement querybyid(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void  transacation(){

        ProcessElement processElement = new ProcessElement();
        processElement.setcId(4L);
        processElement.setcElcode("one");
        processElement.setcElname("film2");
        processElement.setCreatedBy("aibo");
        processElement.setCreatedTime(new Date());
        processElement.setcLable("Y");
        try {
            mapper.insertSelective(processElement);
            ProcessElement processElement1 = mapper.selectByPrimaryKey(4L);
            System.out.println(processElement1);
            processElement.setcElname("houzi");
            int updateresult = mapper.updateByPrimaryKeySelective(processElement);
    /*        int result = mapper.insertSelective(processElement);
            System.out.println("插入执行成功，id=："+result);
            ProcessElement returnprocess = mapper.selectByPrimaryKey((long)result);
            processElement.setCElcode("kongfu panda2");
            int updateresult = mapper.updateByPrimaryKeySelective(processElement);
            System.out.println("更新返回结果："+updateresult);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
