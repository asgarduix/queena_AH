package com.asi.huanan.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.huanan.service.dao.mybatis.mapper.SysMenuRoleMapper;
import com.asi.huanan.service.dao.mybatis.model.SysMenuRole;
import com.asi.huanan.service.repository.SysMenuRoleRepository;

@Service
public class SysMenuRoleService {

	private Log log = LogFactory.getLog(SysMenuRoleService.class);

	@Autowired
	private SysMenuRoleRepository repository;

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
	public int insert(final SysMenuRole model, SysMenuRoleMapper mapper) throws Exception {
		return repository.insert(model, mapper);
	}

	/**
	 * 
	 * @param primaryKey
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, SysMenuRoleMapper mapper) throws Exception {
		return repository.deleteByKey(primaryKey, mapper);
	}

	/**
	 * 
	 * @param model
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int update(final SysMenuRole model, SysMenuRoleMapper mapper) throws Exception {
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
	// public int insert(final SysMenuRole model, SqlSession sqlSession) throws
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
	// public int update(final SysMenuRole model, SqlSession sqlSession) throws
	// Exception {
	// return repository.update(model, sqlSession);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final SysMenuRole model) throws Exception {
		return repository.insert(model);
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertList(final List<SysMenuRole> modelList) throws Exception {
		return repository.insertList(modelList);
	}

	// /**
	// *
	// * @param modelList
	// * @return Key:SUCC_VAL(成功筆數,int),ERR_OBJ_LIST(失敗model,List＜SysMenuRole＞)
	// * @throws Exception
	// */
	// public Map<String, Object> insertList(List<SysMenuRole> modelList)
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
	// public SysMenuRole queryByJobId(final String jobId) throws Exception
	// {
	// return repository.queryByJobId(jobId);
	// }

	/**
	 * 
	 * @param SysMenuRole
	 * @return
	 * @throws Exception
	 */
	public List<SysMenuRole> queryBySysMenuRole(final SysMenuRole model) throws Exception {
		return repository.queryBySysMenuRole(model);
	}

	/**
	 * 
	 * @param SysMenuRole
	 * @return
	 * @throws Exception
	 */
	public List<SysMenuRole> queryBySysMenuRole(final SysMenuRole model, SqlSession sqlSession) throws Exception {
		return repository.queryBySysMenuRole(model, sqlSession);
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
	public int update(final SysMenuRole model) throws Exception {
		return repository.update(model);
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysMenuRole> queryAll() throws Exception {
		return repository.queryAll();
	}

	/**
	 * 
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public List<SysMenuRole> queryAll(SqlSession sqlSession) throws Exception {
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