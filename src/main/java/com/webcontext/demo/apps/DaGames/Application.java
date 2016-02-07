/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webcontext.demo.apps.DaGames;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.webcontext.demo.apps.DaGames.model.Post;
import com.webcontext.demo.apps.DaGames.repositories.IDataSetReader;

/**
 * Bootstrapping the DaGames blog demo application.
 * 
 * @author Frédéric Delorme
 *
 */
@SpringBootApplication
public class Application {
	/**
	 * Start Application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		outputBean(ctx);
		IDataSetReader<Post> dataset = new IDataSetReader<Post>();
		dataset.importData("", "games.json", Post.class);
	}

	/**
	 * @param ctx
	 */
	private static void outputBean(ApplicationContext ctx) {
		System.out.println("Let's inspect the beans provided by Spring Boot:");

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}

}