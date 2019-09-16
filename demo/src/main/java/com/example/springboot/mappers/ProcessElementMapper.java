package com.example.springboot.mappers;

import com.example.springboot.entity.ProcessElement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
//@Mapper
public interface ProcessElementMapper {
    /**
     *
     * @mbggenerated 2019-07-21
     */
    int deleteByPrimaryKey(Long cId);

    /**
     *
     * @mbggenerated 2019-07-21  @Param("process")
     */
    int insert( ProcessElement process);

    /**
     *
     * @mbggenerated 2019-07-21
     */
    int insertSelective(ProcessElement record);

    /**
     *
     * @mbggenerated 2019-07-21
     */
    ProcessElement selectByPrimaryKey(Long cId);

    /**
     *
     * @mbggenerated 2019-07-21
     */
    int updateByPrimaryKeySelective(ProcessElement record);

    /**
     *
     * @mbggenerated 2019-07-21
     */
    int updateByPrimaryKey(ProcessElement record);
}