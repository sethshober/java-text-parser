package parser;

public class Parser {
	
	public String removeLineEndings(String text) {
		return text.replaceAll("(\\r\\n|\\n|\\r|\\s\\s)", "");
	}
	
	public String removePunctuation(String text) {
		return text.replaceAll("\\p{Punct}", "");
	}
	
}
