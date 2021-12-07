package com.asi.huanan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asi.huanan.model.Imagemanage;
import com.asi.huanan.repository.ImagemanageRepository;
import com.asi.huanan.repository.LocationmanageRepository;
import com.asi.huanan.repository.RegionuserRepository;
import com.asi.huanan.repository.UsermanageRepository;

@Service
public class ImagemanageService {

	@Autowired
	private ImagemanageRepository imagemanageRepository;

	/**
	 * @return
	 * 
	 */
 
	
	public List<Imagemanage> findByfileusesystemOrderByCreatedateDesc(String fileusesystem) {
		List<Imagemanage> imagenmanageList = imagemanageRepository.findByfileusesystemOrderByCreatedateDesc(fileusesystem);
		return imagenmanageList;
	} 
}
