/**
 * file: PostInjector.java
 * date: 8 févr. 2016
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

package com.webcontext.demo.apps.DaGames.bootstrap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webcontext.demo.apps.DaGames.model.Post;

/**
 * Auto inject data to Post collection
 * 
 * @author Frédéric Delorme
 *
 */
@Component
public class PostInjector {
	@Autowired
	DataSetReader<Post, Long> dataset;

	@PostConstruct
	public void inject() {

		dataset.importData("datasets/games.json", Post.class, true);
	}
}
