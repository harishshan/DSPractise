package com.blogspot.harishshan.practise.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Anagram1 {
	static String[] array = {"abc", "dog", "pet", "cab", "god"};
	public static void main(String[] args) {
		printAnagramsTogether(array);
	}
	public static void printAnagramsTogether(String[] array) {
		Word[] wordArray = new Word[array.length];
		for(int i=0;i<array.length;i++) {
			wordArray[i] = new Word(array[i], i);
		}
		for(int i=0; i<wordArray.length; i++) {
			char[] chararray = wordArray[i].str.toCharArray();
			Arrays.sort(chararray);
			wordArray[i].str  = new String(chararray);
		}
		Arrays.sort(wordArray, new CompStr());
		for(int i=0; i<wordArray.length; i++) {
			int  indexOfWordObj = wordArray[i].index;
			System.out.println(array[indexOfWordObj]);
		}
	}
	static class CompStr implements Comparator<Word>{
		public int compare(Word a, Word b) {
			return a.str.compareTo(b.str);
		}
	}
	static class Word{
		String str;
		int index;
		public Word(String _str, int _index) {
			this.str = _str;
			this.index = _index;
		}
	}
}