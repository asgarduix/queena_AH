package com.asi.service.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.service.connector.MyBatisConnector;
import com.asi.service.dao.mybatis.mapper.AppHolidayMapper;
import com.asi.service.dao.mybatis.model.AppHoliday;
import com.asi.service.dao.mybatis.model.AppHolidayExample;
import com.asi.service.dao.mybatis.model.AppHolidayExample.Criteria;

@Repository
public class AppHolidayRepository {

	private Log log = LogFactory.getLog(AppHolidayRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<AppHoliday> queryByModelBetweenSize(final AppHoliday model, String orderByColNm1, String ascOrDesc,
			int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<AppHoliday> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);

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
	public int queryCount(AppHoliday model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
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
	public int insert(final AppHoliday model, AppHolidayMapper mapper) {
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
	public int deleteByKey(final String primaryKey, AppHolidayMapper mapper) throws Exception {
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
	public int update(final AppHoliday model, AppHolidayMapper mapper) throws Exception {
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
	// public int insert(final AppHoliday model, SqlSession sqlSession) {
	// AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
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
	// AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
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
	// public int update(final AppHoliday model, SqlSession sqlSession) throws
	// Exception {
	// AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final AppHoliday model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
			count = mapper.insertSelective(model);
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
	public int insertList(final List<AppHoliday> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);

			for (AppHoliday model : modelList) {
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

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<AppHoliday> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<AppHoliday> returnList = null;
		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
			AppHolidayExample example = new AppHolidayExample();
			Criteria cc = example.createCriteria();
			returnList = mapper.selectByExample(example);
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return returnList;
	}

	// /**
	// *
	// * @return List<AppHoliday>
	// * @throws Exception
	// */
	// public List<AppHoliday> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<AppHoliday> returnList = null;
	// try {
	// AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
	// AppHolidayExample ex = new AppHolidayExample();
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
	// * @return AppHoliday
	// * @throws Exception
	// */
	// public AppHoliday queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<AppHoliday> returnList = null;
	// try
	// {
	// AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
	// //AppHolidayExample xp = new AppHolidayExample();
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
	 * 
	 * @param key
	 * @return AppHoliday
	 * @throws Exception
	 */
	public List<AppHoliday> queryByAppHoliday(final AppHoliday model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<AppHoliday> returnList = null;
		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
			AppHolidayExample xp = new AppHolidayExample();
			Criteria criteria = xp.createCriteria();
			if (StringUtils.isNotBlank(model.getUuid())) {
				criteria.andUuidEqualTo(model.getUuid());
			}

			if (StringUtils.isNotBlank(model.getUuid())) {
				criteria.andUuidEqualTo(model.getUuid());
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
	 * 
	 * @param key
	 * @return int
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
			count = mapper.deleteByPrimaryKey(primaryKey);// 防呆,需要刪除再打開
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
	public int update(final AppHoliday model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			AppHolidayMapper mapper = sqlSession.getMapper(AppHolidayMapper.class);
			count = mapper.updateByPrimaryKey(model);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

	/// **
	// * @param insId
	// * @param prgId
	// * @param vhclInsId
	// * @return
	// */
	// public List<AppHoliday> queryAll() throws Exception {
	// SqlSession sqlSession = ConnectionFactory.getSession().openSession();
	// List<AppHoliday> result = null;
	// try {
	// AppHolidayMapper mapper = session.getMapper(AppHolidayMapper.class);
	// result = mapper.selectAll();
	// } catch (Exception e) {
	// session.rollback();
	// throw e;
	// } finally {
	// session.close();
	// }
	// return result;
	// }
	//
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
	// AppHolidayMapper mapper = session.getMapper(AppHolidayMapper.class);
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
