package com.yizu.house.service;

import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.yizu.house.vo.Pagination;
import com.yizu.common.util.IdWorker;
import com.yizu.house.entity.HouseResources;
import com.yizu.house.vo.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yizu.common.util.IdWorker;

import com.yizu.house.dao.HouseResourcesDao;
import com.yizu.house.entity.HouseResources;

/**
 * houseResources服务层
 * 
 * @author Administrator
 *
 */
@Service
public class HouseResourcesService {

	@Autowired
	private HouseResourcesDao houseResourcesDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<HouseResources> findAll() {
		return houseResourcesDao.findAll();
	}

	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<HouseResources> findSearch(Map whereMap, int page, int size) {
		Specification<HouseResources> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return houseResourcesDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<HouseResources> findSearch(Map whereMap) {
		Specification<HouseResources> specification = createSpecification(whereMap);
		return houseResourcesDao.findAll(specification);
	}

//
//	public TableResult<HouseResources> queryList(HouseResources houseResources, Integer currentPage, Integer pageSize) {
//		PageInfo<HouseResources> pageInfo = this.apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);
//		return new TableResult<>(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
//	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public HouseResources findById(Long id) {
		return houseResourcesDao.findById(id).orElse(null);
	}

	/**
	 * 增加
	 * @param houseResources
	 */
	public void add(HouseResources houseResources) {

//		houseResources.setId(idWorker.nextId()+"");
		houseResources.setCreated(new Date());
		houseResources.setUpdated(new Date());
		houseResourcesDao.save(houseResources);
	}

	/**
	 * 修改
	 * @param houseResources
	 */
	public void update(HouseResources houseResources) {
		houseResourcesDao.save(houseResources);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id) {
		houseResourcesDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<HouseResources> createSpecification(Map searchMap) {

		return new Specification<HouseResources>() {

			@Override
			public Predicate toPredicate(Root<HouseResources> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 房源标题
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 楼号（栋）
                if (searchMap.get("buildingNum")!=null && !"".equals(searchMap.get("buildingNum"))) {
                	predicateList.add(cb.like(root.get("buildingNum").as(String.class), "%"+(String)searchMap.get("buildingNum")+"%"));
                }
                // 单元号
                if (searchMap.get("buildingUnit")!=null && !"".equals(searchMap.get("buildingUnit"))) {
                	predicateList.add(cb.like(root.get("buildingUnit").as(String.class), "%"+(String)searchMap.get("buildingUnit")+"%"));
                }
                // 门牌号
                if (searchMap.get("buildingFloorNum")!=null && !"".equals(searchMap.get("buildingFloorNum"))) {
                	predicateList.add(cb.like(root.get("buildingFloorNum").as(String.class), "%"+(String)searchMap.get("buildingFloorNum")+"%"));
                }
                // 户型，如：2室1厅1卫
                if (searchMap.get("houseType")!=null && !"".equals(searchMap.get("houseType"))) {
                	predicateList.add(cb.like(root.get("houseType").as(String.class), "%"+(String)searchMap.get("houseType")+"%"));
                }
                // 建筑面积
                if (searchMap.get("coveredArea")!=null && !"".equals(searchMap.get("coveredArea"))) {
                	predicateList.add(cb.like(root.get("coveredArea").as(String.class), "%"+(String)searchMap.get("coveredArea")+"%"));
                }
                // 使用面积
                if (searchMap.get("useArea")!=null && !"".equals(searchMap.get("useArea"))) {
                	predicateList.add(cb.like(root.get("useArea").as(String.class), "%"+(String)searchMap.get("useArea")+"%"));
                }
                // 楼层，如：8/26
                if (searchMap.get("floor")!=null && !"".equals(searchMap.get("floor"))) {
                	predicateList.add(cb.like(root.get("floor").as(String.class), "%"+(String)searchMap.get("floor")+"%"));
                }
                // 朝向：东、南、西、北
                if (searchMap.get("orientation")!=null && !"".equals(searchMap.get("orientation"))) {
                	predicateList.add(cb.like(root.get("orientation").as(String.class), "%"+(String)searchMap.get("orientation")+"%"));
                }
                // 配套设施， 如：1,2,3
                if (searchMap.get("facilities")!=null && !"".equals(searchMap.get("facilities"))) {
                	predicateList.add(cb.like(root.get("facilities").as(String.class), "%"+(String)searchMap.get("facilities")+"%"));
                }
                // 图片，最多5张
                if (searchMap.get("pic")!=null && !"".equals(searchMap.get("pic"))) {
                	predicateList.add(cb.like(root.get("pic").as(String.class), "%"+(String)searchMap.get("pic")+"%"));
                }
                // 描述
                if (searchMap.get("houseDesc")!=null && !"".equals(searchMap.get("houseDesc"))) {
                	predicateList.add(cb.like(root.get("houseDesc").as(String.class), "%"+(String)searchMap.get("houseDesc")+"%"));
                }
                // 联系人
                if (searchMap.get("contact")!=null && !"".equals(searchMap.get("contact"))) {
                	predicateList.add(cb.like(root.get("contact").as(String.class), "%"+(String)searchMap.get("contact")+"%"));
                }
                // 手机号
                if (searchMap.get("mobile")!=null && !"".equals(searchMap.get("mobile"))) {
                	predicateList.add(cb.like(root.get("mobile").as(String.class), "%"+(String)searchMap.get("mobile")+"%"));
                }
                // 物业费
                if (searchMap.get("propertyCost")!=null && !"".equals(searchMap.get("propertyCost"))) {
                	predicateList.add(cb.like(root.get("propertyCost").as(String.class), "%"+(String)searchMap.get("propertyCost")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
