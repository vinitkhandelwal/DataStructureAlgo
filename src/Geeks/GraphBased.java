package Geeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GraphBased {
    static int [][] matrix ;
    static int connectComponent = 0;
    static boolean nodeVisited[];
    static int component[];
    static List<Integer> components = new ArrayList<>();
    public static void main(String[] args) {
        int cities[][] = new int[3][2];
        cities[0][0] =1;
        cities[0][1] =2;
        cities[1][0] =3;
        cities[1][1] =1;

        cities[2][0] =2;
        cities[2][1] =3;
        roadsAndLibraries(3,3,2,cities);

    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities){

        matrix = new int[n+1][n+1];

        for(int i = 0; i < cities.length;i++){
            for(int j = 0 ; j < cities[i].length;j++){
                makeEdge(cities[i][0],cities[i][1]);
                makeEdge(cities[i][1],cities[i][0]);
            }
        }

        if(c_lib < c_road) return c_lib*n;

        else{

        }

        printMatrix(matrix,n);
        int connectedComponent = countConnectedComponent(n);
        int cost = 0;

            cost = cost* ((n-connectedComponent)*c_road);

        cost = cost + connectedComponent*c_lib;
        return cost;
    }

    static int countConnectedComponent(int nodes){
        nodeVisited = new boolean[nodes+1];
        component = new int[nodes+1];
        nodeVisited[0] = true;
        for(int i = 1;i <= nodes;i++){
            nodeVisited[i] = false;
        }

        int com =0;
        for(int i = 1;i <= nodes;i++){
            if(!nodeVisited[i]){
                com++;
                DFS(i,nodes,com);

            }




        }
        return connectComponent;
    }

    static void DFS(int node,int nodes,int componentIncrement){
        nodeVisited[node] = true;
        if(component[node] == 0) component[node] = componentIncrement;

        for(int i = 1;i<nodes;i++){
            if(!nodeVisited[i] && matrix[node][i] == 1){
                DFS(i,nodes,componentIncrement);
            }
        }

    }

    static void makeEdge(int to, int form){

        try{
             matrix[to][form] = 1;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Vertex doesn't exist");
        }
    }

    static int getEdge(int from , int to){
        try{
            return matrix[from][to];
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("vertex don't exist");
        }
        return 0;
    }



    static void printMatrix(int[][] matrix,int nodes){
        for(int k =1 ; k <=nodes;k++){
            for(int p= 1;p<= nodes;p++){
                System.out.print(matrix[k][p] + ",");
            }
            System.out.println();
        }
    }
}
