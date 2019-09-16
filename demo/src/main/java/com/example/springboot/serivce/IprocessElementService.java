package com.example.springboot.serivce;

import com.example.springboot.entity.ProcessElement;
import org.springframework.transaction.annotation.Transactional;

public interface IprocessElementService {

      public int insert(ProcessElement p);

      int update(ProcessElement q);

      ProcessElement querybyid(Long id);


      public void  transacation();



}
