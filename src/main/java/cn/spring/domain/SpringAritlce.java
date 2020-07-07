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
@Table(name = "spring_aritlce", schema = "base_system")
public class SpringAritlce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8803308263554834190L;
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Description(title = "id")
	@Column(name = "id")
    private String id;
    public String getId(){
        return  this.id;
    }
    public void setId(String id){
        this.id=id;
    }

    @Size(max=45, min=0)
    @Description(title ="分类主键")
    @Column(name="category_id")
    private String categoryId;
    public String getCategoryId(){
        return  this.categoryId;
    }
    public void setCategoryId(String categoryId){
        this.categoryId=categoryId;
    }

    @Size(max=45, min=0)
    @Description(title ="分类名称")
    @Column(name="category_title")
    private String categoryTitle;
    public String getCategoryTitle(){
        return  this.categoryTitle;
    }
    public void setCategoryTitle(String categoryTitle){
        this.categoryTitle=categoryTitle;
    }

    @Size(max=45, min=0)
    @Description(title ="颜色")
    @Column(name="color")
    private String color;
    public String getColor(){
        return  this.color;
    }
    public void setColor(String color){
        this.color=color;
    }

    @Size(max=45, min=0)
    @Description(title ="标签")
    @Column(name="tag")
    private String tag;
    public String getTag(){
        return  this.tag;
    }
    public void setTag(String tag){
        this.tag=tag;
    }

    @Size(max=45, min=0)
    @Description(title ="关键字")
    @Column(name="keyword")
    private String keyword;
    public String getKeyword(){
        return  this.keyword;
    }
    public void setKeyword(String keyword){
        this.keyword=keyword;
    }

    @NotBlank(message="请填写标题")
    @Size(max=200, min=1, message="请填写标题")
    @Description(title ="标题")
    @Column(name="title")
    private String title;
    public String getTitle(){
        return  this.title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    @Size(max=500, min=0, message="请填写简要说明")
    @Description(title ="简要说明")
    @Column(name="summary")
    private String summary;
    public String getSummary(){
        return  this.summary;
    }
    public void setSummary(String summary){
        this.summary=summary;
    }

    @NotBlank(message="请填写内容")
    @Lob
    @Description(title ="内容")
    @Column(name="contents")
    private String contents;
    public String getContents(){
        return  this.contents;
    }
    public void setContents(String contents){
        this.contents=contents;
    }

    @Size(max=45, min=0)
    @Description(title ="作者主键")
    @Column(name="author_id")
    private String authorId;
    public String getAuthorId(){
        return  this.authorId;
    }
    public void setAuthorId(String authorId){
        this.authorId=authorId;
    }

    @Size(max=45, min=0)
    @Description(title ="作者")
    @Column(name="author")
    private String author;
    public String getAuthor(){
        return  this.author;
    }
    public void setAuthor(String author){
        this.author=author;
    }

    @Size(max=45, min=0)
    @Description(title ="作者链接")
    @Column(name="author_url")
    private String authorUrl;
    public String getAuthorUrl(){
        return  this.authorUrl;
    }
    public void setAuthorUrl(String authorUrl){
        this.authorUrl=authorUrl;
    }

    @Description(title ="审核0未审1已审")
    @Column(name="status")
    private boolean status;
    public boolean getStatus(){
        return  this.status;
    }
    public void setStatus(boolean status){
        this.status=status;
    }

    @Size(max=45, min=0)
    @Description(title ="链接")
    @Column(name="link")
    private String link;
    public String getLink(){
        return  this.link;
    }
    public void setLink(String link){
        this.link=link;
    }

    @Description(title ="阅读次数")
    @Column(name="read_count")
    private int readCount;
    public int getReadCount(){
        return  this.readCount;
    }
    public void setReadCount(int readCount){
        this.readCount=readCount;
    }

    @Description(title ="喜欢次数")
    @Column(name="like_count")
    private int likeCount;
    public int getLikeCount(){
        return  this.likeCount;
    }
    public void setLikeCount(int likeCount){
        this.likeCount=likeCount;
    }

    @Description(title ="收藏次数")
    @Column(name="collect_count")
    private int collectCount;
    public int getCollectCount(){
        return  this.collectCount;
    }
    public void setCollectCount(int collectCount){
        this.collectCount=collectCount;
    }

    @Description(title ="分享次数")
    @Column(name="share_count")
    private int shareCount;
    public int getShareCount(){
        return  this.shareCount;
    }
    public void setShareCount(int shareCount){
        this.shareCount=shareCount;
    }

    @Description(title ="是否置顶")
    @Column(name="top_status")
    private boolean topStatus;
    public boolean getTopStatus(){
        return  this.topStatus;
    }
    public void setTopStatus(boolean topStatus){
        this.topStatus=topStatus;
    }

    @Description(title ="是否热点")
    @Column(name="hot_status")
    private boolean hotStatus;
    public boolean getHotStatus(){
        return  this.hotStatus;
    }
    public void setHotStatus(boolean hotStatus){
        this.hotStatus=hotStatus;
    }

    @Description(title ="是否精选")
    @Column(name="featured")
    private boolean featured;
    public boolean getFeatured(){
        return  this.featured;
    }
    public void setFeatured(boolean featured){
        this.featured=featured;
    }

    @Description(title ="评论次数")
    @Column(name="comment_count")
    private int commentCount;
    public int getCommentCount(){
        return  this.commentCount;
    }
    public void setCommentCount(int commentCount){
        this.commentCount=commentCount;
    }

    @Description(title ="排序")
    @Column(name="sort_order")
    private int sortOrder;
    public int getSortOrder(){
        return  this.sortOrder;
    }
    public void setSortOrder(int sortOrder){
        this.sortOrder=sortOrder;
    }

    @Size(max=45, min=0)
    @Description(title ="来源")
    @Column(name="come_from")
    private String comeFrom;
    public String getComeFrom(){
        return  this.comeFrom;
    }
    public void setComeFrom(String comeFrom){
        this.comeFrom=comeFrom;
    }

    @Size(max=2000, min=0)
    @Description(title ="来源链接")
    @Column(name="come_from_link")
    private String comeFromLink;
    public String getComeFromLink(){
        return  this.comeFromLink;
    }
    public void setComeFromLink(String comeFromLink){
        this.comeFromLink=comeFromLink;
    }

    @Description(title ="0未删1已删")
    @Column(name="deleted_status")
    private boolean deletedStatus;
    public boolean getDeletedStatus(){
        return  this.deletedStatus;
    }
    public void setDeletedStatus(boolean deletedStatus){
        this.deletedStatus=deletedStatus;
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

    @Description(title ="版本号")
    @Column(name="version")
    private int version;
    public int getVersion(){
        return  this.version;
    }
    public void setVersion(int version){
        this.version=version;
    }
}