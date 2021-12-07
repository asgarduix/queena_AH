package com.asi.huanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asi.huanan.model.Locationmanage;
import com.asi.huanan.repository.LocationmanageRepository;
import com.asi.huanan.repository.RegionuserRepository;
import com.asi.huanan.repository.UsermanageRepository;

@Service
public class LocationmanageService {

	@Autowired
	private LocationmanageRepository localmanageRepository;

	/**
	 * @return
	 * 
	 */
	public List<Locationmanage> findAll() {
		List<Locationmanage> localmanageList = localmanageRepository.findAll();
		return localmanageList;
	} 
	
	public List<Locationmanage> findbyregionID(String regionID) {
		List<Locationmanage> localmanageList = localmanageRepository.findByregionID(regionID);
		return localmanageList;
	} 
	
	public List<Locationmanage> findbyregionIDAndType(String regionID,String type) {
		List<Locationmanage> localmanageList = localmanageRepository.findByregionIDAndType(regionID,type);
		return localmanageList;
	} 
}
