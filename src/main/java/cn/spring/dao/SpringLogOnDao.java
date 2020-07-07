package cn.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cn.spring.domain.SpringUserSecurity;

@Repository
public interface SpringLogOnDao extends JpaRepository<SpringUserSecurity, String> {
	/**
	 * IN查询
	 * @param ids
	 * @return List<BaseBuserLogOnEntity>
	 * @see [相关类/方法]（可选）
	 * @since [产品/模块版本] （可选）
	 */
	@Query(value = "from SpringUserSecurity where id in (:ids)")
	public List<SpringUserSecurity> findInIds(@Param(value = "ids") List<String> ids);

	/***
	 * 查找密码
	 * @param userId
	 * @return
	 */
	@Query(value = "from SpringUserSecurity where userId=:userId")
	public SpringUserSecurity findByUserId(@Param(value = "userId") String userId);
	
	/**
	 * 物理删除
	 * @param ids
	 */
	@Modifying
	@Query(value = "delete from SpringUserSecurity where userId in (:ids)")
	public void delete(@Param(value = "ids") List<String> ids);

}
