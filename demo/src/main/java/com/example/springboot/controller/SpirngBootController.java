package com.example.springboot.controller;

import com.example.springboot.entity.ProcessElement;
import com.example.springboot.serivce.ProcessElementimpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.ReflectHelper;


import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1.@RequestBody @Validated UserDTO userDTO 在参数上加校验
 * restful风格用法
 *
 * 在多个参数校验,或者@RequestParam 形式时候,需要在controller上加注@Validated,
 */

@Controller
@RequestMapping("demo")
@Validated
public class SpirngBootController {

    private final static Logger logger = LoggerFactory.getLogger(SpirngBootController .class);

    /**
     *
     */
    //protected static Logger logger = LoggerFactoryactory.getLogger(SpirngBootController.class);
    public static void main(String[] args) {
       /* ProcessElement processElement = new ProcessElement();
        processElement.setUpdateTime(new Date());
        processElement.setCElcode("1");
        String s = processElement.toString();
        boolean consult = s.equals(null);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("启动成功"+simpleDateFormat.format( processElement.getUpdateTime())+"---"+ consult+"--"+processElement.hashCode());*/
       //测试二
      /* Integer total=1;
        mianshi(total);
        System.out.println(total);//3 1 不会改变外部属性的值
        Integer result = findResult();
        System.out.println(result);//8
        stringconpare();*/

       /* Integer o=10;
       List<Integer> list=new ArrayList<Integer>();
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(10);
       for(Integer i:list){
           if(i.equals(10)){
               list.remove(10);//list中remove删除的是下标,抛异常

           }

       }
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
        HashMap<String, Object> ha = new HashMap<>();
        ha.put("1","brave");
        ha.remove("1");
        System.out.println(ha.size());

       Float totalmoney=200000.8f;
         Float usemoney=170000.5f;
        //System.out.println((totalmoney-usemoney));//float默认保留三位小数
        System.out.println(findResult());
   //测试三
        int j = 0;
        for (int i = 0; i < 100; i++) {
            ++j;//++j会同时把j的值改变 j++不会改变j的值，改变的是表达式的值
            if (j == 99) {
                System.out.println("99==j");
            }//循环了100次，j最后=100
        }
        System.out.println(j);

        int[] test = new int[]{1, 2, 3, 4};
        List list = Arrays.asList(test);
        System.out.println(list.size() + "" + list.get(0));//list长度是1, 存入了数组对象
        for (Object i : list) {
            System.out.println("bian：" + i);//[I@7699a589
        }

        Integer[] test2 = new Integer[]{1, 2, 3, 4};
        List list2 = Arrays.asList(test2);//这里参数是可变参数，而不是泛型
        System.out.println(list2.size() + "--" + list2.get(0));//数组转换集合数组中的元素要使用封装类型,集合存的元素应该是封装类型
        for (Object i : list2) {
            System.out.println("封装类型：" + i);//
        }


        System.out.println(4^5);//1
        System.out.println(4&5);
        System.out.println(10>>1);*/
        /**
         * stream() 串行流， parallelStream并行流
       /*  */
        Student student1 = new Student(1L,"小明","广西",20);
        Student student2 = new Student(2L, "小东", "浙江", 23);
        Student student3 = new Student(3L, "小wang", "广东", 26);
        Student student4 = new Student(4L, "", "北京", 29);
        List<Student> students = Arrays.asList(student1,student2,student3);
        List<String> strings = Arrays.asList("111", "222", "333", "999", "777", "666");
/**
 * 测试反射util-对像设置值，获取值
 */
        Field address = ReflectHelper.getFieldByFieldName(student1, "address");
        /*try {
            String name = (String)ReflectHelper.getValueByFieldName(student1, "name");
            System.out.println("--name:"+name);
            ReflectHelper.setValueByFieldName(student1,"name","小凯");
            System.out.println(student1.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

       /* //1.筛选 filter
        Stream<Student> studentStream = students.stream().filter(stu -> "广西".equals(stu.getAddress()));//流
        List<Student> collect = studentStream.collect(Collectors.toList()); //流.collect ->col
        for (Student s: collect) {
            System.out.println(s);
        }
         //2.转换:将对应原素按照给定方法进行转换 map
        List<String> namecollect = students.stream().map(student -> "转换为地址加名字:" + student.getName()+student.getAddress()).collect(Collectors.toList());
        for (String s:namecollect
             ) {
            System.out.println(s);
        }
       //3.简单去重 distinct
        List<String> distinct = strings.stream().distinct().collect(Collectors.toList());
        System.out.println(distinct);
       // strings.stream().distinct().forEach(System.out::println);
       //4.排序 sorted
        List<String> sortlist = strings.stream().sorted().collect(Collectors.toList());
        System.out.println(sortlist);
        //5.自定义规则排序  先按id、再按年龄 降序
        List<Student> distinctsort = students.stream()
                .sorted((stu1, stu2) -> Long.compare(stu2.getId(), stu1.getId()))
                .sorted((stu1, stu2) -> Integer.compare(stu2.getAge(), stu1.getAge())).collect(Collectors.toList());
        System.out.println(distinctsort);
        //6.限制返回条数   limit
        List<String> limitlist = strings.stream().limit(1).collect(Collectors.toList());
        System.out.println(limitlist);
        //7.删除元素，删除前n个元素  skip
        List<String> delete2list = strings.stream().skip(2).collect(Collectors.toList());
        System.out.println(delete2list);
        //8.聚合，聚合成一个元素返回，字符串拼比较合适
        Student student = students.stream().reduce(null, (stu1, stu2) -> stu1);
        System.out.println(student);
        //9.求最小值min().get() 包含对比
        Student minageStudent = students.stream().min((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get();
        System.out.println(minageStudent);
        //10.求最大值，max()
        Student maxageStudent = students.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())).get();
        System.out.println(maxageStudent);
       //11.匹配 anyMatch,allmatch,nonematch
        Boolean anyMatch = students.stream().anyMatch(s ->"上海".equals(s.getAddress()));
        if (!anyMatch) {
            System.out.println("没有上海人");
        }
        Boolean allMatch = students.stream().allMatch(s -> s.getAge()>=15);
        if (allMatch) {
            System.out.println("所有学生都满15周岁");
        }
        Boolean noneMatch = students.stream().noneMatch(s -> "小东".equals(s.getName()));
        if (noneMatch) {
            System.out.println("没有叫小东的同学");
        }
        //12.list根据对象属性封装到map  (id,student)
        Map<Long, List<Student>> idmap = students.stream().collect(Collectors.groupingBy(o -> o.getId()));
        System.out.println(idmap);
        //13.转换加去除空指定属性对象
        //Optional.ofNullable(Student).orElse(Lists.newArrayList()).stream();
        //.map(MdOuDto::getBusinessLineCode).filter(Objects::nonNull).collect(Collectors.joining(","));
        List<String> onlyNameString = students.stream().map(stu -> stu.getName()).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(onlyNameString);*/
    }
    public  static void stringconpare(){
        String str1="hello";
        String str2="he"+new String("llo");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));

    }
    public static void mianshi(Integer total){
        if(total<2){
            total+=2;

        }
        System.out.println("第一次打印:"+total);

    }

    public static Integer  findResult(){
       Integer i=5;
        try{
            return i=6;//finally没执行，不会return
        }catch (Exception e)
        {
            return i=7;
        }
        finally {
            return i=8;
        }
    }


    @RequestMapping("/index")
    public String index(@RequestBody @Validated Student student){//@RequestParam("userId") @NotNull(message = "用户id不能为空") Long userId
        ProcessElement processElement = new ProcessElement();
        processElement.setUpdateTime(new Date());
        //processElement.setCElcode("1");
        String s = processElement.toString();
        boolean consult = s.equals(null);
       // System.out.println("启动成功"+s+"---"+consult+"--"+processElement.hashCode());
        logger.info("use loger4j da yin rizhi ");
        return "index";
    }

    @Autowired
    private ProcessElementimpl processElementimpl;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("开始执行测试");
        processElementimpl.transacation();
        System.out.println("事务执行测试");
        return "sssss";
    }


}
