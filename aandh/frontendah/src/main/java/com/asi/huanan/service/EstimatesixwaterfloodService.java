package com.asi.huanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asi.huanan.model.Estimatesixwaterflood;
import com.asi.huanan.repository.EstimatesixwaterfloodRepository;
import com.asi.huanan.repository.LocationmanageRepository;
import com.asi.huanan.repository.RegionuserRepository;
import com.asi.huanan.repository.UsermanageRepository;

@Service
public class EstimatesixwaterfloodService {

	@Autowired
	private EstimatesixwaterfloodRepository estimatesixwaterfloodRepository;

	/**
	 * @return
	 * 
	 */
	public List<Estimatesixwaterflood> findAll() {
		List<Estimatesixwaterflood> estimatesixwaterfloodList = estimatesixwaterfloodRepository.findAll();
		return estimatesixwaterfloodList;
	} 
	
	public List<Estimatesixwaterflood> findbyregionID(String regionID) {
		List<Estimatesixwaterflood> estimatesixwaterfloodList = estimatesixwaterfloodRepository.findByregionidOrderByCreatedateDesc(regionID);
		return estimatesixwaterfloodList;
	} 
	
	public List<Estimatesixwaterflood> findbyregionIDAndUptime(String regionID,String uptime) {
		List<Estimatesixwaterflood> estimatesixwaterfloodList = estimatesixwaterfloodRepository.findByregionidAndUptime(regionID,uptime);
		return estimatesixwaterfloodList;
	} 
	
}
