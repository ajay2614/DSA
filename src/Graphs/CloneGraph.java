package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Nodecloned {
    public int val;
    public List<Nodecloned> neighbors;
    public Nodecloned() {
        val = 0;
        neighbors = new ArrayList<Nodecloned>();
    }
    public Nodecloned(int _val) {
        val = _val;
        neighbors = new ArrayList<Nodecloned>();
    }
    public Nodecloned(int _val, ArrayList<Nodecloned> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Nodecloned cloneGraph(Nodecloned nodecloned) {
        if (nodecloned == null)
            return null;
        HashMap<Integer, Nodecloned> map = new HashMap<>();
        return clone(nodecloned, map);
    }

    private Nodecloned clone(Nodecloned nodecloned, HashMap<Integer, Nodecloned> map) {
        if (map.get(nodecloned.val) != null)
            return map.get(nodecloned.val);

        Nodecloned clonedNodecloned = new Nodecloned(nodecloned.val);
        map.put(nodecloned.val, clonedNodecloned);
        for (Nodecloned neighbor : nodecloned.neighbors) {
            clonedNodecloned.neighbors.add(clone(neighbor, map));
        }
        return clonedNodecloned;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO CLONE A GRAPH, IN OTHER WORDS WE HAVE TO MAKE A DEEP COPY OF THE GRAPH
         *
         * WE CAN DO THIS USING DFS/RECURSION HOWEVER THE PROCESS WOULD BE LITTLE DIFFERENT AS IN THIS WE CAN'T USE INTEGER ARRAY
         * TO MARK VISITED AS THERE IS NO ADJACENCY LIST SO WE WILL USE A HASHMAP HERE TO CHECK IF A NODE EXISTS.
         *
         * SIMPLY USE A METHOD TO RETURN NODE, IF A NODE ALREADY IS PRESENT THEN RETURN ELSE CREATE A NEW NODE AND INITIALIZE IT
         * WITH NODES VALUE AND PUT IT ONTO MAP, NOW TRAVERESE FOR ITS NEIGHBORS AND CALL THE SAME METHOD TO CREATE IT'S NEIGHBORS.
         *
         * RETURN THE NODE IN THE END.
         */
    }
}
