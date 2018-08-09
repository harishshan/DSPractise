package com.blogspot.harishshan.practise1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;
 
public class AnagramJava {
 
    static void printAnagrams(String word[])
    {
        int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };
        LinkedHashMap<Integer, Vector<String> > h = new LinkedHashMap<Integer, Vector<String>>();
        for (int i = 0; i < word.length; i++) {
            int s = 1;
            for (int j = 0; j < word[i].length(); j++) {
                s = s * (prime[word[i].charAt(j) - 'a']);
            }
            System.out.println(s);
            Vector<String> g = h.get(s);
            if (g == null) {
                g = new Vector<String>();
            }
            g.add(word[i]);
            h.put(s, g);
        }
        System.out.println("Anagrams are : ");
        for (Map.Entry<Integer, Vector<String> > e : h.entrySet()) {
            System.out.println(e.getValue());
        }
    }
    public static void main(String[] args){
    	System.out.println(('a'-'a'));
    	String word[] = { "eat", "pots", "onset", "stone", "rail", "risen", "caret", "resin", "react", "siren", "sitar", "stair", "liar", "stop", "trace", "notes", "tea", "lair" };
         printAnagrams(word);
    }
}