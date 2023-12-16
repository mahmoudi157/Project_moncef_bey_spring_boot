package com.Mencef.bey.repository;



import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.document.Order;




@Repository
public interface OrderRepo  extends MongoRepository<Order, String>{
	List<Order> findByToid(String toid);
	Boolean existsByToid(String toid);
	List<Order> findByFromid(String fromid);
	Boolean existsByFromid(String fromid);
	
	
	

}
