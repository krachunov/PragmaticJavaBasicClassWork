

import java.util.*;

public class Dictionary {
	private Map<String, WordEntity> words;
	
	public Dictionary() {
		words = new HashMap<String, WordEntity>();
	}
	/**
	 * Add Entity
	 * @param entity
	 */
	public void addEntity(WordEntity entity) {
		words.put(entity.getWord(), entity);
	}
	
	/**
	 * Search WordEntity that matches the given word 
	 * @param word
	 * @return WordEntity if is found. Otherwise null
	 */
	public WordEntity searchWord(String word) {
		return words.get(word);
	}
	
	public int getWordsCount() {
		return words.size();
	}
}
