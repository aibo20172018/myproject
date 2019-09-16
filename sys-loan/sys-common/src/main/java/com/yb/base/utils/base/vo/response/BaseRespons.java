package com.yb.base.utils.base.vo.response;

import java.io.Serializable;
import java.util.List;

import com.yb.base.utils.paging.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

@Component
@ApiModel("返回结果")
public class BaseRespons<T> implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;
	@ApiModelProperty(notes = "状态 1成功 0失败")
	private int state = 1;
	private String code = "1";
	@ApiModelProperty(notes = "操作描述")
	private String mgs ="success";
	private T data;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMgs() {
		return mgs;
	}
	public void setMgs(String mgs) {
		this.mgs = mgs;
	}
	  
   public static ObejectResponsVO ok(Object object) {
	   ObejectResponsVO  vo =new ObejectResponsVO();
	   vo.setObject(object);
	   return  vo;
  }
   
   public static  PageResponsVO ok(PageInfo pageInfo) {
	   int pageNumber =pageInfo.getPages();
	   int pageSize = pageInfo.getPageSize();
	   int totalCount = (int)pageInfo.getTotal();
	   List result = pageInfo.getList();
	   PageResponsVO vo = new PageResponsVO(pageNumber,pageSize,totalCount,result);
	   return  vo;
   }
   public static  StringResponseVO ok(String str) {
	   StringResponseVO vo =new StringResponseVO();
	   vo.setStr(str);
	   return  vo;
   }
   public static ListResponsVO ok(List<Object> list) {
	   ListResponsVO vo = new  ListResponsVO();
	   vo.setList(list);
	   return  vo;
   }
   public static BaseRespons error(String code,String mgs) {
	   BaseRespons vo =new BaseRespons();
	   vo.setCode(code);
	   vo.setMgs(mgs);
	   vo.setState(0);
	   return  vo;
   }

	public static BaseRespons ok(String code,String mgs) {
		BaseRespons vo =new BaseRespons();
		vo.setCode(code);
		vo.setMgs(mgs);
		return  vo;
	}
   
   public static BaseRespons RRException(String code,String mgs) {
	   BaseRespons vo =new BaseRespons();
	   vo.setCode(code);
	   vo.setMgs(mgs);
	   vo.setState(0);
	   return  vo;
   }
}
