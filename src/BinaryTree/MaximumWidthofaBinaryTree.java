package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class HorizontalPair {
    TreeNode node;
    int level;

    HorizontalPair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class MaximumWidthofaBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int ans = 0;
        Queue<HorizontalPair> q = new LinkedList<>();
        q.offer(new HorizontalPair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().level;
            int first = 0;
            int last = 0;

            for(int i=0;i<size;i++) {
                HorizontalPair p = q.poll();

                if(i == 0)
                    first = p.level-min;
                else if(i == size - 1)
                    last = p.level-min;

                if(p.node.left != null)
                    q.offer(new HorizontalPair(p.node.left, (p.level - min) * 2 + 1));
                if(p.node.right != null)
                    q.offer(new HorizontalPair(p.node.right, (p.level - min) * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * PROBLEM DESCRIPTION:
         *
         * THE MAXIMUM WIDTH OF A BINARY TREE IS THE MAXIMUM OF ALL THE LEVEL WIDTHS. WIDTH FOR A LEVEL IS DEFINED AS THE
         * MAXIMUM NUMBER OF NODES BETWEEN THE LEFTMOST AND RIGHTMOST NODE OF THE LEVEL(INCLUDING THE END NODES AND THE NULL
         * NODES BETWEEN THE END NODES).
         *
         */

        /**
         * SOLUTION
         *
         * IN THIS WHAT WE HAVE TO DO IS CALCULATE WIDTH BETWEEN TWO NODES, IE THE FIRST AND THE LAST NODE IN HORIZONTAL LEVELS
         * , NOW THE NODES IN BETWEEN CAN BE NULL.
         *
         * APPROACH
         *
         * WE WILL USE LEVEL ORDER TRAVERSAL FOR THIS, WHAT WE HAVE TO DO IS DEFINE A CLASS THAT WILL STORE THE NUMBER OF
         * ITSELF IN A PARTICULAR LEVEL(EG IF WE FOLLOW 1 BASE SEQUENCING, ROOT IS 1, AND LEFT OF IT IS 2 AND RIGHT IS 3),
         * USING THIS WHAT WE WILL FOLLOW IS THAT FOR EVERY NODE IF MULTIPLY THE ROOT NODE * 2 AND ADD 1 IF WE FOLLOW 1
         * BASE SEQUENCING, THEN WE CAN EASILY FIND THE FIRST AND LAST NODE, FOR EG IT WOULD BE LIKE BELOW
         *
         *              1
         *            2   3
         *          4  5 6  7
         *
         * NOW FOR EVERY LEVEL THE NEXT NODES CAN BE CALCULATED BY 2 * LEVEL + 1, AND WIDTH CAN BE CALCULATED BY SUBTRACTING
         * LAST WITH 1ST - 1, SO FOR 3RD LEVEL OF ABOVE WIDTH WOULD BE 7-4 + 1 = 4 , WHICH IS TRUE
         *
         * SO WE CAN USE LEVEL ORDER TRAVERSAL AND THEN STORE EVERY NODE LEVEL AND VALUES, BUT THE PROBLEM IS THAT WE ARE
         * MULTIPLYING BY 2 AT EVERY STAGE, SO OUT OF BOUNDS CAN BE CAUSED FOR A VERY HIGH VALUE, SO WHAT WE WILL DO TO
         * SOLVE THIS IS RATHER THAN STORING LIKE ABOVE WE WILL STORE IT IN SUCH A WAY THAT IT BECOMES LIKE BELOW
         *
         *              1
         *            1   2
         *          1  2  3 4
         *
         * AS WE CAN SEE WE HAVE REMOVED THE OUT OF BOUND EXCEPTION RISK BY USING THIS WAY. SO THE STEPS TO DO THIS WOULD BE
         *
         * STEPS :
         *
         * DECLARE Q AND STORE ROOT WITH LEVEL 1, (IN CODE IT IS WRITTEN 0, SAME ANS WILL BE RETURNED FOR 1)
         *
         * RUN TILL Q IS NOT EMPTY
         *
         * GET THE SIZE OF Q, SO THAT WE CAN ITERATE FOR THAT PARTICULAR LEVEL
         *
         * VERY IMPORTANTLY GET THE FIRST NODE LEVEL, REPRESENT IT AS MIN
         * USE FIRST AND LAST VARIABLE TO GET THE SUBANS
         *
         * RUN FOR LOOP FOR 0 TO SIZE - 1, IF I == 0, MEANS IT IS OUR FIRST NODE, WE CAN SIMPLY STORE FIRST AS THE LEVEL
         * VALUE OR LEVEL - MIN, SIMILARLY IF I == SIZE - 1, GET LAST
         *
         * NOW TO STORE THE NEXT NODES, CHECK FOR LEFT, IF LEFT THEN SUBTRACT THE LEVEL - MIN AND MULTIPLY BY 2 AND ADD
         * 1, FOR EG FOR 2ND LEVEL 1ST NODE, 1 - 1 * 2 + 1, REPRESENTING LEFT CHILD, SIMILARLY ALL IS SAME FOR RIGHT JUST THAT
         * RATHER THAN ADDING 1 ADD 2.
         *
         * CHECK FOR MAX ANS
         *
         * RETURN ANS
         *
         *
         */
    }
}
