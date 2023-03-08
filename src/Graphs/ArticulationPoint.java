package Graphs;

import java.util.ArrayList;

public class ArticulationPoint {
    /**
     * @param tin = time of insertion
     * @param lin = lowest time of insertion
     * @param isArticulation = hashset
     *
     * Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm
     * is just a simple DFS traversal.
     *
     * Space Complexity: O(3V), where V = no. of vertices. O(3V) is for the three arrays i.e. tin, low, and vis, each of size V.
     */
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int[] tin, int[] lin, int vis[], int timer, int isArticulation[]) {
        vis[node] = 1;
        lin[node] = tin[node] = timer++;
        int child = 0;

        for(int i:adj.get(node)) {
            if(i == parent)
                continue;
            if(vis[i] == 0) {
                dfs(adj, i, node, tin, lin, vis, timer, isArticulation);
                lin[node] = Math.min(lin[node], lin[i]);

                if(lin[i] >= tin[node] && parent != -1)
                    isArticulation[node] = 1;
                child++;
            }
            else
                lin[node] = Math.min(tin[i], lin[node]);
        }
        if(parent == -1 && child > 1)
            isArticulation[node] = 1;
    }
    public static void printArticulation(ArrayList<ArrayList<Integer>> adj, int n) {
        int tin[] = new int[n];
        int lin[] = new int[n];
        int vis[] = new int[n];
        int isArticulation[] = new int[n];
        for (int i=0;i<n;i++) {
            if(vis[i] == 0)
                dfs(adj, 0, -1, tin, lin, vis, 0, isArticulation);
        }

        for (int i : isArticulation)
            System.out.println(i);
    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

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

        printArticulation(adj, n);

        /**
         * SIMILAR TO BRIDGES QUESTION, IN THIS WE HAVE TO FIND A NODE WHICH CONNECTS TWO OR MORE COMPONENTS
         *
         * WE WILL USE ALMOST SAME CONCEPT AS WE DID IN BRIDGES, HERE ALSO WE WILL TAKE MINTIME AND MAXTIME
         *
         * THE ONLY DIFFERENCE IS WHEN WE ENCOUNTER A NODE THAT IS ALREADY VISITED WE WILL HAVE THE MINTIME OF CURR NODE
         * AS THE MIN OF MAXTIME OF THE ADJ NODE AND CURRENT MIN TIME OF THE NODE, THIS IS BECAUSE IF WE HAD DONE
         * THE SAME WAY LIKE WE DID PREVIOUSLY IN BRIDGES IT COULD END UP RETURNING WRONG ANSWER
         *
         * FOR EG IF 2 IS CONNECTING TWO COMPONENTS, 0S MIN TIME IS 1 AND SO 2 ALSO HAS MIN TIME AS 1, NOW 2 IS
         * CONNECTED TO 5 NOW IF WE HAD USED SAME APPROACH MIN TIME OF 5 WOULD ALSO BE 1, BUT WHEN WE COMPUTE
         * WE WOULD HAVE NO WAY TO CHECK WHETHER 2 IS CONNECTING TWO COMPONENTS, APART FROM THIS THE LOGIC CHANGE IS
         * AFTER COMING FROM RECURSION CHECK IF MINTIME[IT] >= MAXTIME[NODE], EQUAL TO IS BECAUSE EVEN IF THE TIME IS SAME
         * AS NODE IF EVEN IF IT HAD REACHED THE NODE THERE WAS NO WAY IT WOULD HAVE REACHED ITS PARENT WITH LESSER
         * MAXTIME.
         *
         * APART FROM THIS THERE IS ALSO ONE MORE CHANGE, IF THE PARENT IS -1, DON'T COMPUTE LIKE THIS AS A SITUATION
         * CAN ARISE SAY 0 -> 1, NOW WHEN 1 COMES BACK IT HAS MINTIME AS 1 AND 0 HAS MAXTIME AS 0, SO IT WOULD HAVE
         * SATISFIED THE CASE MINTIME[IT] >= MAXTIME[NODE] SO FOR THIS REASON WE WILL COMPUTE DIFFERENTLY THAT
         * IS BY COUNTING THE NUMBER OF NODES FOR PARENT AS -1, IF NODES ARE GREATER THAN 1 THAT MEANS IT WILL ALWAYS
         * BE AN ARTICULATION POINT SO ADD IT
         *
         * SINCE THERE COULD BE ARTICULATION POINTS THAT CAN COME MULTIPLE TIMES HENCE USE A SET.
         */
    }
}
