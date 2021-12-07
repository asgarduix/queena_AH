package com.asi.huanan.service.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysFunctionRoleMapper;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionRole;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionRoleExample;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionRoleExample.Criteria;
import org.apache.commons.lang3.StringUtils;

@Repository
public class SysFunctionRoleRepository {

	private Log log = LogFactory.getLog(SysFunctionRoleRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<SysFunctionRole> queryByModelBetweenSize(final SysFunctionRole model, String orderByColNm1,
			String ascOrDesc, int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionRole> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);

			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			// returnList = mapper.selectByParamBetweenSize(model.{GET}..., "CRT_TIME",
			// "DESC", a[0], a[1]);

			log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return returnList;
	}

	/**
	 * @param model
	 * @return
	 * 
	 */
	public int queryCount(SysFunctionRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
			// count = mapper.selectCountByParamBetweenSize(model.{GET}...);
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}

		return count;
	}

	// =====以下為基本使用的=====

	/**
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 */
	public int insert(final SysFunctionRole model, SysFunctionRoleMapper mapper) {
		// return mapper.insertSelective(model);
		return 0;
	}

	/**
	 * 
	 * @param primaryKey
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, SysFunctionRoleMapper mapper) throws Exception {
		// return mapper.deleteByPrimaryKey(primaryKey);
		return 0;
	}

	/**
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public int update(final SysFunctionRole model, SysFunctionRoleMapper mapper) throws Exception {
		// return mapper.updateByPrimaryKey(model);
		return 0;
	}

	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 */
	// public int insert(final SysFunctionRole model, SqlSession sqlSession) {
	// SysFunctionRoleMapper mapper =
	// sqlSession.getMapper(SysFunctionRoleMapper.class);
	// return mapper.insertSelective(model);
	// }

	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * 
	 * @param primaryKey
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	// public int deleteByKey(final String primaryKey, SqlSession sqlSession) throws
	// Exception {
	// SysFunctionRoleMapper mapper =
	// sqlSession.getMapper(SysFunctionRoleMapper.class);
	// return mapper.deleteByPrimaryKey(primaryKey);
	// }

	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	// public int update(final SysFunctionRole model, SqlSession sqlSession) throws
	// Exception {
	// SysFunctionRoleMapper mapper =
	// sqlSession.getMapper(SysFunctionRoleMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
			// count = mapper.insertSelective(model);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertList(final List<SysFunctionRole> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);

			for (SysFunctionRole model : modelList) {
				// count += mapper.insertSelective(model);
			}

			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

	// /**
	// *
	// * @return List<SysFunctionRole>
	// * @throws Exception
	// */
	// public List<SysFunctionRole> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionRole> returnList = null;
	// try {
	// SysFunctionRoleMapper mapper =
	// sqlSession.getMapper(SysFunctionRoleMapper.class);
	// SysFunctionRoleExample ex = new SysFunctionRoleExample();
	// Criteria cr = ex.createCriteria();
	// cr.andJobIdEqualTo(jobId);
	// returnList = mapper.selectByExample(ex);
	// } finally {
	// sqlSession.close();
	// }
	// return returnList;
	// }

	// /**
	// *
	// * @param key
	// * @return SysFunctionRole
	// * @throws Exception
	// */
	// public SysFunctionRole queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionRole> returnList = null;
	// try
	// {
	// SysFunctionRoleMapper mapper =
	// sqlSession.getMapper(SysFunctionRoleMapper.class);
	// //SysFunctionRoleExample xp = new SysFunctionRoleExample();
	// //Criteria criteria = xp.createCriteria();
	// // if (StringUtils.isNotBlank(jobId))
	// // {
	// // criteria.andJobIdEqualTo(jobId);
	// // }
	// //returnList = mapper.selectByExample(xp);
	// log.debug(returnList == null ? "returnList is null" : "筆數:" +
	// returnList.size());
	// }
	// finally
	// {
	// sqlSession.close();
	// }
	// return CollectionUtils.isNotEmpty(returnList) ? returnList.get(0)
	// : null;
	// }

	/**
	 * /* @param key /* @return /* @throws Exception /
	 */
	public List<SysFunctionRole> queryBySysFunctionRole(final SysFunctionRole model) throws Exception {
		
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionRole> returnList = null;
		
		try {
			
            SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
            
            SysFunctionRoleExample xp = new SysFunctionRoleExample();          
            Criteria criteria = xp.createCriteria();
            
            //
            if (StringUtils.isNotBlank(model.getUserRole())){         	
            	criteria.andUserRoleEqualTo(model.getUserRole());         	           	
            }
			            
            returnList = mapper.selectByExample(xp);            
            log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());           
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return returnList;
	}

	/**
	 * /* @param key /* @return /* @throws Exception /
	 */
	public List<SysFunctionRole> queryBySysFunctionRole(final SysFunctionRole model, SqlSession sqlSession)throws Exception {
		
		List<SysFunctionRole> returnList = null;
		
		SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
		
		SysFunctionRoleExample xp = new SysFunctionRoleExample();
		Criteria criteria = xp.createCriteria();
		
		//
		if (StringUtils.isNotBlank(model.getUserRole())) {
			criteria.andUserRoleEqualTo(model.getUserRole());
		}

		returnList = mapper.selectByExample(xp);
		log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		return returnList;
	}

	/**
	 * 
	 * @param key
	 * @return int
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
			// count = mapper.deleteByPrimaryKey(primaryKey);//防呆,需要刪除再打開
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

	/**
	 * 
	 * @param model
	 * @return int
	 * @throws Exception
	 */
	public int update(final SysFunctionRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
			// count = mapper.updateByPrimaryKey(model);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

	/**
	 * /* @param insId /* @param prgId /* @param vhclInsId /* @return
	 */
	public List<SysFunctionRole> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionRole> result = null;
		try {
			SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
			result = mapper.selectByExample(null);
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return result;
	}

	/**
	 * /* @param insId /* @param prgId /* @param vhclInsId /* @return
	 */
	public List<SysFunctionRole> queryAll(SqlSession sqlSession) throws Exception {
		List<SysFunctionRole> result = null;
		SysFunctionRoleMapper mapper = sqlSession.getMapper(SysFunctionRoleMapper.class);
		result = mapper.selectByExample(null);
		return result;
	}

	/// **
	// * @param insId
	// * @param prgId
	// * @param vhclInsId
	// * @return
	// */
	// public int deleteAll() throws Exception {
	// SqlSession sqlSession = ConnectionFactory.getSession().openSession();
	// int result = 0;
	// try {
	// SysFunctionRoleMapper mapper =
	/// session.getMapper(SysFunctionRoleMapper.class);
	// result = mapper.deleteAll();
	// session.commit();
	// } catch (Exception e) {
	// session.rollback();
	// throw e;
	// } finally {
	// session.close();
	// }
	// return result;
	// }
}