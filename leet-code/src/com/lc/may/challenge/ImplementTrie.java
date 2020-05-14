package com.lc.may.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*Implement Trie (Prefix Tree)
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

class Node {
	Map<Character, Node> trieMap = new HashMap<Character, Node>();;
	boolean isCompleteWord;
}

class Trie {

	Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		/*
		 * Node current = root; for (int i = 0; i < word.length(); i++) { if
		 * (!current.trieMap.containsKey(word.charAt(i))) {
		 * current.trieMap.put(word.charAt(i), new Node()); } current =
		 * current.trieMap.get(word.charAt(i)); } current.isCompleteWord = true;
		 */
		recursive_insert(root, word, 0, word.length());
	}

	private void recursive_insert(Node current, String word, int start, int lenght) {
		if (start == lenght) {
			current.isCompleteWord = true;
		} else {
			if ((!current.trieMap.containsKey(word.charAt(start)))) {
				current.trieMap.put(word.charAt(start), new Node());
			}
			recursive_insert(current.trieMap.get(word.charAt(start)), word, ++start, lenght);
		}

	}

	public void print(Node r, String seperator) {
		for (Entry<Character, Node> node : r.trieMap.entrySet()) {
			System.out.print(seperator + node.getKey() + "(" + node.getValue().isCompleteWord + ")");
			print(node.getValue(), " -> ");
		}
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		/*
		 * Node current = root; for (int i = 0; i < word.length(); i++) { if (current ==
		 * null) { return false; } if (current.trieMap.containsKey(word.charAt(i))) {
		 * current = current.trieMap.get(word.charAt(i)); } else { return false; } }
		 * return current.isCompleteWord;
		 */
		return recursive_search(root, word, 0, word.length());
	}

	private boolean recursive_search(Node current, String word, int start, int lenght) {
		if (start == lenght) {
			return current.isCompleteWord;
		} else {
			if (current == null || !current.trieMap.containsKey(word.charAt(start))) {
				return false;
			}
			return recursive_search(current.trieMap.get(word.charAt(start)), word, ++start, lenght);
		}
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		if (root.trieMap.size() == 0) {
			return false;
		}
		/*
		 * Node current = root; for (int i = 0; i < prefix.length(); i++) { if (current
		 * == null) { return false; } if (current.trieMap.containsKey(prefix.charAt(i)))
		 * { current = current.trieMap.get(prefix.charAt(i)); } else { return false; } }
		 * return true;
		 */
		return recursice_starts(root, prefix, 0, prefix.length());
	}

	private boolean recursice_starts(Node current, String word, int start, int lenght) {
		if (start == lenght) {
			return true;
		} else {
			if (current == null || !current.trieMap.containsKey(word.charAt(start))) {
				return false;
			}
			return recursice_starts(current.trieMap.get(word.charAt(start)), word, ++start, lenght);
		}

	}
}

public class ImplementTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		trie.print(trie.root, "");
		System.out.println();
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.startsWith("app"));
		trie.insert("app");
		trie.print(trie.root, "");
		System.out.println();
		System.out.println(trie.search("app"));

	}

}
