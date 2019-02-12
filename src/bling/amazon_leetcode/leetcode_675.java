package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.*;

public class leetcode_675 {
    class Tree{
        int x;
        int y;
        int h;
        Tree(int x,int y,int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(List.of(1,2,3));
        forest.add(List.of(0,0,4));
        forest.add(List.of(7,6,5));
        leetcode_675 sol = new leetcode_675();
        int answer = sol.cutOffTree(forest);
        util.println(answer);
    }

    public int cutOffTree(List<List<Integer>> forest) {
        ArrayList<Tree> trees = new ArrayList<>();

        // edge case
        int m = forest.size();
        if(m == 0)
            return 0;
        int n = forest.get(0).size();
        if(n == 0)
            return 0;

        // collect all trees
        boolean cutted = false;
        for(int i = 0;i<m;i++){
            for(int j = 0; j<n ; j++){
                // if have tree, cut it
                if(forest.get(i).get(j) > 1){
                    // cutted before, means can't cut at one time.
                    if(cutted)
                        return -1;
                    else{
                        cutted = true;
                        // cut tree and it's neighbor, recursively.
                        collectHelper(forest,i,j,trees);
                    }
                }
            }
        }

        // sort and calculate distance
        trees.sort((t1,t2) -> t1.h - t2.h);
        int totalDist = 0;
        for(int i = 0;i<trees.size()-1;i++){
            Tree startTree = trees.get(i);
            Tree endTree = trees.get(i+1);
            int dist = calculateDist(forest,startTree.x,startTree.y,endTree.x,endTree.y);
            totalDist += dist;
        }
        return totalDist;
    }

    int calculateDist(List<List<Integer>> forest, int startX,int startY,int endX,int endY){
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        {
            int[] point ={startX,startY,0};
            queue.add(point);
        }

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int dist = point[2];
            if(visited[x][y])
                continue;
            if(forest.get(x).get(y) == 0)
                continue;
            if(x == endX && y == endY)
                return dist;

            visited[x][y] = true;
            if(x>0 )
                queue.add(new int[]{x-1,y,dist+1});
            if(x<m-1)
                queue.add(new int[]{x+1,y,dist+1});
            if( y > 0)
                queue.add(new int[]{x,y-1,dist+1});
            if( y < n-1)
                queue.add(new int[]{x,y+1,dist+1});
        }
        return 0;
    }

    void collectHelper(List<List<Integer>> forest, int x,int y,ArrayList<Tree> trees){
        if(forest.get(x).get(y) <= 1)
            return;

        int h = forest.get(x).get(y);
        if(h<=1)
            return;

        forest.get(x).set(y,1);
        trees.add(new Tree(x,y,h));

        int m = forest.size();
        int n = forest.get(0).size();

        if(x>0)
            collectHelper(forest,x-1,y,trees);
        if(x<m-1)
            collectHelper(forest,x+1,y,trees);
        if(y>0)
            collectHelper(forest,x,y-1,trees);
        if(y<n-1)
            collectHelper(forest,x,y+1,trees);
    }
}
