import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WordTransformation {

	public static void main(String[] args) {
//		beginWord = "hit", kht
//				endWord = "cog",
//				wordList = ["hot","dot","dog","lot","log","cog"].
				
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		String beginWord = "hit";
		String endWord = "cog";
		
		transform(wordList, beginWord, endWord);

	}

	private static void transform(List<String> wordList, String beginWord, String endWord) {
		Set<String> sortedWordList = new TreeSet<String>(wordList);
//		sortedWordList.forEach(System.out::println);
		// loop through sortedWordList
		// for each word in SWL find a word which is transformation of the begin word
		// such that only word is the difference.
		if(!wordList.contains(endWord))
			return;
		List<String> transformedList = new ArrayList<String>();
		transformedList.add(beginWord);
		int shortestTransformlength = 0;
		
		Iterator iterator = sortedWordList.iterator();
		
		while(true) {
			String string = (String) iterator.next();
			if(isTransform(string, beginWord)) {
				transformedList.add(string);
				shortestTransformlength++;
				beginWord = string;
				sortedWordList.remove(string);
				iterator = sortedWordList.iterator();
				if(string.equals(endWord))
					break;
			}
			
		}
		
		transformedList.forEach(word -> System.out.print(word + "->"));
		
	}
	

	private static boolean isTransform(String string, String beginWord) {
		int count = 0;
		for (int i = 0; i < 3; i++) {
			if(string.indexOf(beginWord.charAt(i)) == -1) {
				count++;
			}
		}
		
		return count <= 1;
		
	}
	
}
