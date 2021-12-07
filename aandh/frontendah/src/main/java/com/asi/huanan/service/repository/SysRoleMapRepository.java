package com.asi.huanan.service.repository;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.asi.huanan.service.connector.MyBatisConnector;
import com.asi.huanan.service.dao.mybatis.mapper.SysRoleMapMapper;
import com.asi.huanan.service.dao.mybatis.model.SysRoleMap;
import com.asi.huanan.service.dao.mybatis.model.SysRoleMapExample;
import com.asi.huanan.service.dao.mybatis.model.SysRoleMapExample.Criteria;


@Repository
public class SysRoleMapRepository {
	
	private Log log = LogFactory.getLog(SysAccountRepository.class);

	@Autowired
	private MyBatisConnector mybatis;

	
	//
	public List<SysRoleMap> queryBySysRoleMap(final SysRoleMap model, SqlSession sqlSession) throws Exception {
				
		List<SysRoleMap> returnList = null;
		
		try {
			
			SysRoleMapMapper mapper = sqlSession.getMapper(SysRoleMapMapper.class);
			
			SysRoleMapExample xp = new SysRoleMapExample();			
			Criteria criteria = xp.createCriteria();
			
			//
			if(StringUtils.isNotBlank(model.getFkUserId())) {
				criteria.andFkUserIdEqualTo(model.getFkUserId());
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

}
