package com.yizu.house.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yizu.house.vo.WebResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.yizu.house.entity.Ad;
import com.yizu.house.service.AdService;

import com.yizu.common.entity.PageResult;
import com.yizu.common.entity.Result;
import com.yizu.common.entity.StatusCode;

import javax.naming.Name;

/**
 * ad控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ad")
public class AdController {

	@Autowired
	private AdService adService;
	
	
//	/**
//	 * 查询全部数据
//	 * @return
//	 */
//	@RequestMapping(method= RequestMethod.GET)
//	public Result findAll(){
//		return new Result(true,StatusCode.OK,"查询成功",adService.findAll());
//	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable Long id){
		Ad ad= adService.findById(id);
		if(ad==null){
			return new Result(false, StatusCode.ERROR, "无数据");
		}
		return new Result(true,StatusCode.OK,"查询成功",ad);
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装&&封装数据
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public WebResult findSearch(Map searchMap , @RequestParam(name ="page",defaultValue = "1")Integer page ,
								@RequestParam(name = "size",defaultValue = "10")Integer size){
		Page<Ad> pageList = adService.findSearch(searchMap, page, size);
	List<Ad> records =pageList.getContent();
	List<Object>result =new ArrayList<>();
	for (Ad ad: records){
		Map<String,Object> map =new HashMap<>();
		map.put("original", ad.getUrl());
		result.add(map);
	}
		return WebResult.ok(result);
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",adService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param ad
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody Ad ad  ){
		adService.add(ad);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param ad
	 */
	@RequestMapping(value="/update",method= RequestMethod.PUT)
	public Result update(@RequestBody Ad ad){
		adService.update(ad);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable Long id){
		adService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}
	
}
