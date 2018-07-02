package com.briup.apps.poll.service;

import java.util.List;


import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;

public interface ISurveyService {
 
	List<SurveyVM> findAll()throws Exception;
	
	SurveyVM findByIdSurveyVM(long id)throws Exception;
	
	List<SurveyVM> queryVM(String keywords) throws Exception;
	
	void saveOrUpdate(Survey survey) throws Exception;
	
	void deleteById(long id)throws Exception;
	
	void batchDelete(List<Long> ids)throws Exception;
}
