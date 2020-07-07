package cn.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.spring.domain.SpringResourceRole;

public interface SpringResourceRoleDao extends JpaRepository<SpringResourceRole, String> {
	/**
	 *
	 * IN查询
	 * 
	 * @param ids
	 * @return List<BaseModuleRoleEntity>
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Query(value = "from SpringResourceRole where id in (:ids)")
	public List<SpringResourceRole> findInIds(@Param(value = "ids") List<String> ids);

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
	@Query(value = "update SpringResourceRole set deletedFlag=1 where id=:id")
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
	@Query(value = "update SpringResourceRole set deletedFlag=1 where id in (:ids)")
	public void setDelete(@Param(value = "ids") List<String> ids);

	/**
	 * 删除权限
	 * 
	 * @param userId
	 * @param roleId
	 */
	@Modifying
	@Query(value = "delete from SpringResourceRole where roleId=:roleId and moduleId=:moduleId")
	public void delete(@Param(value = "roleId") String roleId, @Param(value = "moduleId") String moduleId);

	/**
	 * 删除权限
	 * 
	 * @param userId
	 * @param roleId
	 */
	@Modifying
	@Query(value = "delete from SpringResourceRole where roleId=:roleId")
	public void delete(@Param(value = "roleId") String roleId);

	/**
	 * 查找资源
	 * 
	 * @param roleId
	 * @return
	 */
	@Query(value = "from SpringResourceRole where roleId=:roleId")
	public List<SpringResourceRole> listModulesByRoleId(@Param(value = "roleId") String roleId);
}