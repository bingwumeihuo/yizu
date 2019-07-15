package com.yizu.estate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.yizu.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yizu.common.util.IdWorker;

import com.yizu.estate.dao.EstateDao;
import com.yizu.estate.entity.Estate;

/**
 * estate服务层
 * 
 * @author Administrator
 *
 */
@Service
public class EstateService {

	@Autowired
	private EstateDao estateDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Estate> findAll() {

		return estateDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Estate> findSearch(Map whereMap, int page, int size) {
		Specification<Estate> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return estateDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Estate> findSearch(Map whereMap) {
		Specification<Estate> specification = createSpecification(whereMap);
		return estateDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Estate findById(Long id) {
		return estateDao.findById(id).orElse(null);
	}

	/**
	 * 增加
	 * @param estate
	 */
	public void add(Estate estate) {
		// estate.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		estateDao.save(estate);
	}

	/**
	 * 修改
	 * @param estate
	 */
	public void update(Estate estate) {
		estateDao.save(estate);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id) {
		estateDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Estate> createSpecification(Map searchMap) {

		return new Specification<Estate>() {

			@Override
			public Predicate toPredicate(Root<Estate> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 楼盘名称
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
                // 所在省
                if (searchMap.get("province")!=null && !"".equals(searchMap.get("province"))) {
                	predicateList.add(cb.like(root.get("province").as(String.class), "%"+(String)searchMap.get("province")+"%"));
                }
                // 所在市
                if (searchMap.get("city")!=null && !"".equals(searchMap.get("city"))) {
                	predicateList.add(cb.like(root.get("city").as(String.class), "%"+(String)searchMap.get("city")+"%"));
                }
                // 所在区
                if (searchMap.get("area")!=null && !"".equals(searchMap.get("area"))) {
                	predicateList.add(cb.like(root.get("area").as(String.class), "%"+(String)searchMap.get("area")+"%"));
                }
                // 具体地址
                if (searchMap.get("address")!=null && !"".equals(searchMap.get("address"))) {
                	predicateList.add(cb.like(root.get("address").as(String.class), "%"+(String)searchMap.get("address")+"%"));
                }
                // 建筑年代
                if (searchMap.get("year")!=null && !"".equals(searchMap.get("year"))) {
                	predicateList.add(cb.like(root.get("year").as(String.class), "%"+(String)searchMap.get("year")+"%"));
                }
                // 建筑类型
                if (searchMap.get("type")!=null && !"".equals(searchMap.get("type"))) {
                	predicateList.add(cb.like(root.get("type").as(String.class), "%"+(String)searchMap.get("type")+"%"));
                }
                // 物业费
                if (searchMap.get("propertyCost")!=null && !"".equals(searchMap.get("propertyCost"))) {
                	predicateList.add(cb.like(root.get("propertyCost").as(String.class), "%"+(String)searchMap.get("propertyCost")+"%"));
                }
                // 物业公司
                if (searchMap.get("propertyCompany")!=null && !"".equals(searchMap.get("propertyCompany"))) {
                	predicateList.add(cb.like(root.get("propertyCompany").as(String.class), "%"+(String)searchMap.get("propertyCompany")+"%"));
                }
                // 开发商
                if (searchMap.get("developers")!=null && !"".equals(searchMap.get("developers"))) {
                	predicateList.add(cb.like(root.get("developers").as(String.class), "%"+(String)searchMap.get("developers")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
