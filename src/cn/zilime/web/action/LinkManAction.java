package cn.zilime.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.zilime.domain.Customer;
import cn.zilime.domain.LinkMan;
import cn.zilime.service.LinkManService;
import cn.zilime.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
private LinkMan linkMan=new LinkMan();
private LinkManService linkManService;
private Integer currentPage;
private Integer pageSize;







public Integer getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(Integer currentPage) {
	this.currentPage = currentPage;
}

public Integer getPageSize() {
	return pageSize;
}

public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}

public String add() throws Exception{
	linkManService.save(linkMan);
			
	return "tolist";
}
public String delete() throws Exception{
	linkManService.delete(linkMan);
			
	return "tolist";
}

public String edit() throws Exception{
	LinkMan lm=linkManService.getById(linkMan.getLkm_id());
	ActionContext.getContext().put("linkMan", lm);
	
	return "edit";
	
}

public String list() throws Exception {
	DetachedCriteria dc=DetachedCriteria.forClass(LinkMan.class);
	if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
		dc.add(Restrictions.like("lkm_name","%"+linkMan.getLkm_name()+"%"));			
	}
	if(linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null){
		dc.add(Restrictions.eq("customer.cust_id",linkMan.getCustomer().getCust_id()));
	}
	
	PageBean pagebean=linkManService.getPageBean(dc,currentPage,pageSize);
	ActionContext.getContext().put("pageBean", pagebean);
	
	return "list";
}


@Override
public LinkMan getModel() {
	// TODO Auto-generated method stub
	return linkMan;
}











public void setLinkManService(LinkManService linkManService) {
	this.linkManService = linkManService;
}





	
	
}
