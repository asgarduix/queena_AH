package com.asi.huanan.service.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysIndexMapper;
import com.asi.huanan.service.dao.mybatis.model.SysIndex;
import com.asi.huanan.service.dao.mybatis.model.SysIndexExample;
import com.asi.huanan.service.dao.mybatis.model.SysIndexExample.Criteria;

import io.swagger.models.Model;

import org.apache.commons.lang3.StringUtils;

@Repository
public class SysIndexRepository {

	private Log log = LogFactory.getLog(SysIndexRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<SysIndex> queryByModelBetweenSize(final SysIndex model, String orderByColNm1, String ascOrDesc,
			int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndex> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);

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
	public int queryCount(SysIndex model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	public int insert(final SysIndex model, SysIndexMapper mapper) {
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
	public int deleteByKey(final String primaryKey, SysIndexMapper mapper) throws Exception {
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
	public int update(final SysIndex model, SysIndexMapper mapper) throws Exception {
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
	// public int insert(final SysIndex model, SqlSession sqlSession) {
	// SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	// SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	// public int update(final SysIndex model, SqlSession sqlSession) throws
	// Exception {
	// SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysIndex model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	public int insertList(final List<SysIndex> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);

			for (SysIndex model : modelList) {
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
	// * @return List<SysIndex>
	// * @throws Exception
	// */
	// public List<SysIndex> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysIndex> returnList = null;
	// try {
	// SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
	// SysIndexExample ex = new SysIndexExample();
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
	// * @return SysIndex
	// * @throws Exception
	// */
	// public SysIndex queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysIndex> returnList = null;
	// try
	// {
	// SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
	// //SysIndexExample xp = new SysIndexExample();
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
	public List<SysIndex> queryBySysIndex(final SysIndex model) throws Exception {
		
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndex> returnList = null;
		
		try {
			
            SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
            SysIndexExample xp = new SysIndexExample();
            Criteria criteria = xp.createCriteria();
            
            //
			if(null != model.getIndexId()) {
				criteria.andIndexIdEqualTo(model.getIndexId());
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
	public List<SysIndex> queryBySysIndex(final SysIndex model, SqlSession sqlSession) throws Exception {
		List<SysIndex> returnList = null;
//            SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
//            SysIndexExample xp = new SysIndexExample();
//            Criteria criteria = xp.createCriteria();
//            if (StringUtils.isNotBlank(model.get{VAR_NAME}()))
//            {
//            criteria.and{VAR_NAME}EqualTo(model.get{VAR_NAME}());
//            }
//			
//            // if (StringUtils.isNotBlank(model.getJobName()))
//            // {
//            // criteria.andJobNameEqualTo(model.getJobName());
//            // }
//            // returnList = mapper.selectByExample(xp);
//            log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		return returnList;
	}

	/**
	 * /* @param key /* @return /* @throws Exception /
	 */
	public List<SysIndex> queryBySysIndex4MultiIndexId(final List<SysIndex> models, SqlSession sqlSession)
			throws Exception {
		List<SysIndex> returnList = null;
		SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
		List<BigDecimal> indexIdList = models.stream().filter(model -> model.getIndexId() != null)
				.map(model -> model.getIndexId()).collect(Collectors.toList());
		returnList = mapper.selectByIdexidList(indexIdList);
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
			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	public int update(final SysIndex model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	public List<SysIndex> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysIndex> result = null;
		try {
			SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	public List<SysIndex> queryAll(SqlSession sqlSession) throws Exception {
		List<SysIndex> result = null;
		SysIndexMapper mapper = sqlSession.getMapper(SysIndexMapper.class);
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
	// SysIndexMapper mapper = session.getMapper(SysIndexMapper.class);
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