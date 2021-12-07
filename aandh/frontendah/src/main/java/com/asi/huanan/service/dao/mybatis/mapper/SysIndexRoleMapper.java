package com.asi.huanan.service.dao.mybatis.mapper;

import com.asi.huanan.service.dao.mybatis.model.SysIndexRole;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRoleExample;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRoleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysIndexRoleMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	long countByExample(SysIndexRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int deleteByExample(SysIndexRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int deleteByPrimaryKey(SysIndexRoleKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int insert(SysIndexRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int insertSelective(SysIndexRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	List<SysIndexRole> selectByExample(SysIndexRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	SysIndexRole selectByPrimaryKey(SysIndexRoleKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int updateByExampleSelective(@Param("record") SysIndexRole record, @Param("example") SysIndexRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int updateByExample(@Param("record") SysIndexRole record, @Param("example") SysIndexRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int updateByPrimaryKeySelective(SysIndexRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_index_role
	 *
	 * @mbg.generated Thu Apr 16 17:57:02 CST 2020
	 */
	int updateByPrimaryKey(SysIndexRole record);
}