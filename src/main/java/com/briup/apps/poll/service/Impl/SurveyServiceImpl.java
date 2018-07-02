package com.briup.apps.poll.service.Impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServiceImpl implements ISurveyService{
	@Autowired
	private SurveyMapper surveyMapper;
    @Autowired
    private SurveyVMMapper surveyVMMapper;
    
    @Override
	public List<SurveyVM> findAll() throws Exception {
		return surveyVMMapper.selectAll();
    }

	@Override
	public void saveOrUpdate(Survey survey)  {
		if(survey.getId()!=null){
			surveyMapper.updateByPrimaryKey(survey);
		}else{
			survey.setStatus(Survey.STATUS_INIT);
			survey.setCode("");
			Date now=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String surveydate=sdf.format(now);
			survey.setSurveydate(surveydate);
			//status code surveyDate
			surveyMapper.insert(survey);
		}
		
	}

	@Override
	public void deleteById(long id) throws Exception {
		surveyMapper.deleteByPrimaryKey(id);
	
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		for(long id:ids){
			surveyMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public SurveyVM findByIdSurveyVM(long id) throws Exception {
		// TODO Auto-generated method stub
		return surveyVMMapper.selectByIdSurveyVM(id);
	}

	@Override
	public List<SurveyVM> queryVM(String keywords) throws Exception {
		/*SurveyExample example=new SurveyExample();
		example.createCriteria().andCodeLike("%"+keywords+"%");*/
		return surveyVMMapper.queryVM(keywords);
	}

	}


	

