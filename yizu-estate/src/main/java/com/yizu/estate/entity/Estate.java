package com.yizu.estate.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * estate实体类
 * @author Administrator
 *
 */
@Data
@Entity
@Table(name="tb_estate")
public class Estate implements Serializable{

	@Id
	//id
	private Long id;


	//楼盘名称
	private String name;
	//所在省
	private String province;
	//所在市
	private String city;
	//所在区
	private String area;
	//具体地址
	private String address;
	//建筑年代
	private String year;
	//建筑类型
	private String type;
	//物业费
	private String propertyCost;
	//物业公司
	private String propertyCompany;
	//开发商
	private String developers;
	//创建时间
	private java.util.Date created;
	//更新时间
	private java.util.Date updated;

	



	
}
