package com.algs.tree;

// sub tree with maximum average
public class SubTreeWithMaximumAverage {

    private class ResultType{
        int sum;
        int size;

        public ResultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }

    private TreeNode subTree;
    private ResultType subTreeResult;

    public TreeNode findSubTree(TreeNode root){
        helper(root);
        return subTree;
    }

    private ResultType helper(TreeNode root){
        if(root == null) return new ResultType(0,0);

        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);

        ResultType rootRes = new ResultType(root.val + leftRes.sum + rightRes.sum, 1 +leftRes.size + rightRes.size);
        if(subTreeResult == null || subTreeResult.sum * rootRes.size < rootRes.sum * subTreeResult.size){
            subTreeResult = rootRes;
            subTree = root;
        }

        return rootRes;
    }


    public static void main(String[] args){
        SubTreeWithMaximumAverage solution = new SubTreeWithMaximumAverage();

        String[] data = new String[]{"1","-5","11","1","2","4","-2"};
        TreeNode root = Tools.arrayToTree(data);

        TreeNode res = solution.findSubTree(root);

        String[] output = Tools.treeToArray(res);

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(String s : output) {
            sb.append(s).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");

        System.out.println(sb.toString());
    }
}
