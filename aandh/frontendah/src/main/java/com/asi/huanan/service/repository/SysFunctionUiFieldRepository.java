package com.asi.huanan.service.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysFunctionUiFieldMapper;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiField;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiFieldExample;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiFieldExample.Criteria;

@Repository
public class SysFunctionUiFieldRepository {

	private Log log = LogFactory.getLog(SysFunctionUiFieldRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	// =====針對使用自訂SQL=====

	/**
	 * 
	 */
	public List<SysFunctionUiField> queryByModelBetweenSize(final SysFunctionUiField model, String orderByColNm1,
			String ascOrDesc, int pageSize, int pageNum) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionUiField> returnList = null;

		try {
			// Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);

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
	public int queryCount(SysFunctionUiField model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			// if (model.{GET} != null & !"".equals(model.{GET})) {
			// model.{SET}(model.{GET} + "%");
			// }

			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	public int insert(final SysFunctionUiField model, SysFunctionUiFieldMapper mapper) {
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
	public int deleteByKey(final String primaryKey, SysFunctionUiFieldMapper mapper) throws Exception {
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
	public int update(final SysFunctionUiField model, SysFunctionUiFieldMapper mapper) throws Exception {
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
	// public int insert(final SysFunctionUiField model, SqlSession sqlSession) {
	// SysFunctionUiFieldMapper mapper =
	// sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	// SysFunctionUiFieldMapper mapper =
	// sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	// public int update(final SysFunctionUiField model, SqlSession sqlSession)
	// throws Exception {
	// SysFunctionUiFieldMapper mapper =
	// sqlSession.getMapper(SysFunctionUiFieldMapper.class);
	// return mapper.updateByPrimaryKey(model);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionUiField model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	public int insertList(final List<SysFunctionUiField> modelList) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;

		try {
			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);

			for (SysFunctionUiField model : modelList) {
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
	public List<SysFunctionUiField> selectByFieldIdList(final List<SysFunctionUiField> models,
			SqlSession sqlSession) throws Exception {
		List<SysFunctionUiField> returnList = null;
		SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
		List<BigDecimal> idList = models.stream().filter(model -> model.getFunctionUiFieldId() != null)
				.map(model -> model.getFunctionUiFieldId()).collect(Collectors.toList());
		returnList = mapper.selectByFieldIdList(idList);
		log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		return returnList;
	}

	// /**
	// *
	// * @return List<SysFunctionUiField>
	// * @throws Exception
	// */
	// public List<SysFunctionUiField> queryByJobId(final String jobId)
	// throws Exception {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionUiField> returnList = null;
	// try {
	// SysFunctionUiFieldMapper mapper =
	// sqlSession.getMapper(SysFunctionUiFieldMapper.class);
	// SysFunctionUiFieldExample ex = new SysFunctionUiFieldExample();
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
	// * @return SysFunctionUiField
	// * @throws Exception
	// */
	// public SysFunctionUiField queryByJobId(final String id) throws Exception
	// {
	// SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	// List<SysFunctionUiField> returnList = null;
	// try
	// {
	// SysFunctionUiFieldMapper mapper =
	// sqlSession.getMapper(SysFunctionUiFieldMapper.class);
	// //SysFunctionUiFieldExample xp = new SysFunctionUiFieldExample();
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
	public List<SysFunctionUiField> queryBySysFunctionUiField(final SysFunctionUiField model) throws Exception {
		
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		
		List<SysFunctionUiField> returnList = null;
		
		try {
			
            SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
            
            SysFunctionUiFieldExample xp = new SysFunctionUiFieldExample();         
            Criteria criteria = xp.createCriteria();
            
            //
            if (null != model.getFunctionUiFieldId()) {
            	criteria.andFunctionUiFieldIdEqualTo( model.getFunctionUiFieldId());
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
	public List<SysFunctionUiField> queryBySysFunctionUiField(final SysFunctionUiField model, SqlSession sqlSession)throws Exception {
		
		List<SysFunctionUiField> returnList = null;
		
        SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
            
        SysFunctionUiFieldExample xp = new SysFunctionUiFieldExample();           
        Criteria criteria = xp.createCriteria();
            
        //
        if (null != model.getFunctionUiFieldId()) {
        	criteria.andFunctionUiFieldIdEqualTo( model.getFunctionUiFieldId());
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
			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	public int update(final SysFunctionUiField model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		try {
			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	public List<SysFunctionUiField> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysFunctionUiField> result = null;
		try {
			SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	public List<SysFunctionUiField> queryAll(SqlSession sqlSession) throws Exception {
		List<SysFunctionUiField> result = null;
		SysFunctionUiFieldMapper mapper = sqlSession.getMapper(SysFunctionUiFieldMapper.class);
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
	// SysFunctionUiFieldMapper mapper =
	/// session.getMapper(SysFunctionUiFieldMapper.class);
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