package com.yizu.house.controller;
import java.util.List;
import java.util.Map;

import com.yizu.house.entity.PicUploadResult;
import com.yizu.house.service.PicUploadFileSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.yizu.house.entity.HouseResources;
import com.yizu.house.service.HouseResourcesService;

import com.yizu.common.entity.PageResult;
import com.yizu.common.entity.Result;
import com.yizu.common.entity.StatusCode;

/**
 * houseResources控制器层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/house/resources")
public class HouseResourcesController {
	@Autowired
	private PicUploadFileSystemService picUploadService;
	@Autowired
	private HouseResourcesService houseResourcesService;
	
	
//	/**
//	 * 查询全部数据
//	 * @return
//	 */
//	@RequestMapping(method= RequestMethod.GET)
//	public Result findAll(){
//		return new Result(true,StatusCode.OK,"查询成功", houseResourcesService.findAll());
//	}

	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public Result findById(@PathVariable Long id){
		HouseResources houseResources= houseResourcesService.findById(id);
		if(houseResources==null){
			return new Result(false, StatusCode.ERROR, "无数据");
		}
		return new Result(true,StatusCode.OK,"查询成功",houseResources);
	}

//
//	@GetMapping
//	@ResponseBody
//	public ResponseEntity<TableResult> list(HouseResources houseResources,
//	@RequestParam(name = "currentPage",
//			defaultValue = "1") Integer currentPage,
//	@RequestParam(name = "pageSize",
//			defaultValue = "10") Integer pageSize) {
//		return ResponseEntity.ok(this.houseResourcesService.findSearch(houseResources,currentPage,pageSize));
//	}

	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
 @ResponseBody
 @RequestMapping(method=RequestMethod.GET)
 public Result findSearch( Map searchMap , @RequestParam(name = "page",
       defaultValue = "1") Integer page, @RequestParam(name = "size",
       defaultValue = "10") Integer size){

    Page<HouseResources> pageList = houseResourcesService.findSearch(searchMap, page, size);
    return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<HouseResources>(pageList.getTotalElements(), pageList.getContent()) );
 }
	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",houseResourcesService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param houseResources
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Result add(@RequestBody HouseResources houseResources  ){
		houseResourcesService.add(houseResources);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param houseResources
	 */
	@RequestMapping(method= RequestMethod.PUT)
	public Result update(@RequestBody HouseResources houseResources){
		houseResourcesService.update(houseResources);
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
	public Result delete(@PathVariable Long id){
		houseResourcesService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

}
