package com.yizu.estate.controller;
import java.util.List;
import java.util.Map;

import com.yizu.common.entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yizu.estate.entity.Estate;
import com.yizu.estate.service.EstateService;

import com.yizu.common.entity.PageResult;
import com.yizu.common.entity.Result;
import com.yizu.common.entity.StatusCode;
/**
 * estate控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/estate")
public class EstateController {

	@Autowired
	private EstateService estateService;
	
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",estateService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable Long id){
		Estate estate= estateService.findById(id);
		if(estate==null){
			return new Result(false, StatusCode.ERROR, "无数据");
		}
		return new Result(true,StatusCode.OK,"查询成功",estate);
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Estate> pageList = estateService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Estate>(pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",estateService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param estate
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Estate estate  ){
		estateService.add(estate);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param estate
	 */
	@RequestMapping(value="/update",method= RequestMethod.PUT)
	public Result update(@RequestBody Estate estate){
		estateService.update(estate);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable Long id){
		estateService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
