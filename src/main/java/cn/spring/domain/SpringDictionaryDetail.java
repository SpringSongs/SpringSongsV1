package cn.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "spring_dictionary_detail", schema = "base_system")
public class SpringDictionaryDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5603826461554282082L;
	@Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Description(title ="主键")
    @Column(name="id")
    private String id;
    public String getId(){
        return  this.id;
    }
    public void setId(String id){
        this.id=id;
    }

    @NotBlank(message="请填写字典主表编码")
    @Size(max=45, min=1)
    @Description(title ="字典主表编码")
    @Column(name="dictionary_code")
    private String dictionaryCode;
    public String getDictionaryCode(){
        return  this.dictionaryCode;
    }
    public void setDictionaryCode(String dictionaryCode){
        this.dictionaryCode=dictionaryCode;
    }

    @Size(max=36, min=0)
    @Description(title ="上级")
    @Column(name="parent_id")
    private String parentId;
    public String getParentId(){
        return  this.parentId;
    }
    public void setParentId(String parentId){
        this.parentId=parentId;
    }

    @NotBlank(message="请填写编码")
    @Size(max=45, min=1)
    @Description(title ="编码")
    @Column(name="detail_code")
    private String detailCode;
    public String getDetailCode(){
        return  this.detailCode;
    }
    public void setDetailCode(String detailCode){
        this.detailCode=detailCode;
    }

    @NotBlank(message="请填写名称")
    @Size(max=45, min=1)
    @Description(title ="名称")
    @Column(name="detail_name")
    private String detailName;
    public String getDetailName(){
        return  this.detailName;
    }
    public void setDetailName(String detailName){
        this.detailName=detailName;
    }

    @NotBlank(message="请填写值")
    @Size(max=45, min=1)
    @Description(title ="值")
    @Column(name="detail_value")
    private String detailValue;
    public String getDetailValue(){
        return  this.detailValue;
    }
    public void setDetailValue(String detailValue){
        this.detailValue=detailValue;
    }

    @NotBlank(message="请填写说明")
    @Size(max=200, min=1)
    @Description(title ="说明")
    @Column(name="description")
    private String description;
    public String getDescription(){
        return  this.description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    @Size(max=65535, min=0)
    @Lob
    @Description(title ="下级")
    @Column(name="child_ids")
    private String childIds;
    public String getChildIds(){
        return  this.childIds;
    }
    public void setChildIds(String childIds){
        this.childIds=childIds;
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

    @Description(title ="允许编辑0不允许1允许")
    @Column(name="enable_edit")
    private boolean enableEdit;
    public boolean getEnableEdit(){
        return  this.enableEdit;
    }
    public void setEnableEdit(boolean enableEdit){
        this.enableEdit=enableEdit;
    }

    @Description(title ="允许删除0不允许1允许")
    @Column(name="enable_delete")
    private boolean enableDelete;
    public boolean getEnableDelete(){
        return  this.enableDelete;
    }
    public void setEnableDelete(boolean enableDelete){
        this.enableDelete=enableDelete;
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
