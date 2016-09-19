package parser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseText {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		long start = System.currentTimeMillis();
		
		// here lives the complete works of Shakesepeare
		URL url = new URL("http://www.gutenberg.org/cache/epub/100/pg100.txt");
		
		InputStream stream = url.openStream();
		Scanner scanner = new Scanner(stream);
		// upper- and lowercase letters form words
        // everything else is the delimiter between words
        scanner.useDelimiter("[^a-zA-Z]+");
        final Map<String, Integer> wordCounts = new HashMap<String, Integer>();
		while (scanner.hasNext()) {
			// convert to lower case to avoid double counting
			String word = scanner.next().toLowerCase();
			if (!wordCounts.containsKey(word)) {
				wordCounts.put(word, 1);
			} else {
				wordCounts.put(word, wordCounts.get(word) + 1);
			}
		}
		scanner.close();
		
		// get distinct words
		String[] words = wordCounts.keySet().toArray(new String[0]);
		
		// sort number of occurrence
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				// negative to sort descending
				return -Integer.compare(wordCounts.get(a), wordCounts.get(b));
			}
		});
		
		// display most common words
		int n = 50;
		System.out.println("Top " + n + " words occurrences.");
		for (int i = 0; i < n; i ++) {
			System.out.println(words[i] + " : " + wordCounts.get(words[i]));
		}
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("Program took: " + duration + "ms");
		
//		Parser parser = new Parser();
//		
//		String str = "hello..#$'() \nhello  everyone";
//		//str = str.replaceAll("\\p{Punct}", "");
//		//str = str.replaceAll("(\\r\\n|\\n|\\r|\\s\\s)", "");
//		str = parser.removeLineEndings(str);
//		str = parser.removePunctuation(str);
//		System.out.println(str);
	}

}
