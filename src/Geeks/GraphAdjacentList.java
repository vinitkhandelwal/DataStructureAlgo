package Geeks;

import java.util.ArrayList;
import java.util.List;

import static Geeks.GraphBased.makeEdge;

public class GraphAdjacentList {

    public static void main(String[] args) {
        int cities[][] = new int[3][2];
        cities[0][0] =1;
        cities[0][1] =2;
        cities[1][0] =3;
        cities[1][1] =1;

        cities[2][0] =2;
        cities[2][1] =3;

        printMatrix(cities);

        System.out.println(roadsAndLibraries(3,2,1,cities));
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities){

        ArrayList<Integer>[] city  = (ArrayList<Integer>[]) new ArrayList[n+1];

        for (int c = 0; c <= n; c++) {
            city[c] = new ArrayList<Integer>();
        }

        for(int i = 0; i < cities.length;i++){
            for(int j = 0 ; j < cities[i].length;j++){
                city[cities[i][0]].add(cities[i][1]);
                city[cities[i][1]].add(cities[i][0]);
            }
        }

        for (int i = 0; i < city.length; i++){
            System.out.println(city[i]);
        }

        if(c_lib < c_road) return c_lib*n;

        else{
            long connectedComponent = countConnectedComponent(city);
            long cost = 0;

            cost =  ((n-connectedComponent)*c_road);

            cost = cost + connectedComponent*c_lib;
            return cost;
        }

//        printMatrix(matrix,n);

    }

    static void printMatrix(int[][] matrix){
        for(int k =0 ; k < matrix.length;k++){
            for(int p= 0;p< matrix[k].length;p++){
                System.out.print(matrix[k][p] + ",");
            }
            System.out.println();
        }
    }

    static long countConnectedComponent(ArrayList<Integer>[] cities){
      boolean []  nodeVisited = new boolean[cities.length+1];

        for(int i = 1;i <= cities.length;i++){
            nodeVisited[i] = false;
        }
        long connectedComponent = 0;
        for(int i = 1;i < cities.length;i++){
            if(nodeVisited[i] == false){
                DFS(i,nodeVisited,cities);
                connectedComponent++;
            }
        }
        return connectedComponent;
    }

    static void DFS(int node,boolean [] nodeVisited,ArrayList<Integer>[] cities){
        nodeVisited[node] = true;
        List<Integer> nodes = cities[node];
        for(Integer i : nodes ){
            if(!nodeVisited[i]){
                DFS(i,nodeVisited,cities);
            }
        }



    }


}
