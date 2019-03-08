package exercise_text_analyser;


import assignmenthandler.assignments.sem2vop.l3p.Main;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class TextAnalyzer {

	private String fileName;

	public TextAnalyzer(String fileName) {
		this.fileName = fileName;
	}

	// Opgave 2A     
	// Parameteren sorted afgør om der skal benyttes et sorteret Set
	//
	public Set<String> findUniqueWords(boolean sorted) {
		final Set<String> set = sorted ? new TreeSet<>() : new HashSet<>();
		new Scanner(Main.class.getResourceAsStream(fileName)).useDelimiter("\\W").forEachRemaining(line -> set.add(clean(line)));
                set.remove("");
		return set;
	}

	// Opgave 2B:   Nearly as Listing 21.9 from Liang
	//
	public Map<String, Integer> countWords(boolean sorted) {
		final Map<String, Integer> map = sorted ? new TreeMap<>() : new HashMap<>();
                new Scanner(Main.class.getResourceAsStream(fileName)).useDelimiter("\\W").forEachRemaining(word -> map.put(clean(word), (map.putIfAbsent(clean(word), 0) == null ? 0 : map.putIfAbsent(clean(word), 0)) + 1));
                map.remove("");
		return map;
	}

	// Opgave 2C:     Udvidelse af P15.1
	//
	public Map<Integer, Set<String>> lengtOfWords(boolean sorted) {
		final Map<Integer, Set<String>> mapOfSets = sorted ? new TreeMap<>() : new HashMap<>();		
                new Scanner(Main.class.getResourceAsStream(fileName)).useDelimiter("\\W").forEachRemaining(line -> System.out.print(mapOfSets.putIfAbsent(clean(line).length(), new TreeSet<>(Arrays.asList(clean(line)))) == null ? "" : mapOfSets.get(clean(line).length()).add(clean(line)) ? "" : ""));
		mapOfSets.remove(0);
                return mapOfSets;

	}

	// Denne metode forsøger at fjerne alt 'snavs' fra en String,
	// så kun bogstaver bevares og store gøres til små
	private String clean(String s) {
		String r = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				r = r + c;
			}
		}
		return r.toLowerCase();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TextAnalyzer ta = new TextAnalyzer("alice30.txt");

		// Opgave 2A. Find alle unikke ord i filen
		Set<String> set = ta.findUniqueWords(true);
		System.out.println(set);
		System.out.println("Number of unique words: " + set.size());

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2B. Tæl forekomster af ord
		Map<String, Integer> map = ta.countWords(true);
		System.out.println(map);

		System.out.println("\n------------------------------------------------------------------\n");

		// Opgave 2C. Benyt en mappe til at gruppere ord efter længde
		Map<Integer, Set<String>> map2 = ta.lengtOfWords(true);
		System.out.println(map2);

	}

}
