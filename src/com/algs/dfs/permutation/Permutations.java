package com.algs.dfs.permutation;
import java.util.*;
/*
    46. Permutations
    Medium

    5517

    128

    Add to List

    Share
    Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    Example 2:

    Input: nums = [0,1]
    Output: [[0,1],[1,0]]
    Example 3:

    Input: nums = [1]
    Output: [[1]]


    Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null) return results;

        if(nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }

        helper(nums, new ArrayList<>(), new HashSet<>(), results);

        return results;
    }


    private void helper(int[] nums, List<Integer> permutation, Set<Integer> set, List<List<Integer>> results){
        if(permutation.size() == nums.length){
            results.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // remove duplicate
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            permutation.add(nums[i]);

            helper(nums, permutation, set, results);

            //backtrack
            permutation.remove(permutation.size() - 1);
            set.remove(nums[i]);
        }
    }
}
