package com.asi.huanan.service;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.asi.huanan.service.dao.mybatis.model.SysRoleMap;
import com.asi.huanan.service.repository.SysRoleMapRepository;

@Service
public class SysRoleMapService {
	
	private Log log = LogFactory.getLog(SysAccountService.class);
	
	@Autowired
	private SysRoleMapRepository repository;
	
	//
	public List<SysRoleMap> queryBySysRoleMap(final SysRoleMap model, SqlSession sqlSession) throws Exception {
		return repository.queryBySysRoleMap(model, sqlSession);
	}
	
}
