package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {

    public static void getBridges(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] lin, int[] tin, boolean vis[], int timer) {
        vis[node] = true;
        tin[node] = lin[node] = timer++;

        for(int i : adj.get(node)) {
            if (i == parent)
                continue;
            if(vis[i] == false) {
                getBridges(i, node, adj, lin, tin, vis, timer);
                lin[node] = Math.min(lin[i], lin[node]);
                if(lin[i] > tin[node])
                    System.out.println(i + " -> " + node);
            }
            else
                lin[node] = Math.min(lin[node], tin[i]);
        }
    }

    public static void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean vis[] = new boolean[n];

        //lin stands for LOWEST TIME OF INSERTION
        //tin stands for TIME OF INSERTION

        int tin[] = new int[n];
        int lin[] = new int[n];

        Arrays.fill(vis, false);
        int timer = 0;
        for(int i = 0;i<n;i++) {
            if(!vis[i]) {
                getBridges(i, -1, adj, lin, tin, vis, timer);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        printBridges(adj, n);

        String text = "hiheyhello";
        int index = text.lastIndexOf("h", 4);
        System.out.println(index);

        /**
         * IN THIS QUESTION WE HAVE TO RETURN ALL THE BRIDGES, A BRIDGE IS THAT EDGE WHICH CONNECTS TWO COMPONENTS TOGETHER
         *
         * WE WILL USE THE MINTIME AND THE MAXTIME/ACTUAL TIME WE CAN REACH TO A NODE
         *
         * START FROM TRAVERSING VIA DFS, HAVE A GLOBAL VARIABLE TIMER WHICH COMPUTES TIME TAKEN TO REACH ANY NODE
         *
         * INITIALLY MARK THE MINTIME AND MAXTIME AS THE TIMER AND TRAVERSE FOR DFS, IF THE NODE IS PARENT CONTINUE
         * ELSE CALL DFS FOR ITS ADJ NODE IF IT IS NOT VISITED, IF IT IS THAT MEANS THERE IS A POSSIBILITY TO REACH THE
         * CURRENT NODE FASTER, IE THE MINTIME OF IT WILL BE THE MIN OF THE CURRENT MINTIME AND ADJNODE MINTIME
         * IF THE NODE IS NOT VISITED CALL DFS FOR IT, NOW WHEN THIS ADJ NODE COMES BACK FIRST CHECK IF MINTIME OF
         * THE NODE IS MIN OF CURRENT MINTIME OR THE MINTIME OF ADJ NODE, IF THE MINTIME OF ADJ NODE > MAXTIME OF THE NODE
         * THAT MEANS THE ADJ NODE WHEN WENT INTO DFS HAD NO WAY TO GET LESS TIME AS NO OTHER NODE THAN IT WAS CONNECTED
         * TO PARENT AND THE CHECK ON PARENT MADE SURE THAT IT DOESN'T DO ANYTHING FOR PARENT AS ADJ NODE MEANING
         * THESE TWO NODES MAKE A BRIDGE HENCE IF THESE TWO ARE BROKEN MEANS THE COMPONENTS CONNECTED TOGETHER ARE BROKEN APART.
         */
    }
}
