package com.yizu.house.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
/**
 * ad实体类
 * @author Administrator
 *
 */
@Data
@Entity
@Table(name="tb_ad")
public class Ad implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//广告类型
	private Integer type;
	//描述
	private String title;
	//图片URL地址
	private String url;

	private java.util.Date created;

	private java.util.Date updated;

	


	
}
