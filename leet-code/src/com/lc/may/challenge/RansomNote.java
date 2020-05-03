package com.lc.may.challenge;

public class RansomNote {

	/*
	 * Given an arbitrary ransom note string and another string containing letters
	 * from all the magazines, write a function that will return true if the ransom
	 * note can be constructed from the magazines ; otherwise, it will return false.
	 * 
	 * Each letter in the magazine string can only be used once in your ransom note.
	 * 
	 * Note: You may assume that both strings contain only lowercase letters.
	 * 
	 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
	 * canConstruct("aa", "aab") -> true
	 */

	public static boolean canConstruct(String ransomNote, String magazine) {

		if (ransomNote.isEmpty()) {
			return true;
		}

		int magazineArr[] = new int[26];

		boolean canConstruct = false;

		for (int i = 0; i < magazine.length(); i++) {
			magazineArr[magazine.charAt(i) - 97]++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			if (magazineArr[ransomNote.charAt(i) - 97] != 0) {
				canConstruct = true;
				magazineArr[ransomNote.charAt(i) - 97]--;
			} else {
				canConstruct = false;
				break;
			}
		}
		return canConstruct;

	}

	public static void main(String[] args) {
		System.out.println(canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
	}

}
