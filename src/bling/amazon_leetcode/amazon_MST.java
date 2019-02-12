package bling.amazon_leetcode;

import bling.Leetcode.util;

import java.util.*;

public class amazon_MST {

    public static void main(String[] args) {
        Edge[] edges = new Edge[5];
        edges[0] = new Edge("a","b",1);
        edges[1] = new Edge("a","c",5);
        edges[2] = new Edge("b","c",2);
        edges[3] = new Edge("b","d",5);
        edges[4] = new Edge("c","d",1);
        amazon_MST sol = new amazon_MST();
        int cost = sol.MST(edges);
        util.println(cost);
    }
    static class Edge{
        String s1;
        String s2;
        int weight;
        Edge(String s1,String s2,int val){
            this.s1 = s1;
            this.s2 = s2;
            this.weight = val;
        }
    }

    public int MST(Edge[] edges){
        // sort Edges
        Arrays.sort(edges,(a1,a2)->a1.weight-a2.weight);

        Map<String,Integer> cities = new HashMap<>();
        List<List<String>> groups = new ArrayList<>();

        int cur = 0;
        int cost = 0;
        for(Edge edge : edges){
            if(!cities.containsKey(edge.s1)){
                cities.put(edge.s1,cur);
                groups.add(new ArrayList<>());
                groups.get(cur).add(edge.s1);
                cur++;
            }
            if(!cities.containsKey(edge.s2)){
                cities.put(edge.s2,cur);
                groups.add(new ArrayList<>());
                groups.get(cur).add(edge.s2);
                cur++;
            }

            int s2Id = cities.get(edge.s2);
            int s1Id = cities.get(edge.s1);


            // merge two group
            // merge s2 to s1
            if(s2Id != s1Id){
                cost += edge.weight;
                for(String s:groups.get(s2Id)){
                    cities.put(s,s1Id);
                    groups.get(s1Id).add(s);
                }
                groups.get(s2Id).clear();
            }
        }
        return cost;
    }
}
