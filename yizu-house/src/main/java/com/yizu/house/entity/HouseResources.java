package com.yizu.house.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
/**
 * houseResources实体类
 * @author Administrator
 *
 */
@Data
@Entity
@Table(name="tb_house_resources")
public class HouseResources implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	//房源标题
	private String title;
	//楼盘id
	private Long estateId;
	//楼号（栋）
	private String buildingNum;
	//单元号
	private String buildingUnit;
	//门牌号
	private String buildingFloorNum;
	/**
	 * 租金
	 */

	private String rent;
	/**
	 * 租赁方式，1-整租，2-合租
	 */
	private Byte rentMethod;
	/**
	 * 支付方式，1-付一押一，2-付三押一，3- 付六押一，4-年付押一，5-其它
	 */
	private Byte paymentMethod;
	//户型，如：2室1厅1卫
	private String houseType;
	//建筑面积
	private String coveredArea;
	//使用面积
	private String useArea;
	//楼层，如：8/26
	private String floor;
	//朝向：东、南、西、北
	private String orientation;
	//装修，1-精装，2-简装，3-毛坯
	private Byte decoration;
	//配套设施， 如：1,2,3
	private String facilities;
	//图片，最多5张
	private String pic;
	//描述
	private String houseDesc;
	//联系人
	private String contact;
	//手机号
	private String mobile;
	//看房时间，1-上午，2-中午，3-下午，4-晚上，5-全 天
	private Byte time;
	//物业费
	private String propertyCost;
	private java.util.Date created;
	private java.util.Date updated;




	
}
