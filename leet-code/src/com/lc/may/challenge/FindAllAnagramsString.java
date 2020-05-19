package com.lc.may.challenge;

import java.util.ArrayList;
import java.util.List;

/*Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/

public class FindAllAnagramsString {

	// s: "ecbaebabacd" p: "abc"
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int map[] = new int[26];
		for (int i = 0; i < p.length(); i++) {
			map[p.charAt(i) - 'a']++;
		}
		int windowStart = 0;
		int windowEnd = 0;
		while (windowEnd < s.length()) {
			if (map[s.charAt(windowEnd) - 'a'] > 0) {
				map[s.charAt(windowEnd) - 'a']--;
				windowEnd++;
				if ((windowEnd - windowStart) == p.length()) {
					result.add(windowStart);
				}
			} else if (windowEnd == windowStart) {
				windowEnd++;
				windowStart++;
			} else {
				map[s.charAt(windowStart) - 'a']++;
				windowStart++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}

}
