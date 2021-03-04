package com.algs.graph;

import java.util.LinkedList;
import java.util.Queue;

public class As_Far_from_Land_as_Possible {
    public int maxDistance(int[][] grid) {
        if(grid == null) return 0;

        Queue<Coordinate> q = new LinkedList<>();

        int n = grid.length;
//        note: < n
        for(int y = 0; y < n;y++){
            for(int x = 0; x < n; x++){
                if(grid[y][x] == 1) q.offer(new Coordinate(x,y));
            }
        }

        if(q.size() == n * n) return -1;

        int[] dx = new int[]{0,1,-1,0};
        int[] dy = new int[]{1,0,0,-1};

        int distance = 0;
        while(!q.isEmpty()){

            System.out.println(distance);

            int sz = q.size();
            for(int i = 0; i < sz; i++){
                Coordinate c = q.poll();

                for(int d = 0; d < dx.length; d++){
                    Coordinate neighbor = new Coordinate(c.x + dx[d], c.y + dy[d]);
                    if(isBound(neighbor, grid) && grid[neighbor.y][neighbor.x] == 0){
                        grid[neighbor.y][neighbor.x] = 1;
                        q.offer(neighbor);
                        System.out.println(neighbor.x + ", " + neighbor.y);
                    }
                }
            }

            if(!q.isEmpty()) distance++;
        }

        return distance;
    }

    private boolean isBound(Coordinate c, int[][] grid){
        if(c.x < 0 || c.x > grid.length - 1) return false;
        if(c.y < 0 || c.y > grid.length - 1) return false;
        return true;
    }

    public static void main(String[] args){
        As_Far_from_Land_as_Possible solution = new As_Far_from_Land_as_Possible();
        System.out.println(solution.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
