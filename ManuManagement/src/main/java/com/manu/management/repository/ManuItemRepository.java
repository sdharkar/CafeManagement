package com.manu.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manu.management.model.ManuItem;

@Repository
public interface ManuItemRepository extends MongoRepository<ManuItem, String>{

}
