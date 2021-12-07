package com.asi.huanan.service.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysFunctionUiButtonMapper;
import com.asi.huanan.service.dao.mybatis.mapper.SysIndexMapper;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiButton;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiButtonExample;
import com.asi.huanan.service.dao.mybatis.model.SysIndex;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiButtonExample.Criteria;
import org.apache.commons.lang3.StringUtils;

@Repository
public class SysFunctionUiButtonRepository {

	private Log log = LogFactory.getLog(SysFunctionUiButtonRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<SysFunctionUiButton> queryByModelBetweenSize(final SysFunctionUiButton model, String orderByColNm1,
			String ascOrDesc, int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionUiButton> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);

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
	public int queryCount(SysFunctionUiButton model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	public int insert(final SysFunctionUiButton model, SysFunctionUiButtonMapper mapper) {
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
	public int deleteByKey(final String primaryKey, SysFunctionUiButtonMapper mapper) throws Exception {
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
	public int update(final SysFunctionUiButton model, SysFunctionUiButtonMapper mapper) throws Exception {
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
	// public int insert(final SysFunctionUiButton model, SqlSession sqlSession) {
	// SysFunctionUiButtonMapper mapper =
	// sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	// SysFunctionUiButtonMapper mapper =
	// sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	// public int update(final SysFunctionUiButton model, SqlSession sqlSession)
	// throws Exception {
	// SysFunctionUiButtonMapper mapper =
	// sqlSession.getMapper(SysFunctionUiButtonMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionUiButton model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	public int insertList(final List<SysFunctionUiButton> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);

			for (SysFunctionUiButton model : modelList) {
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
	 * /* @param key /* @return /* @throws Exception /
	 */
	public List<SysFunctionUiButton> queryBySysIndex4MultiButtonId(final List<SysFunctionUiButton> models,
			SqlSession sqlSession) throws Exception {
		List<SysFunctionUiButton> returnList = null;
		SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
		List<BigDecimal> indexIdList = models.stream().filter(model -> model.getFunctionUiButtonId() != null)
				.map(model -> model.getFunctionUiButtonId()).collect(Collectors.toList());
		returnList = mapper.selectByButtonIdList(indexIdList);
		log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		return returnList;
	}

	// /**
	// *
	// * @return List<SysFunctionUiButton>
	// * @throws Exception
	// */
	// public List<SysFunctionUiButton> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionUiButton> returnList = null;
	// try {
	// SysFunctionUiButtonMapper mapper =
	// sqlSession.getMapper(SysFunctionUiButtonMapper.class);
	// SysFunctionUiButtonExample ex = new SysFunctionUiButtonExample();
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
	// * @return SysFunctionUiButton
	// * @throws Exception
	// */
	// public SysFunctionUiButton queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionUiButton> returnList = null;
	// try
	// {
	// SysFunctionUiButtonMapper mapper =
	// sqlSession.getMapper(SysFunctionUiButtonMapper.class);
	// //SysFunctionUiButtonExample xp = new SysFunctionUiButtonExample();
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
	public List<SysFunctionUiButton> queryBySysFunctionUiButton(final SysFunctionUiButton model) throws Exception {
		
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();		
		List<SysFunctionUiButton> returnList = null;
		
		try {
			
            SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
            
            SysFunctionUiButtonExample xp = new SysFunctionUiButtonExample();          
            Criteria criteria = xp.createCriteria();
                
            //
            if(null != model.getFunctionUiButtonId()) {
            	criteria.andFunctionUiButtonIdEqualTo(model.getFunctionUiButtonId());
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
	public List<SysFunctionUiButton> queryBySysFunctionUiButton(final SysFunctionUiButton model, SqlSession sqlSession)throws Exception {
		
		List<SysFunctionUiButton> returnList = null;
		
        SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
            
        SysFunctionUiButtonExample xp = new SysFunctionUiButtonExample();            
        Criteria criteria = xp.createCriteria();
            
        //
        if(null != model.getFunctionUiButtonId()) {
        	criteria.andFunctionUiButtonIdEqualTo(model.getFunctionUiButtonId());
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
			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	public int update(final SysFunctionUiButton model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	public List<SysFunctionUiButton> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionUiButton> result = null;
		try {
			SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	public List<SysFunctionUiButton> queryAll(SqlSession sqlSession) throws Exception {
		List<SysFunctionUiButton> result = null;
		SysFunctionUiButtonMapper mapper = sqlSession.getMapper(SysFunctionUiButtonMapper.class);
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
	// SysFunctionUiButtonMapper mapper =
	/// session.getMapper(SysFunctionUiButtonMapper.class);
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