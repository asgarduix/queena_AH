package com.asi.huanan.service.repository;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysUserPersonalMapper;
import com.asi.huanan.service.dao.mybatis.model.SysUserPersonal;
import com.asi.huanan.service.dao.mybatis.model.SysUserPersonalExample;
import com.asi.huanan.service.dao.mybatis.model.SysUserPersonalExample.Criteria;

@Repository
public class SysUserPersonalRepository {

	private Log log = LogFactory.getLog(SysUserPersonalRepository.class);

	@Autowired
	private MyBatisConnector mybatis;
	
	//=====針對使用自訂SQL=====
	
	/**
	 * 
	 */
	public List<SysUserPersonal> queryByModelBetweenSize(final SysUserPersonal model, String orderByColNm1, String ascOrDesc, int pageSize, int pageNum)
			throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysUserPersonal> returnList = null;

		try {
			//Integer[] a = CalculatorUtil.caculatorPageStartEndNum(pageSize, pageNum);

			SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);

			//if (model.{GET} != null & !"".equals(model.{GET})) {
			//	model.{SET}(model.{GET} + "%");
			//}

			//returnList = mapper.selectByParamBetweenSize(model.{GET}..., "CRT_TIME", "DESC", a[0], a[1]);

			log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
		} catch(Exception e){
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
	public int queryCount(SysUserPersonal model) throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		
		try {
			//if (model.{GET} != null & !"".equals(model.{GET})) {
			//	model.{SET}(model.{GET} + "%");
			//}

			SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
			//count = mapper.selectCountByParamBetweenSize(model.{GET}...);
		} catch(Exception e){
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		
		return count;
	}
	
	//=====以下為基本使用的=====
	
	/**
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 */
	public int insert(final SysUserPersonal model, SysUserPersonalMapper mapper) {
		//return mapper.insertSelective(model);
		return 0;
	}
	
	/**
	 * 
	 * @param primaryKey
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public int deleteByKey(final String primaryKey, SysUserPersonalMapper mapper) throws Exception {
		//return mapper.deleteByPrimaryKey(primaryKey);
		return 0;
	}

	/**
	 * 
	 * @param model
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	public int update(final SysUserPersonal model, SysUserPersonalMapper mapper) throws Exception {
		//return mapper.(model);
		return 0;
	}
	
	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * @param model
	 * @param sqlSession
	 * @return
	 */
	//public int insert(final SysUserPersonal model, SqlSession sqlSession) {
	//	SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
	//	return mapper.insertSelective(model);
	//}

	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * @param primaryKey
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	//public int deleteByKey(final String primaryKey, SqlSession sqlSession) throws Exception {
	//	SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
	//	return mapper.deleteByPrimaryKey(primaryKey);
	//}
    
	/**
	 * (注意!一個SqlSession不能重複開啟同一個Mapper,故此不建議使用)
	 * @param model
	 * @param sqlSession
	 * @return
	 * @throws Exception
	 */
	//public int update(final SysUserPersonal model, SqlSession sqlSession) throws Exception {
	//	SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
	//	return mapper.updateByPrimaryKey(model);
	//}

    /**
     * 
     * @param model
     * @return
     * @throws Exception
     */
    public int insert(final SysUserPersonal model) throws Exception
    {
        SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
        int count = 0;
		
        try
        {
            SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
            //count = mapper.insertSelective(model);
            sqlSession.commit();
        } catch(Exception e){
			sqlSession.rollback();
			throw e;
		}
        finally
        {
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
	public int insertList(final List<SysUserPersonal> modelList)
			throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		int count = 0;
		
		try {
			SysUserPersonalMapper mapper = sqlSession
					.getMapper(SysUserPersonalMapper.class);

			for (SysUserPersonal model : modelList) {
				//count += mapper.insertSelective(model);
			}

			sqlSession.commit();
		} catch(Exception e){
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
		return count;
	}

//     /**
//     *
//     * @return List<SysUserPersonal>
//     @throws Exception
//     * */
     public List<SysUserPersonal> queryByUserId(final String UserId)
     throws Exception {
     SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
     List<SysUserPersonal> returnList = null;
     try {
     SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
     SysUserPersonalExample ex = new SysUserPersonalExample();
     Criteria cr = ex.createCriteria();
     cr.andUserIdEqualTo(UserId);
     returnList = mapper.selectByExample(ex);
     } finally {
     sqlSession.close();
     }
     return returnList;
     }

    
//      @param key
//      @return SysUserPersonal
//      @throws Exception
      
//     public SysUserPersonal queryByUserId(final String id) throws Exception
//     {
//         SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
//         List<SysUserPersonal> returnList = null;
//         try
//         {
//             SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
//             SysUserPersonalExample xp = new SysUserPersonalExample();
//             Criteria criteria = xp.createCriteria();
//              if (StringUtils.isNotBlank(id)){
//            	  criteria.andUserIdEqualTo(id);
//              }
//             returnList = mapper.selectByExample(xp);
//             log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
//         }
//         finally
//         {
//             sqlSession.close();
//         }
//         return CollectionUtils.isNotEmpty(returnList) ? returnList.get(0)
//                 : null;
//     }


	/** 
	/* @param key
	/* @return 
	/* @throws Exception
	/*/
    public List<SysUserPersonal> queryBySysUserPersonal(final SysUserPersonal model)
            throws Exception
    {
        SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
        List<SysUserPersonal> returnList = null;
        try
        {
//            SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
//            SysUserPersonalExample xp = new SysUserPersonalExample();
//            Criteria criteria = xp.createCriteria();
//            if (StringUtils.isNotBlank(model.getPageBg())){
//            	criteria.andPageBgEqualTo(model.getPageBg());
//            }
			
            // if (StringUtils.isNotBlank(model.getJobName()))
            // {
            // criteria.andJobNameEqualTo(model.getJobName());
            // }
//            returnList = mapper.selectByExample(xp);
            log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
        } catch(Exception e){
			sqlSession.rollback();
			throw e;
		}
        finally
        {
            sqlSession.close();
        }
        return returnList;
    }

	/** 
	/* @param key
	/* @return 
	/* @throws Exception
	/*/
    public List<SysUserPersonal> queryBySysUserPersonal(final SysUserPersonal model, SqlSession sqlSession)
            throws Exception
    {
        List<SysUserPersonal> returnList = null;
//            SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
//            SysUserPersonalExample xp = new SysUserPersonalExample();
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
     * 
     * @param key
     * @return int
     * @throws Exception
     */
    public int deleteByKey(final String primaryKey) throws Exception
    {
        SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
        int count = 0;
		
        try
        {
            SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
            // count = mapper.deleteByPrimaryKey(primaryKey);//防呆,需要刪除再打開
            sqlSession.commit();
        } catch(Exception e){
			sqlSession.rollback();
			throw e;
		}
        finally
        {
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
    public int updatePageBg(SysUserPersonal sysUserPersonal, String userId) throws Exception
    {
        SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
        int count = 0;
        try{
          SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
          SysUserPersonalExample xp = new SysUserPersonalExample();
          Criteria criteria = xp.createCriteria();
          if (StringUtils.isNotBlank(userId)){
			criteria.andUserIdEqualTo(userId);
          }
       
          count = mapper.updateByExample(sysUserPersonal, xp);
          sqlSession.commit();
        } catch(Exception e){
        	sqlSession.rollback();
			throw e;
		}finally{
			sqlSession.close();
        }
        return count;
    }
	
    
   
    
//    
//	public int updatePrintnoByApplnoBuildno(Afentemp afentemp, String applno, String buildno) throws Exception {
//		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
//		int count = 0;
//		try {
//			AfentempMapper mapper = sqlSession.getMapper(AfentempMapper.class);
//			AfentempExample afentempExample = new AfentempExample();
//			Criteria cr = afentempExample.createCriteria();
//			if (StringUtils.isNotBlank(applno)){
//				cr.andApplnoEqualTo(applno);
//            }
//			if (StringUtils.isNotBlank(buildno)){
//				cr.andBuildnoEqualTo(buildno);
//            }
//			count = mapper.updateByExampleSelective(afentemp, afentempExample);
//		} catch (Exception e) {
//			sqlSession.rollback();
//			throw e;
//		} finally {
//			sqlSession.close();
//		}
//		return count;
//	}
	/**
	/* @param insId
	/* @param prgId
	/* @param vhclInsId
	/* @return
	*/
	public List<SysUserPersonal> queryAll() throws Exception {
		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
		List<SysUserPersonal> result = null;
		try {
			SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
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
	/* @param insId
	/* @param prgId
	/* @param vhclInsId
	/* @return
	*/
	public List<SysUserPersonal> queryAll(SqlSession sqlSession) throws Exception {
		List<SysUserPersonal> result = null;
		SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
		result = mapper.selectByExample(null);
		return result;
	}
	
	
	
	
	/**
	 * 更新個人設定主題
	 * @param sysUserPersonal
	 * @param userId
	 * @param pageBg 
	 * @return
	 * @throws Exception 
	 */
//	public int updatePageBgByUserId(SysUserPersonal sysUserPersonal, String userId, String pageBg) throws Exception {
//		SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
//		int count = 0;
//		try {
//			SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
//			SysUserPersonalExample xp = new SysUserPersonalExample();
//            Criteria criteria = xp.createCriteria();
//			if (StringUtils.isNotBlank(pageBg)){
//				criteria.andPageBgEqualTo(pageBg);
//            }
//			if (StringUtils.isNotBlank(userId)){
//				criteria.andUserIdEqualTo(userId);
//            }
//			count = mapper.updateByExampleSelective(sysUserPersonal, xp);
//		} catch (Exception e) {
//			sqlSession.rollback();
//			throw e;
//		} finally {
//			sqlSession.close();
//		}
//		return count;
//	}
	
	///**
	// * @param insId
	// * @param prgId
	// * @param vhclInsId
	// * @return
	// */
	//public int deleteAll() throws Exception {
	//	SqlSession sqlSession = ConnectionFactory.getSession().openSession();
	//	int result = 0;
	//	try {
	//		SysUserPersonalMapper mapper = session.getMapper(SysUserPersonalMapper.class);
	//		result = mapper.deleteAll();
	//		session.commit();
	//	} catch (Exception e) {
	//		session.rollback();
	//		throw e;
	//	} finally {
	//		session.close();
	//	}
	//	return result;
	//}
	
	///**
	// * 注意，此method解註解，須在mapper.java中實作selectDistintXXX方法
	// *可能類似「@Select("select distinct upvirs from amdupf1") List<Amdupf1> selectDistintTypins();」
	// * @param sqlSession
	// * @return
	// * @throws Exception
	// */
	//public List<SysUserPersonal> queryDistint{COL_NM}() throws Exception {
	//	SqlSession sqlSession = mybatis.createSqlSessionFactory().openSession();
	//	List<SysUserPersonal> returnList = null;
    //
	//	try {
	//		SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
	//		returnList = mapper.selectDistint{COL_NM}();
	//	} catch (Exception e) {
	//		throw e;
	//	} finally {
	//		sqlSession.close();
	//	}
    //
	//	log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
	//	return returnList;
	//}
    //
	///**
	// * 注意，此method解註解，須在mapper.java中實作selectDistintXXX方法
	// *可能類似「@Select("select distinct upvirs from amdupf1") List<Amdupf1> selectDistintTypins();」
	// * @param sqlSession
	// * @return
	// * @throws Exception
	// */
	//public List<SysUserPersonal> queryDistint{COL_NM}(SqlSession sqlSession) throws Exception {
	//	List<SysUserPersonal> returnList = null;
	//	
	//	SysUserPersonalMapper mapper = sqlSession.getMapper(SysUserPersonalMapper.class);
	//	
	//	returnList = mapper.selectDistint{COL_NM}();
	//	
	//	log.debug(returnList == null ? "returnList is null" : "筆數:" + returnList.size());
	//	return returnList;
	//}
}