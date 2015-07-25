/**
 * 
 */
package com.phn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Table(name="tb_aboutMe")
@Entity
public class AboutMe {
	
	private Integer id;   		//主键
	private BlogElement blogElementId;//关联Id
	private String motto; 		//座右铭
	private String mottoDetails;//座右铭详述
	private String screenName;  //网名
	private String occupation;  //职业
	private String location;  	//籍贯
	private Integer phone;   	//电话号码
	private String email;		//邮箱
	private String headImage;	//头像
	private String tureName;	//真实姓名
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tb_id", nullable = false, length = 9)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(optional = false)
	@JoinColumn(name="id", unique=true, nullable=false)
	public BlogElement getblogElementId() {
		return blogElementId;
	}
	public void setBlogElementId(BlogElement blogElementId) {
		this.blogElementId = blogElementId;
	}
	
	@Column(name = "tb_motto", nullable = false, length = 32)
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	@Column(name = "tb_mottoDetails", length = 64)
	public String getMottoDetails() {
		return mottoDetails;
	}
	public void setMottoDetails(String mottoDetails) {
		this.mottoDetails = mottoDetails;
	}
	@Column(name = "tb_screenName", length = 9)
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	@Column(name = "tb_occupation",  length = 9)
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	@Column(name = "tb_location",  length = 32)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(name = "tb_phone", nullable = false, length = 11)
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	@Column(name = "tb_email",  length = 32)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "tb_headImage", length = 32)
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	@Column(name = "tb_tureName", length = 9)
	public String getTureName() {
		return tureName;
	}
	public void setTureName(String tureName) {
		this.tureName = tureName;
	}
}
