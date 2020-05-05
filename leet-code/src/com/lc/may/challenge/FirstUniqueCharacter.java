package com.lc.may.challenge;

/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/
public class FirstUniqueCharacter {

	public static int firstUniqChar2(String s) {
		int res = Integer.MAX_VALUE;

		for (char c = 'a'; c <= 'z'; c++) {
			int index = s.indexOf(c);

			if (index != -1 && index == s.lastIndexOf(c))
				res = Math.min(res, index);
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public static int firstUniqChar(String s) {
		int arr[] = new int[26];
		for (char c : s.toCharArray()) {
			arr[c - 97]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (arr[s.charAt(i) - 97] == 1) {
				return i;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));

		System.out.println(firstUniqChar2("loveleetcode"));
	}

}
