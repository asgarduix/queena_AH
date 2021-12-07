package com.asi.huanan.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.asi.huanan.model.Regionuser;

@Repository
public interface RegionuserRepository extends MongoRepository<Regionuser, String> {

	List<Regionuser> findAll();

	List<Regionuser> findByuserAccount(String useraccount);

	<S extends Regionuser> S save(S entity);

	void deleteById(Long userId);

	void deleteByUserAccount(String userAccount);
}