package com.briup.apps.poll.dao.extend;

import java.util.List;

import com.briup.apps.poll.bean.extend.SurveyVM;

public interface SurveyVMMapper {
	
	List<SurveyVM> selectAll();
	
	SurveyVM selectByIdSurveyVM(long id);
	 //关键字查询
	List<SurveyVM> queryVM(String keywords) throws Exception;



}
