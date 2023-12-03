package com.Mencef.bey.repository;



import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.Mencef.bey.document.Category;
import com.Mencef.bey.document.Message;
import com.Mencef.bey.document.Order;




@Repository
public interface MessageRepo  extends MongoRepository<Message, String>{
	List<Message> findByToid(String toid);
	Boolean existsByToid(String toid);
	 @Query("{$or:[{fromid: ?0, toid: ?1}, {toid: ?0, fromid: ?1}]}")
	    List<Message> findByFromidAndToidOrToidAndFromid(String fromid, String toid);
	List<Message> findByFromidOrToid(String fromid,String toid);
	Boolean existsByFromid(String fromid);

}
