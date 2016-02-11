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
public interface PostRepository extends MongoRepository<Post, String> {

	/**
	 * Retrieve all Post on title filtering.
	 * 
	 * @param title
	 * @return
	 */
	List<Post> findByTitleLike( @Param("title") String title );

	/**
	 * Retrieve all post base on type value.
	 * 
	 * @param type
	 * @return
	 */
	List<Post> findByType( @Param("type") String type );

	/**
	 * Retrieve all post base on type value and title.
	 * 
	 * @param type
	 * @return
	 */
	List<Post> findByTypeAndTitleLike( @Param("type") String type,
			@Param("title") String title );

	/**
	 * Retrieve data on meta key
	 * 
	 * @param metadata
	 * @return
	 */
	List<Post> findByMetadata( @Param("metadata") Map<String, String> metadata );

}
