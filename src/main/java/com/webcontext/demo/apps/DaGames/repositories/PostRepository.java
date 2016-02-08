package com.webcontext.demo.apps.DaGames.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.webcontext.demo.apps.DaGames.model.Post;

/**
 * Post entity MongoDB repository.
 * 
 * @author Frédéric Delorme
 *
 */
@RepositoryRestResource(collectionResourceRel = "post", path = "post")
public interface PostRepository extends MongoRepository<Post, Long> {

	/**
	 * Retrieve all Post on title filtering.
	 * 
	 * @param title
	 * @return
	 */
	List<Post> findByTitle( @Param("title" ) String title);
	
	List<Post> findByMetadata( @Param("metadata" ) Map<String, String> metadata);
	
	
}
