package cn.spring.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.spring.domain.SpringDictionary;

@Repository
public interface SpringDictionaryDao extends JpaRepository<SpringDictionary, String> {
	/**
	 * 分页查询
	 * 
	 * @param spec
	 * @param pageable
	 * @return
	 */
	Page<SpringDictionary> findAll(Specification<SpringDictionary> spec, Pageable pageable);

	/**
	 *
	 * IN查询
	 * 
	 * @param ids
	 * @return List<BaseDictionaryEntity>
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Query(value = "from SpringDictionary where id in (:ids)")
	public List<SpringDictionary> findInIds(@Param(value = "ids") List<String> ids);

	/**
	 *
	 * 逻辑删除
	 * 
	 * @param id
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Modifying
	@Query(value = "update SpringDictionary set deletedFlag=1 where id=:id")
	public void setDelete(@Param(value = "id") String id);

	/**
	 *
	 * 逻辑批量删除
	 * 
	 * @param ids
	 * @return
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Modifying
	@Query(value = "update SpringDictionary set deletedFlag=1 where id in (:ids)")
	public void setDelete(@Param(value = "ids") List<String> ids);

	/**
	 * 物理删除
	 * 
	 * @param ids
	 */
	@Modifying
	@Query(value = "delete from SpringDictionary where id in (:ids)")
	public void delete(@Param(value = "ids") List<String> ids);

	/**
	 * 
	 * @param ids
	 * @return
	 */
	@Query(value = "from SpringDictionary where id in (:ids)")
	List<SpringDictionary> listByIds(@Param(value = "ids") List<String> ids);
}
