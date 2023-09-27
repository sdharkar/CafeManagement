package com.cafe.management.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cafe.management.model.Menu;

@Repository
public interface MenuRepo extends MongoRepository<Menu, String>{

	Menu findByMenuName(String menuName);

	List<Menu> findByUsername(String username);

}
