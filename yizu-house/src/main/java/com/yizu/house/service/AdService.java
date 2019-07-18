package com.yizu.house.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.yizu.common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yizu.house.dao.AdDao;
import com.yizu.house.entity.Ad;

/**
 * ad服务层
 * 
 * @author Administrator
 *
 */
@Service
public class AdService {

	@Autowired
	private AdDao adDao;
//
//	@Autowired
//	private IdWorker idWorker;



	public Page<Ad> findSearch(Map whereMap, int page, int size) {
		Specification<Ad> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return adDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Ad> findSearch(Map whereMap) {
		Specification<Ad> specification = createSpecification(whereMap);
		return adDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Ad findById(Long id) {
		return adDao.findById(id).orElse(null);
	}

	/**
	 * 增加
	 * @param ad
	 */
	public void add(Ad ad) {
		// ad.setId( idWorker.nextId()+"" ); 雪花分布式ID生成器
		adDao.save(ad);
	}

	/**
	 * 修改
	 * @param ad
	 */
	public void update(Ad ad) {
		adDao.save(ad);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id) {
		adDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Ad> createSpecification(Map searchMap) {

		return new Specification<Ad>() {

			@Override
			public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 描述
                if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
                	predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
                }
                // 图片URL地址
                if (searchMap.get("url")!=null && !"".equals(searchMap.get("url"))) {
                	predicateList.add(cb.like(root.get("url").as(String.class), "%"+(String)searchMap.get("url")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

}
