package com.asi.huanan.service.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysIndexRoleMapper;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRole;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRoleExample;
import com.asi.huanan.service.dao.mybatis.model.SysIndexRoleExample.Criteria;
import org.apache.commons.lang3.StringUtils;

@Repository
public class SysIndexRoleRepository {

	private Log log = LogFactory.getLog(SysIndexRoleRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<SysIndexRole> queryByModelBetweenSize(final SysIndexRole model, String orderByColNm1, String ascOrDesc,
			int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndexRole> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);

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
	public int queryCount(SysIndexRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	public int insert(final SysIndexRole model, SysIndexRoleMapper mapper) {
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
	public int deleteByKey(final String primaryKey, SysIndexRoleMapper mapper) throws Exception {
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
	public int update(final SysIndexRole model, SysIndexRoleMapper mapper) throws Exception {
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
	// public int insert(final SysIndexRole model, SqlSession sqlSession) {
	// SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	// SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	// public int update(final SysIndexRole model, SqlSession sqlSession) throws
	// Exception {
	// SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysIndexRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	public int insertList(final List<SysIndexRole> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);

			for (SysIndexRole model : modelList) {
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
	// * @return List<SysIndexRole>
	// * @throws Exception
	// */
	// public List<SysIndexRole> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysIndexRole> returnList = null;
	// try {
	// SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
	// SysIndexRoleExample ex = new SysIndexRoleExample();
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
	// * @return SysIndexRole
	// * @throws Exception
	// */
	// public SysIndexRole queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysIndexRole> returnList = null;
	// try
	// {
	// SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
	// //SysIndexRoleExample xp = new SysIndexRoleExample();
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
	public List<SysIndexRole> queryBySysIndexRole(final SysIndexRole model) throws Exception {
		
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndexRole> returnList = null;
		
		try {
			
            SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);          
            SysIndexRoleExample xp = new SysIndexRoleExample();         
            Criteria criteria = xp.createCriteria();
            
            //
    		if (StringUtils.isNotBlank(model.getUserRole())) {
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
	public List<SysIndexRole> queryBySysIndexRole(final SysIndexRole model, SqlSession sqlSession) throws Exception {
		List<SysIndexRole> returnList = null;
		SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
		SysIndexRoleExample xp = new SysIndexRoleExample();
		Criteria criteria = xp.createCriteria();
		if (StringUtils.isNotBlank(model.getUserRole())) {
			criteria.andUserRoleEqualTo(model.getUserRole());
		}

		// if (StringUtils.isNotBlank(model.getJobName()))
		// {
		// criteria.andJobNameEqualTo(model.getJobName());
		// }
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
			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	public int update(final SysIndexRole model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	public List<SysIndexRole> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndexRole> result = null;
		try {
			SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	public List<SysIndexRole> queryAll(SqlSession sqlSession) throws Exception {
		List<SysIndexRole> result = null;
		SysIndexRoleMapper mapper = sqlSession.getMapper(SysIndexRoleMapper.class);
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
	// SysIndexRoleMapper mapper = session.getMapper(SysIndexRoleMapper.class);
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