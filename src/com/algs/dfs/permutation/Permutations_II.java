package com.algs.dfs.permutation;
import java.util.*;
/*
    47. Permutations II
    Medium

    2780

    77

    Add to List

    Share
    Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



    Example 1:

    Input: nums = [1,1,2]
    Output:
    [[1,1,2],
     [1,2,1],
     [2,1,1]]
    Example 2:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    Constraints:

    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
 */
public class Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if(nums == null) return results;

        if(nums.length == 0){
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);

        helper(nums, new ArrayList<>(), new int[nums.length], results);

        return results;
    }

    private void helper(int[] nums, List<Integer> permutation, int[] visited, List<List<Integer>> results){
        if(permutation.size() == nums.length){
            results.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1) continue;

            //去重
            if(i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;

            permutation.add(nums[i]);
            visited[i] = 1;

            helper(nums, permutation, visited, results);

            visited[i] = 0;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args){

    }
}
