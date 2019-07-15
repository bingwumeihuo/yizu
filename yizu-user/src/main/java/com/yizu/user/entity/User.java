package com.yizu.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * user实体类
 * @author Administrator
 *
 */
@Data
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private Long id;
	private String name;
	private Integer age;
	private String email;

	



	
}
