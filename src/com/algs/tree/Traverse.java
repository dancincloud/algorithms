package com.algs.tree;

import java.util.*;

public class Traverse {
    /* preorder - Iterator */
    public List<Integer> preorderIterator(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return list;
    }

    /* preorder - Recursion */
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderHelper(root, list);
        return list;
    }

    private void preorderHelper(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);

        preorderHelper(root.left, list);
        preorderHelper(root.right, list);
    }

    /* inorder - Iterator */
    public List<Integer> inorderIterator(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }

    /* inorder - Recursion */
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderHelper(root, list);
        return list;
    }

    private void inorderHelper(TreeNode root, List<Integer> list){
        if(root == null) return;

        preorderHelper(root.left, list);
        list.add(root.val);
        preorderHelper(root.right, list);
    }

    /* postorder - Iterator */
    public List<Integer> postorderIterator(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(0, node.val);

            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        return list;
    }

    /* postorder - Recursion */
    public List<Integer> postorderRecursion(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(TreeNode root, List<Integer> list){
        if(root == null) return;

        postorderHelper(root.left, list);
        postorderHelper(root.right, list);
        list.add(root.val);
    }
}
