package com.Mencef.bey.repository;



import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.document.Produit;




@Repository
public interface CategoryRepo  extends MongoRepository<Category, String>{
	List<Category> findByParantkey(String parantkey);
	Boolean existsByParantkey(String Parantkey);
	void deleteByParantkey(String Parantkey);
	
	

}
