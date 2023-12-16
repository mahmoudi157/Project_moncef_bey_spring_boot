package com.Mencef.bey.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Mencef.bey.document.Produit;
import com.Mencef.bey.document.User;




@Repository
public interface ProduitRepo  extends MongoRepository<Produit, String>{
	List<Produit> findByParent(String parent);
	List<Produit> findByKeycate(String keycate);
	Boolean existsByParent(String parent);
	void deleteByParent(String parent);
	
	

}
