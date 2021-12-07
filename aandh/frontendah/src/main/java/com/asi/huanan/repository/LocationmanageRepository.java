package com.asi.huanan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asi.huanan.model.Locationmanage;

/**
 * annotation-Repository可以不加
 * 
 * 自訂method使用get+變數(駝峰式命名)，此可參考spring-data官方網站說明
 * 
 * @author leo_lee
 *
 */
@Repository
public interface LocationmanageRepository extends MongoRepository<Locationmanage, String> {

	//List<Usermanage> findByuseraccount(String useraccount);
	
	List<Locationmanage>findAll();
	
	List<Locationmanage>findByregionID(String regionID);
	
	List<Locationmanage>findByregionIDAndType(String regionID,String type);
}