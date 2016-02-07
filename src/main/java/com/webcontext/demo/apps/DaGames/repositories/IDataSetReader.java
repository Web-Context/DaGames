/**
 * 
 */
package com.webcontext.demo.apps.DaGames.repositories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.common.reflect.TypeToken;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

/**
 * @author Frédéric Delorme
 *
 */
public class IDataSetReader<T> {

	/**
	 * 
	 * @param collection
	 * @param filename
	 * @param clazz
	 */
	@SuppressWarnings("serial")
	public void importData(String collection, String filename, Class<T> clazz) {

		try {
			JsonReader reader = new JsonReader(new FileReader(filename));
			List<T> list = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create().fromJson(reader,
					new TypeToken<List<T>>() {
					}.getType());
			for (T item : list) {
				System.out.println("data:" + item.toString());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
