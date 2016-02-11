package com.webcontext.demo.apps.DaGames.bootstrap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * Read and inject data set into corresponding repository.
 * 
 * @author Frédéric Delorme
 *
 */
@Component
public class DataSetReader<T, D> {
	private static Logger logger = Logger.getLogger(DataSetReader.class);

	@Autowired
	private MongoRepository<T, ?> repo;

	/**
	 * Import data to <code>clazz</code> entity collection from JSON file <code>filename</code>.
	 * 
	 * @param filename
	 *            JSON filename Data Set to insert into collection (or table).
	 * @param clazz
	 *            The Class object representing data for each occurrence in json file.
	 * @param emptyOnly
	 *            if true, data will be inserted only if targeted collection is empty.
	 */
	@SuppressWarnings("serial")
	public void importData( String filename, Class<T> clazz, boolean emptyOnly ) {

		if ((emptyOnly && repo.count() == 0) || (!emptyOnly)) {
			try {
				JsonReader reader = new JsonReader(new FileReader(this
						.getClass().getResource("/" + filename).toURI()
						.getPath()));
				List<T> list = new GsonBuilder()
						.setDateFormat("yyyy/MM/dd HH:mm:ss").create()
						.fromJson(reader, new TypeToken<List<T>>() {
						}.getType());
				for (T item : list) {
					repo.insert(item);
				}
			} catch (FileNotFoundException | URISyntaxException e) {
				logger.error("Unable to insert data to collection", e);
			}

		}
	}
}
