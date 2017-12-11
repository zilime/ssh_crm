package cn.zilime.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.zilime.domain.BaseDict;
import cn.zilime.domain.Customer;
import cn.zilime.service.BaseDictService;

public class BaseDictAction extends ActionSupport  {
private String dict_type_code;
private BaseDictService baseDictService;
@Override
public String execute() throws Exception {
	List<BaseDict> list=baseDictService.getListByTypeCode(dict_type_code);
	String json=new GsonBuilder().create().toJson(list);
	ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
	ServletActionContext.getResponse().getWriter().write(json);
	
	
	
	return null;
}
public String getDict_type_code() {
	return dict_type_code;
}
public void setDict_type_code(String dict_type_code) {
	this.dict_type_code = dict_type_code;
}
public void setBaseDictService(BaseDictService baseDictService) {
	this.baseDictService = baseDictService;
}


	

}
