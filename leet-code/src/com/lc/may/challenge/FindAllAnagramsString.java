package com.lc.may.challenge;

import java.util.ArrayList;
import java.util.List;

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
