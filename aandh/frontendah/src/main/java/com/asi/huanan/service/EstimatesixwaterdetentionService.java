package com.asi.huanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asi.huanan.model.Estimatesixwaterdetention;
import com.asi.huanan.repository.EstimatesixwaterdetentionRepository;
import com.asi.huanan.repository.EstimatesixwaterfloodRepository;
import com.asi.huanan.repository.LocationmanageRepository;
import com.asi.huanan.repository.RegionuserRepository;
import com.asi.huanan.repository.UsermanageRepository;

@Service
public class EstimatesixwaterdetentionService {

	@Autowired
	private EstimatesixwaterdetentionRepository estimatesixwaterdetentionRepository;

	/**
	 * @return
	 * 
	 */
	public List<Estimatesixwaterdetention> findAll() {
		List<Estimatesixwaterdetention> estimatesixwaterdetentionList = estimatesixwaterdetentionRepository.findAll();
		return estimatesixwaterdetentionList;
	}

	public List<Estimatesixwaterdetention> findbyregionID(String regionID) {
		List<Estimatesixwaterdetention> estimatesixwaterdetentionList = estimatesixwaterdetentionRepository
				.findByregionid(regionID);
		return estimatesixwaterdetentionList;
	}

	public List<Estimatesixwaterdetention> findbyregionIDANDlocalname(String regionID, String localname) {
		List<Estimatesixwaterdetention> estimatesixwaterdetentionList = estimatesixwaterdetentionRepository
				.findByregionidAndLocalnameOrderByCreatedateDesc(regionID, localname);
		return estimatesixwaterdetentionList;
	}

}
