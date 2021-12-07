package com.asi.huanan.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.huanan.service.dao.mybatis.mapper.SysFunctionUiFieldMapper;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionUiField;
import com.asi.huanan.service.repository.SysFunctionUiFieldRepository;

@Service
public class SysFunctionUiFieldService {

	private Log log = LogFactory.getLog(SysFunctionUiFieldService.class);

	@Autowired
	private SysFunctionUiFieldRepository repository;

	// =====針對使用自訂SQL=====

	// ...

	// ==========

	/**
	 * 
	 * @param model
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionUiField model, SysFunctionUiFieldMapper mapper) throws Exception {
		return repository.insert(model, mapper);
	}

	/**
	 * 
	 * @param primaryKey
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, SysFunctionUiFieldMapper mapper) throws Exception {
		return repository.deleteByKey(primaryKey, mapper);
	}

	/**
	 * 
	 * @param model
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int update(final SysFunctionUiField model, SysFunctionUiFieldMapper mapper) throws Exception {
		return repository.update(model, mapper);
	}

	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	// public int insert(final SysFunctionUiField model, SqlSession sqlSession)
	// throws Exception {
	// return repository.insert(model, sqlSession);
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
	// return repository.deleteByKey(primaryKey, sqlSession);
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
	// return repository.update(model, sqlSession);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionUiField model) throws Exception {
		return repository.insert(model);
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertList(final List<SysFunctionUiField> modelList) throws Exception {
		return repository.insertList(modelList);
	}

	// /**
	// *
	// * @param modelList
	// * @return
	// Key:SUCC_VAL(成功筆數,int),ERR_OBJ_LIST(失敗model,List＜SysFunctionUiField＞)
	// * @throws Exception
	// */
	// public Map<String, Object> insertList(List<SysFunctionUiField> modelList)
	// throws Exception
	// {
	// return repository.insertList(modelList);
	// }

	// /**
	// *
	// * @param nmArray
	// * @param paraNmArray
	// * @param moduleNm
	// * @return
	// * @throws Exception
	// */
	// public Map<String, String> queryAllReturnMap(String[] paraNmArray,
	// String moduleNm) throws Exception
	// {
	// return repository.queryAllReturnMap(paraNmArray, moduleNm);
	// }

	// /**
	// *
	// * @param jobId
	// * @return
	// * @throws Exception
	// */
	// public SysFunctionUiField queryByJobId(final String jobId) throws Exception
	// {
	// return repository.queryByJobId(jobId);
	// }

	/**
	 * 
	 * @param models
	 * @param SysIndex
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionUiField> queryByFieldIdList(List<SysFunctionUiField> models,
			SqlSession sqlSession) throws Exception {
		return repository.selectByFieldIdList(models, sqlSession);
	}

	/**
	 * 
	 * @param SysFunctionUiField
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionUiField> queryBySysFunctionUiField(final SysFunctionUiField model) throws Exception {
		return repository.queryBySysFunctionUiField(model);
	}

	/**
	 * 
	 * @param SysFunctionUiField
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionUiField> queryBySysFunctionUiField(final SysFunctionUiField model, SqlSession sqlSession)
			throws Exception {
		return repository.queryBySysFunctionUiField(model, sqlSession);
	}

	/**
	 * 
	 * @param primaryKey
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey) throws Exception {
		return repository.deleteByKey(primaryKey);
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int update(final SysFunctionUiField model) throws Exception {
		return repository.update(model);
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionUiField> queryAll() throws Exception {
		return repository.queryAll();
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionUiField> queryAll(SqlSession sqlSession) throws Exception {
		return repository.queryAll(sqlSession);
	}

	// /**
	// *
	// * @return
	// * @throws Exception
	// */
	// public int deleteAll() throws Exception{
	// return repository.deleteAll();
	// }

}