package Recursion;

public class MColouringProblem {

    public boolean graphColoring(boolean graph[][], int m, int n) {
        int colour[] = new int[n];
        return recursion(graph, m, colour, n, 0);
    }

    public boolean recursion(boolean graph[][], int m, int clr[], int n, int node) {
        if(n == node)
            return true;


        for(int i=1;i<=m;i++) {
            if(possible(i, graph, n,clr, node)) {
                clr[node] = i;
                if(recursion(graph, m, clr, n, node+1))
                    return true;
                clr[node] = 0;
            }
        }
        return false;

    }

    public boolean possible(int colour, boolean graph[][], int n, int clr[], int node) {
        for(int col=0;col<n;col++) {
            if(graph[node][col]) {
                if(clr[col] == colour)
                    return false;
            }
        }
        return true;
    }

    /**
     * M-COLOURING QUESTION STATES THAT GIVEN AN UNDIRECTED GRAPH, AND COLOURS FROM 1 TO M, WE NEED TO CHECK WHETHER WE CAN
     * APPLY THE COLOURS TO ALL THE VERTEX/NODES OF GRAPH WITH NO ADJACENT NODES HAVING SAME COLOUR
     *
     * NOTE : WE CAN BE A GIVEN A GRAPH IN FORM OF ADJACENCY LIST OR ADJACENCY ARRAY, THE APPRAOCH IS SAME,
     * ONLY REMEMBER WHEN ITERATING THROUGH ARRAY FOR EVERY ROW, OTHER COLUMNS BEEN TRUE OR FALSE MEANS WHETHER THEY ARE CONNECED
     * OR NOT.
     *
     * APPROACH
     *
     * WE COULD HAVE USED RECURSION FOR EVERY NODES BUT RATHER THAN THIS WHAT APPROACH WE WILL FOLLOW IS FOR EVERY NODE
     * WE WILL RUN A LOOP OF COLOURS FROM 1 TO M, IF THE NODE'S ADJACENT NODES DOESN'T HAVE SAME COLOUR, WE WILL MARK
     * THAT NODE INDEX OF COLOUR ARRAY AS TRUE AND THEN CALL RECURSION FOR NEXT NODE, OR ELSE WE WILL CHECK WITH NEXT COLOUR THE
     * SAME PROCESS
     *
     * STEPS
     *
     * CREATE A COLOUR ARRAY OF N INDEX TO STORE EVERY NODE'S USAGE OF COLOUR
     *
     * START A RECURSION FROM 0 NODE
     *
     * RUN A LOOP FROM 1 TO M AND CHECK IF THE COLOUR CAN BE APPLIED TO THAT NODE, FOR CHECKING RUN A LOOP AND CHECK IF
     * ANY ADJACENT NODE DOES HAVE SAME COLOUR OR NOT WITH THE HELP OF COLOUR ARRAY, IF NOT THEN RUN MARK THE NODE INDEX
     * OF COLOUR ARRAY WITH THAT COLOUR AND CALL RECURSION FOR NEXT NODE, DO MAKE SURE SINCE WE ARE CALLING
     * THIS BOOLEAN METHOD RECURSION SO WE WILL RETURN TRUE IF IT IF THE NEXT NODE IS ALSO TRUE, IF IT IS NOT MEANS THE SERIES
     * OF THE COLOUR APPLIED HAS BECOME FALSE DO MAKE SURE TO MARK THE NODE INDEX FOR COLOUR ARRAY AS 0 SO THAT WE CAN BACKTRACK
     *
     * IF NO COLOUR CAN BE APPLIED TO NODE FROM 1 TO M, RETURN FALSE
     *
     */
}
