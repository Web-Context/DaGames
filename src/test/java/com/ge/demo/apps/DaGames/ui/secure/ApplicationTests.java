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

package com.ge.demo.apps.DaGames.ui.secure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.webcontext.demo.apps.DaGames.Application;

/**
 * Integration Test for Application main front end.
 * 
 * @author Frédéric Delorme.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@DirtiesContext
public class ApplicationTests {

	@Value("${local.server.port}")
	private int port;

	@Test
	public void testHome() throws Exception {
/*		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		ResponseEntity<String> entity = new TestRestTemplate().exchange("http://localhost:" + this.port, HttpMethod.GET,
				new HttpEntity<Void>(headers), String.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertTrue("Wrong body (title doesn't match):\n" + entity.getBody(), entity.getBody().contains("<title>Login"));*/
	}

}
