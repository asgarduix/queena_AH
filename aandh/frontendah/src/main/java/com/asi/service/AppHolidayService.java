package com.asi.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asi.service.dao.mybatis.mapper.AppHolidayMapper;
import com.asi.service.dao.mybatis.model.AppHoliday;
import com.asi.service.repository.AppHolidayRepository;

@Service
public class AppHolidayService {

	private Log log = LogFactory.getLog(AppHolidayService.class);

	@Autowired
	private AppHolidayRepository repository;

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
	public int insert(final AppHoliday model, AppHolidayMapper mapper) throws Exception {
		return repository.insert(model, mapper);
	}

	/**
	 * 
	 * @param primaryKey
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, AppHolidayMapper mapper) throws Exception {
		return repository.deleteByKey(primaryKey, mapper);
	}

	/**
	 * 
	 * @param model
	 * @param mapper
	 * @return
	 * @throws Exception
	 */
	public int update(final AppHoliday model, AppHolidayMapper mapper) throws Exception {
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
	// public int insert(final AppHoliday model, SqlSession sqlSession) throws
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
	// public int update(final AppHoliday model, SqlSession sqlSession) throws
	// Exception {
	// return repository.update(model, sqlSession);
	// }

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insert(final AppHoliday model) throws Exception {
		return repository.insert(model);
	}

	/**
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int insertList(final List<AppHoliday> modelList) throws Exception {
		return repository.insertList(modelList);
	}

	// /**
	// *
	// * @param modelList
	// * @return Key:SUCC_VAL(成功筆數,int),ERR_OBJ_LIST(失敗model,List＜AppHoliday＞)
	// * @throws Exception
	// */
	// public Map<String, Object> insertList(List<AppHoliday> modelList)
	// throws Exception
	// {
	// return repository.insertList(modelList);
	// }

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<AppHoliday> queryAll() throws Exception {
		return repository.queryAll();
	}

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
	// public AppHoliday queryByJobId(final String jobId) throws Exception
	// {
	// return repository.queryByJobId(jobId);
	// }

	/**
	 * 
	 * @param AppHoliday
	 * @return
	 * @throws Exception
	 */
	public List<AppHoliday> queryByAppHoliday(final AppHoliday model) throws Exception {
		return repository.queryByAppHoliday(model);
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
	public int update(final AppHoliday model) throws Exception {
		return repository.update(model);
	}

	/// **
	// * @return
	// * @throws Exception
	// *
	// */
	// public List<AppHoliday> queryAll() throws Exception{
	// return repository.queryAll();
	// }
	//
	// /**
	// *
	// * @return
	// * @throws Exception
	// */
	// public int deleteAll() throws Exception{
	// return repository.deleteAll();
	// }

}
