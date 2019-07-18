package com.yizu.house.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yizu.house.entity.Ad;
/**
 * ad数据访问接口
 * @author Administrator
 *
 */
public interface AdDao extends JpaRepository<Ad,Long>,JpaSpecificationExecutor<Ad>{
	
}
