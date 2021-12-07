package com.asi.huanan.service.dao.mybatis.mapper;

import com.asi.huanan.service.dao.mybatis.model.SysMenu;
import com.asi.huanan.service.dao.mybatis.model.SysMenuExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	long countByExample(SysMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int deleteByExample(SysMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int deleteByPrimaryKey(BigDecimal menuId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int insert(SysMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int insertSelective(SysMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	List<SysMenu> selectByExample(SysMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	SysMenu selectByPrimaryKey(BigDecimal menuId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int updateByPrimaryKeySelective(SysMenu record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to
	 * the database table sys_menu
	 *
	 * @mbg.generated Tue Mar 31 14:00:52 CST 2020
	 */
	int updateByPrimaryKey(SysMenu record);
}