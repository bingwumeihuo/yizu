package com.yizu.house.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yizu.house.entity.HouseResources;
/**
 * houseResources数据访问接口
 * @author Administrator
 *
 */
public interface HouseResourcesDao extends JpaRepository<HouseResources,Long>,JpaSpecificationExecutor<HouseResources>{

}
