package com.blogspot.harishshan.practise.problems;

import java.util.Arrays;
import java.util.Comparator;

public class Anagram {
	static String[] wordArray = {"abc", "dog", "pet", "cab", "god"};
	public static void main(String[] args) {
		printAnagramsTogether(wordArray);
	}
	public static void printAnagramsTogether(String[] wordArray) {
		DuplicateArray duplicateArray = new DuplicateArray(wordArray, wordArray.length);
		for(int i=0; i<wordArray.length; i++) {
			char[] chararray = duplicateArray.array[i].str.toCharArray();
			Arrays.sort(chararray);
			duplicateArray.array[i].str  = new String(chararray);
		}
		Arrays.sort(duplicateArray.array, new CompStr());
		for(int i=0; i<wordArray.length; i++) {
			System.out.println(wordArray[duplicateArray.array[i].index]+" ");
		}
	}
	static class CompStr implements Comparator<Word>{
		public int compare(Word a, Word b) {
			return a.str.compareTo(b.str);
		}
	}
}
class Word{
	String str;
	int index;
	public Word(String _str, int _index) {
		this.str = _str;
		this.index = _index;
	}
}
class DuplicateArray{
	Word[] array;
	int size;
	public DuplicateArray(String str[], int _size) {
		this.size = _size;
		array = new Word[this.size];
		for(int i=0; i<size; i++) {
			array[i] = new Word(str[i], i);
		}
	}
}
