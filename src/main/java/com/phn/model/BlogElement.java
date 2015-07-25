/**
 * 
 */
package com.phn.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Administrator
 */
@Table(name="tb_blogElement")
@Entity
public class BlogElement {

	private Integer elementId;	//主键
	private AboutMe owerId;		//外键
	private String blogTitle;	//博客标题
	private String titleDetails;//标题详述
	private String homeImage;	//头像
	private String imageWordsEn;//文字 英文
	private String imageWordsZn;//文字 中文
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tb_elementId", nullable = false, length = 9)
	public Integer getElementId() {
		return elementId;
	}
	public void setElementId(Integer elementId) {
		this.elementId = elementId;
	}
	@OneToOne(optional = false, mappedBy = "blogElementId")
	public AboutMe getOwerId() {
		return owerId;
	}
	public void setOwerId(AboutMe owerId) {
		this.owerId = owerId;
	}
	@Column(name = "tb_blogTitle", nullable = false, length = 15)
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	@Column(name = "tb_titleDetails", length = 32)
	public String getTitleDetails() {
		return titleDetails;
	}
	public void setTitleDetails(String titleDetails) {
		this.titleDetails = titleDetails;
	}
	@Column(name = "tb_homeImage", nullable = false, length = 64)
	public String getHomeImage() {
		return homeImage;
	}
	public void setHomeImage(String homeImage) {
		this.homeImage = homeImage;
	}
	@Column(name = "tb_imageWordsEn", length = 64)
	public String getImageWordsEn() {
		return imageWordsEn;
	}
	public void setImageWordsEn(String imageWordsEn) {
		this.imageWordsEn = imageWordsEn;
	}
	@Column(name = "tb_imageWordsZn", length = 64)
	public String getImageWordsZn() {
		return imageWordsZn;
	}
	public void setImageWordsZn(String imageWordsZn) {
		this.imageWordsZn = imageWordsZn;
	}
}
