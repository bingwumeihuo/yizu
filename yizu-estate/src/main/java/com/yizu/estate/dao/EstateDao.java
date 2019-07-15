package com.yizu.estate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yizu.estate.entity.Estate;

import java.util.List;

/**
 * estate数据访问接口
 * @author Administrator
 *
 */
public interface EstateDao extends JpaRepository<Estate,Long>,JpaSpecificationExecutor<Estate>{

    void deleteById(List<Long> ids);
}
