package com.asi.huanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asi.huanan.model.Regionuser;
import com.asi.huanan.model.Usermanage;
import com.asi.huanan.repository.RegionuserRepository;
import com.asi.huanan.repository.UsermanageRepository;

@Service
public class UsermanageService {

	@Autowired
	private UsermanageRepository usermanageRepository;
	@Autowired
	private RegionuserRepository regionuserRepository;

	/**
	 * @return
	 * 
	 */
	public List<Usermanage> findAll() {
		List<Usermanage> usermanageList = usermanageRepository.findAll();
		return usermanageList;
	}

	public List<Regionuser> findAllregionuser() throws UsernameNotFoundException {
		List<Regionuser> regionuserList = this.regionuserRepository.findAll();

		return regionuserList;
	}

	public List<Regionuser> findRegionuserByuserAccount(String useraccount) throws UsernameNotFoundException {
		List<Regionuser> regionuserList = this.regionuserRepository.findByuserAccount(useraccount);
		
		return regionuserList;
	}

	/**
	 * @return
	 * 
	 */
	public List<Usermanage> findByuseraccount(String useraccount) {
		List<Usermanage> usermanageList = usermanageRepository.findByuseraccount(useraccount);
		return usermanageList;
	}

}
