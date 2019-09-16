package com.example.springboot.controller;

import com.example.springboot.Myinterface.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @NotNull：不能为null，但可以为empty(""," "," ")
 * @NotEmpty：不能为null，而且长度必须大于0 (" ", " ")
 * @NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test") 即：必须有实际字符
 * @Min  @Max @Range(min=,max=) @Past @Size(min=,max=) @Email(regexp) @Valid 级联验证
 *
 */
@Data
@Validated
public class Student {

    private  Long id;
    private  String name;

    public Student(Long id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private  String address;
    private  int age;
    /**
     * 校验例子
     */
    /*** 用户ID   再在需要校验的地方@Validated声明校验组 @Validated(Update.class)*/
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Long userId;

    /** 用户名*/
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String username;

    /** 手机号*/
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    /**性别*/
    private String sex;

    /** 邮箱*/
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    /** 密码*/
    private String password;

    /*** 创建时间 */
    @Future(message = "时间必须是将来时间")
    private Date createTime;

}
