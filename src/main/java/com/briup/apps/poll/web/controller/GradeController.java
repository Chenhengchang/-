package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.extend.GradeVM;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="年级相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	//List<Grade> findAll() throws Exception;
	@ApiOperation(value="查询年级所有信息",notes="查询结果不包含School")
	@GetMapping("findAllGrade")
	public MsgResponse findAllGrade(){
		try {
			List<Grade> list=gradeService.findAll();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	@ApiOperation(value="查询班级所有信息",notes="查询结果包含School")
	@GetMapping("findAllGradeVM")
	public MsgResponse findAllGradeVM(){
		try {
			List<GradeVM> list=gradeService.findAllGradeVM();
			return MsgResponse.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
		
	}
	//Grade findById(long id)throws Exception;
	@ApiOperation(value="通过ID查询年级信息",notes="查询结果包含School")
	@GetMapping("findByIdGrade")
	public MsgResponse findByIdGrade(@RequestParam long id){
		try {
			GradeVM grade=gradeService.findById(id);
			return MsgResponse.success("成功查询ID为："+id,grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//List<Grade>query(String keywords) throws Exception;
	@ApiOperation(value="通过关键字查询年级信息",notes="查询结果包含Grade,User")
	@GetMapping("findKeyWords")
	public MsgResponse findKeyWords(String keywords){
		try {
			List<GradeVM> list=gradeService.query(keywords);
			return MsgResponse.success("find key words:"+keywords,list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//void saveOrUpdate(Grade grade) throws Exception;
	@ApiOperation(value="增加或修改年级信息",notes="输入ID为修改信息，不输入ID是增加信息")
	@PostMapping("saveOrUpdateGrade")
	public MsgResponse saveOrUpdateGrade(Grade grade){
		try {
			gradeService.saveOrUpdate(grade);
			
			return MsgResponse.success("更改数据成功",grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//void deleteById(long id)throws Exception;
	@ApiOperation(value="通过ID删除年级信息")
	@GetMapping("deleteByIdGrade")
	public MsgResponse deleteByIdGrade(@RequestParam long id){
		try {
			gradeService.deleteById(id);
			return MsgResponse.success("DELETE：",id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}
	//void batchDelete(List<Long> ids)throws Exception;
	@ApiOperation(value="批量删除年纪信息",notes="输入ID号，通过‘,’号间隔")
	@GetMapping("batchDeleteGrade")
	public MsgResponse batchDeleteGrade(@RequestParam List<Long> ids){
		try {
			gradeService.batchDelete(ids);
			return MsgResponse.success("批量删除的ID为：",ids);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

}
