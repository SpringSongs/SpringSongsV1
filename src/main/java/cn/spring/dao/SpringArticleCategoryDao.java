package cn.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.spring.domain.SpringAritlce;
import cn.spring.domain.SpringArticleCategory;
import cn.spring.domain.SpringResource;

public interface SpringArticleCategoryDao  extends JpaRepository <SpringArticleCategory, String>{ 
	
	/**
	 * 分页查询
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<SpringArticleCategory> findAll(Specification<SpringArticleCategory> spec, Pageable pageable);
	
	/**
    *
    * IN查询
    * @param ids
    * @return List<BaseSpringArticleCategoryEntity>
    * @see [相关类/方法]（可选）
    * @since [产品/模块版本] （可选）
    */
    @Query(value = "from SpringArticleCategory where id in (:ids)")
    public List<SpringArticleCategory> findInIds(@Param(value = "ids") List<String> ids);
    /**
    *
    * 逻辑删除
    * @param id
    * @return
    * @see [相关类/方法]（可选）
    * @since [产品/模块版本] （可选）
    */
    @Modifying
    @Query(value = "update SpringArticleCategory set deletedStatus=1 where id=:id")
    public void setDelete(@Param(value = "id") String id);
    /**
    *
    * 逻辑批量删除
    * @param ids
    * @return
    * @see [相关类/方法]（可选）
    * @since [产品/模块版本] （可选）
    */
    @Modifying
    @Query(value = "update SpringArticleCategory set deletedStatus=1 where id in (:ids)")
    public void setDelete(@Param(value = "ids") List<String> ids);
    
    /**
	 *
	 * 根据上级节点查询了节点
	 * 
	 * @param List<BaseModuleEntity>
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Query(value = "from SpringArticleCategory where parentId=:parentId and deletedStatus=0")
	public List<SpringArticleCategory> getByParentId(@Param(value = "parentId") String parentId);
	
	/**
	 *
	 * 根据上级节点查询子节点
	 * 
	 * @param ids
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Query(value = "from SpringResource where parentId in (:parentId) and deletedStatus=0")
	public List<SpringArticleCategory> getInParentId(@Param(value = "parentId") List<String> parentId);
}
