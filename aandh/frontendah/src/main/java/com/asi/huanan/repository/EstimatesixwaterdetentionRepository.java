package com.asi.huanan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asi.huanan.model.Estimatesixwaterdetention;

/**
 * annotation-Repository可以不加
 * 
 * 自訂method使用get+變數(駝峰式命名)，此可參考spring-data官方網站說明
 * 
 * @author leo_lee
 *
 */
@Repository
public interface EstimatesixwaterdetentionRepository extends MongoRepository<Estimatesixwaterdetention, String> {

	// List<Usermanage> findByuseraccount(String useraccount);

	List<Estimatesixwaterdetention> findAll();

	List<Estimatesixwaterdetention> findByregionid(String regionID);

	List<Estimatesixwaterdetention> findByregionidAndLocalname(String regionID, String localname);

	List<Estimatesixwaterdetention> findByregionidAndLocalnameOrderByCreatedateDesc(String regionID, String localname);
	
}