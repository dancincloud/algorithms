package com.algs.dfs.combination;

import java.util.*;

/*
    131. Palindrome Partitioning
    Medium

    3077

    98

    Add to List

    Share
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

    A palindrome string is a string that reads the same backward as forward.



    Example 1:

    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
    Example 2:

    Input: s = "a"
    Output: [["a"]]


    Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters
 */

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {

        getIsPalindrome(s);

        List<List<String>> results = new ArrayList<>();

        helper(s, new ArrayList<>(), 0, results);

        return results;
    }


    private void helper(String s, List<String> partitions, int startIndex, List<List<String>> results){
        if(startIndex >= s.length()){
            results.add(new ArrayList<>(partitions));
            return;
        }

        for(int i = startIndex; i < s.length(); i++){

//            if(!isValidPalindrome(subStr)) continue;

            // node: i or i + 1
            if(!isPalindrome[startIndex][i]) continue;;

            String subStr = s.substring(startIndex, i + 1);
            partitions.add(subStr);
            helper(s, partitions, i + 1, results);
            partitions.remove(partitions.size() - 1);
        }
    }

//    O(n^2)
    private boolean isValidPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

//    通过该方法，可优化 回文串判断
    private boolean[][] isPalindrome;
    private void getIsPalindrome(String s){
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for(int i = 0; i < n; i++){
            isPalindrome[i][i] = true;
        }

        for(int i = 0; i < n - 1; i++){
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for(int i = n - 3; i >= 0; i--){
            for(int j = i + 2; j  < n; j++){
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
    }
}
