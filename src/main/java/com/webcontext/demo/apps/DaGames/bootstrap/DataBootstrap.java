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
public class DataBootstrap {
	@Autowired
	DataSetReader<Post, Long> dataset;

	@PostConstruct
	public void inject() {

		dataset.importData("datasets/post-games.json", Post.class, true);
	}
}
