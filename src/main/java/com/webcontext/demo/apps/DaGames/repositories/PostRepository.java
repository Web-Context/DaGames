/**
 * file: PostRepository.java
 * date: 5 févr. 2016
 *
 * GEHC DoseWatch
 *
 * Copyright (c) 2016 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 *
 */

package com.webcontext.demo.apps.DaGames.repositories;

import java.util.List;

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
	
	List<Post> findByPlatform( @Param("platform" ) String platform);
	
	
}
