package com.algs.dfs.combination;
import java.util.*;
/*
    40. Combination Sum II
    Medium

    2516

    86

    Add to List

    Share
    Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

    Each number in candidates may only be used once in the combination.

    Note: The solution set must not contain duplicate combinations.



    Example 1:

    Input: candidates = [10,1,2,7,6,1,5], target = 8
    Output:
    [
    [1,1,6],
    [1,2,5],
    [1,7],
    [2,6]
    ]
    Example 2:

    Input: candidates = [2,5,2,1,2], target = 5
    Output:
    [
    [1,2,2],
    [5]
    ]


    Constraints:

    1 <= candidates.length <= 100
    1 <= candidates[i] <= 50
    1 <= target <= 30
 */
public class Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0, results);
        return results;
    }


    private void helper(int[] nums, int target, ArrayList<Integer> subset, int startIndex, List<List<Integer>> results){
        if(target == 0){
            results.add(new ArrayList<>(subset));
            return;
        };

        for(int i = startIndex; i < nums.length; i++){
            //optimize
            if(target < nums[i]) break;

            // 去重
            if(i != startIndex && nums[i] == nums[i-1]) continue;

            subset.add(nums[i]);

            helper(nums, target - nums[i], subset, i + 1, results);

            subset.remove(subset.size() - 1);
        }
    }
}
