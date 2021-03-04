package com.algs.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tools {

    static final String NUll = "null";

    public static TreeNode arrayToTree(String[] arr){
//        final String NUll = "null";

        if(arr == null || arr.length == 0) return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int index = 1;
        while (!q.isEmpty() && index < arr.length){
            int sz = q.size();

            for(int i = 0; i < sz; i++){
                TreeNode node = q.poll();

                if(arr[index].equals(NUll)){
                    node.left = null;
                }else{
                    node.left = new TreeNode(Integer.parseInt(arr[index]));
                    q.offer(node.left);
                }

                index++;
                if(index >= arr.length) break;


                if(arr[index].equals(NUll)){
                    node.right = null;
                }else{
                    node.right = new TreeNode(Integer.parseInt(arr[index]));
                    q.offer(node.right);
                }

                index++;
                if(index >= arr.length) break;
            }
        }

        return root;
    };


    public static String[] treeToArray(TreeNode root){
        List<String> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        Boolean existNextLevel = false;
        while (!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                TreeNode node = q.poll();
                if(node == null){
                    list.add(NUll);
                }else{
                    list.add("" + node.val);
                    q.offer(node.left);
                    q.offer(node.right);
                    if(node.left != null || node.right != null) existNextLevel = true;
                }
            }

            if(existNextLevel){
                existNextLevel = false;
            }else{
                break;
            }
        }

        String[] data = new String[list.size()];
        return list.toArray(data);
    }

    public static void main(String[] args){
        String[] data = new String[]{"1","-5","11","1","2","4","-2"};
        TreeNode root = Tools.arrayToTree(data);

        String[] output = Tools.treeToArray(root);

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
