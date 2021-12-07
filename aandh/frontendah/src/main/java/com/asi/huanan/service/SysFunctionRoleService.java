package com.asi.huanan.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.huanan.service.dao.mybatis.mapper.SysFunctionRoleMapper;
import com.asi.huanan.service.dao.mybatis.model.SysFunctionRole;
import com.asi.huanan.service.repository.SysFunctionRoleRepository;

@Service
public class SysFunctionRoleService {

	private Log log = LogFactory.getLog(SysFunctionRoleService.class);

	@Autowired
	private SysFunctionRoleRepository repository;

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
	public int insert(final SysFunctionRole model, SysFunctionRoleMapper mapper) throws Exception {
		return repository.insert(model, mapper);
	}

	/**
	 * 
	 * @param primaryKey
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, SysFunctionRoleMapper mapper) throws Exception {
		return repository.deleteByKey(primaryKey, mapper);
	}

	/**
	 * 
	 * @param model
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int update(final SysFunctionRole model, SysFunctionRoleMapper mapper) throws Exception {
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
	// public int insert(final SysFunctionRole model, SqlSession sqlSession) throws
	// Exception {
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
	// public int update(final SysFunctionRole model, SqlSession sqlSession) throws
	// Exception {
	// return repository.update(model, sqlSession);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysFunctionRole model) throws Exception {
		return repository.insert(model);
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertList(final List<SysFunctionRole> modelList) throws Exception {
		return repository.insertList(modelList);
	}

	// /**
	// *
	// * @param modelList
	// * @return Key:SUCC_VAL(成功筆數,int),ERR_OBJ_LIST(失敗model,List＜SysFunctionRole＞)
	// * @throws Exception
	// */
	// public Map<String, Object> insertList(List<SysFunctionRole> modelList)
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
	// public SysFunctionRole queryByJobId(final String jobId) throws Exception
	// {
	// return repository.queryByJobId(jobId);
	// }

	/**
	 * 
	 * @param SysFunctionRole
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionRole> queryBySysFunctionRole(final SysFunctionRole model) throws Exception {
		return repository.queryBySysFunctionRole(model);
	}

	/**
	 * 
	 * @param SysFunctionRole
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionRole> queryBySysFunctionRole(final SysFunctionRole model, SqlSession sqlSession)
			throws Exception {
		return repository.queryBySysFunctionRole(model, sqlSession);
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
	public int update(final SysFunctionRole model) throws Exception {
		return repository.update(model);
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionRole> queryAll() throws Exception {
		return repository.queryAll();
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysFunctionRole> queryAll(SqlSession sqlSession) throws Exception {
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