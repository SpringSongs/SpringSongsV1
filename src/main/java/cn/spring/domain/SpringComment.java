package cn.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cn.spring.annotation.Description;

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "spring_article_comment", schema = "base_system")
public class SpringComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3847152121362987125L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Description(title = "id")
	@Column(name = "id")
	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotBlank(message="请填写评论内容")
    @Size(max=2000, min=1)
    @Description(title ="评论内容")
    @Column(name="content")
    private String content;
    public String getContent(){
        return  this.content;
    }
    public void setContent(String content){
        this.content=content;
    }

    @NotBlank(message="请填写主题主键")
    @Size(max=36, min=1)
    @Description(title ="主题主键")
    @Column(name="article_id")
    private String articleId;
    public String getArticleId(){
        return  this.articleId;
    }
    public void setArticleId(String articleId){
        this.articleId=articleId;
    }

    @Description(title ="0未审1已审")
    @Column(name="audit_flag")
    private boolean auditFlag;
    public boolean getAuditFlag(){
        return  this.auditFlag;
    }
    public void setAuditFlag(boolean auditFlag){
        this.auditFlag=auditFlag;
    }

    @Description(title ="排序")
    @Column(name="sort_code")
    private int sortCode;
    public int getSortCode(){
        return  this.sortCode;
    }
    public void setSortCode(int sortCode){
        this.sortCode=sortCode;
    }

    @Description(title ="0未删1已删")
    @Column(name="deleted_flag")
    private boolean deletedFlag;
    public boolean getDeletedFlag(){
        return  this.deletedFlag;
    }
    public void setDeletedFlag(boolean deletedFlag){
        this.deletedFlag=deletedFlag;
    }

    @Size(max=36, min=0)
    @Description(title ="创建人主键")
    @Column(name="created_user_id")
    private String createdUserId;
    public String getCreatedUserId(){
        return  this.createdUserId;
    }
    public void setCreatedUserId(String createdUserId){
        this.createdUserId=createdUserId;
    }

    @Size(max=36, min=0)
    @Description(title ="创建人")
    @Column(name="created_by")
    private String createdBy;
    public String getCreatedBy(){
        return  this.createdBy;
    }
    public void setCreatedBy(String createdBy){
        this.createdBy=createdBy;
    }

    @Description(title ="创建时间")
    @Column(name="created_on")
    private java.util.Date createdOn;
    public java.util.Date getCreatedOn(){
        return  this.createdOn;
    }
    public void setCreatedOn(java.util.Date createdOn){
        this.createdOn=createdOn;
    }

    @Size(max=45, min=0)
    @Description(title ="创建ip")
    @Column(name="created_ip")
    private String createdIp;
    public String getCreatedIp(){
        return  this.createdIp;
    }
    public void setCreatedIp(String createdIp){
        this.createdIp=createdIp;
    }

    @Size(max=36, min=0)
    @Description(title ="编辑人主键")
    @Column(name="updated_user_id")
    private String updatedUserId;
    public String getUpdatedUserId(){
        return  this.updatedUserId;
    }
    public void setUpdatedUserId(String updatedUserId){
        this.updatedUserId=updatedUserId;
    }

    @Size(max=45, min=0)
    @Description(title ="编辑人")
    @Column(name="updated_by")
    private String updatedBy;
    public String getUpdatedBy(){
        return  this.updatedBy;
    }
    public void setUpdatedBy(String updatedBy){
        this.updatedBy=updatedBy;
    }

    @Description(title ="编辑时间")
    @Column(name="updated_on")
    private java.util.Date updatedOn;
    public java.util.Date getUpdatedOn(){
        return  this.updatedOn;
    }
    public void setUpdatedOn(java.util.Date updatedOn){
        this.updatedOn=updatedOn;
    }

    @Size(max=45, min=0)
    @Description(title ="编辑ip")
    @Column(name="updated_ip")
    private String updatedIp;
    public String getUpdatedIp(){
        return  this.updatedIp;
    }
    public void setUpdatedIp(String updatedIp){
        this.updatedIp=updatedIp;
    }

}
