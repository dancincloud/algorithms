package com.algs.dfs.combination;

import java.util.*;
/*
    78. Subsets
    Medium

    5340

    109

    Add to List

    Share
    Given an integer array nums of unique elements, return all possible subsets (the power set).

    The solution set must not contain duplicate subsets. Return the solution in any order.



    Example 1:

    Input: nums = [1,2,3]
    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    Example 2:

    Input: nums = [0]
    Output: [[],[0]]


    Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
     */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if(nums == null) return results;

        Arrays.sort(nums);

        helper(new ArrayList<>(), nums, 0, results);

        return results;
    }

    /*  递归三要素
        1.递归的定义：在Nums中找到所有sublet开头的集合，并放到results中
    */
    private void helper(ArrayList<Integer> subset, int[] nums, int startIndex, List<List<Integer>> results){

        /*
        2. 递归的拆解
        deep copy
        results.add(subset)
        */
        results.add(new ArrayList<>(subset));

        for(int i = startIndex; i < nums.length; i++){
            subset.add(nums[i]);
            helper(subset, nums, i + 1, results);

            subset.remove(subset.size() - 1);
        }
    }
}
