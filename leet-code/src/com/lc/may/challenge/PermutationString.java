package com.lc.may.challenge;

/*Permutation in String
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

 

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
 

Note:

The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].*/

public class PermutationString {

	public static boolean checkInclusion(String s1, String s2) {
		int map[] = new int[26];
		for (char c : s1.toCharArray()) {
			map[c - 'a']++;
		}
		int windowStart = 0;
		int windowEnd = 0;
		while (windowEnd < s2.length()) {
			if (map[s2.charAt(windowEnd) - 'a'] > 0) {
				map[s2.charAt(windowEnd++) - 'a']--;
				if ((windowEnd - windowStart) == s1.length()) {
					return true;
				}
			} else if (windowEnd == windowStart) {
				windowEnd++;
				windowStart++;
			} else {
				map[s2.charAt(windowStart++) - 'a']++;
			}
		}
		return false;
	}

	public static boolean checkInclusion2(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int map[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			map[s1.charAt(i) - 'a']--;
			map[s2.charAt(i) - 'a']++;
		}
		for (int i = s1.length(); i < s2.length(); i++) {
			if (checkAllZero(map)) {
				return true;
			}
			map[s2.charAt(i) - 'a']++;
			map[s2.charAt(i - s1.length()) - 'a']--;
		}
		if (checkAllZero(map)) {
			return true;
		}

		return false;
	}

	private static boolean checkAllZero(int[] map) {
		for (int i = 0; i < map.length; i++) {
			if (map[i] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion2("ab", "eidbaooo"));
	}

}
