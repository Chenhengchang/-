package com.briup.apps.poll.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(description="课程调查相关接口")
@RestController
@RequestMapping("/Survey")
public class SurveyController {

	@Autowired
	private ISurveyService surveyService;
	
	@ApiOperation(value="查询所有课程调查",notes="课程调查中包含，班级等信息")
	@GetMapping("findAllSurveyVM")
	public MsgResponse findAllSurveyVM(){
		try{
			List<SurveyVM> list=surveyService.findAll();
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	
	@PostMapping("findSurveyVMById")
	public MsgResponse findSurveyVMById(@RequestParam long id){
		try{
			SurveyVM surveyVM=surveyService.findByIdSurveyVM(id);
			//返回成功信息
			return MsgResponse.success("success",surveyVM);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}

	@PostMapping("findkeywordsVM")
	public MsgResponse queryVM(String keywords){
		try{
			List<SurveyVM> list=surveyService.queryVM(keywords);
			//返回成功信息
			return MsgResponse.success("success",list);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
    @ApiOperation(value="保存或更新课调",notes="如果参数中包含id表示修改，否则添加，只需接受clazzId")
	@PostMapping("saveOrUpdateSurvey")
	public MsgResponse saveOrUpdateSurvey(Survey survey){
		try{
			surveyService.saveOrUpdate(survey);
			//返回成功信息
			return MsgResponse.success("保存或更新成功",survey);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
	
    @ApiOperation(value="通过ID删除课调",notes="级联课调下的答卷信息")
	@PostMapping("deleteSurveyById")
	public MsgResponse deleteSurveyById(@RequestParam long id){
		try{
			surveyService.deleteById(id);
			//返回成功信息
			return MsgResponse.success("删除成功",null);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
    
    @ApiOperation(value="批量删除课调",notes="级联课调下的答卷信息")
	@PostMapping("batchdeleteSurveyById")
	public MsgResponse batchDeleteSurveyById(@RequestParam List<Long> ids){
		try{
			surveyService.batchDelete(ids);
			//返回成功信息
			return MsgResponse.success("success",ids);
		}catch(Exception e){
			e.printStackTrace();
			//返回错误信息
			return MsgResponse.error(e.getMessage());
		}
	}
}
