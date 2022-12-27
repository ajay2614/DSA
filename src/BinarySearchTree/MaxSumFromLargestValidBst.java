package BinarySearchTree;
class NodeValue_ {
    int min;
    int max;
    int sum;

    NodeValue_(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

public class MaxSumFromLargestValidBst {

    /**
     * UNLIKE LARGEST SIZE, HERE A SITUATION CAN ARRIVE ,IT COULD HAPPEN RIGHT IS IN POSITIVE AND LEFT IS IN NEGATIVE SO
     * WHILE RETURNING SUM COULD BE SHORTEN SO WE NEED MAX SUM VARIABLE TO TRACK MAX SUM AT ALL TIMES.
     *
     * REMEMBER IF ROOT HAS HIGHER VALUE THAN SAY LEFT AND RIGHT AND IS NOT VALID BST, FOR
     * EG SAY ROOT IS 14, LEFT IS 12, AND RIGHT IS 11, IT COULD BE THOUGHT THAT RIGHT ANSWER IS 14 AS AN INDIVIDUAL NODE,
     * BUT WE CAN ONLY TAKE MAX FROM VALID BST NODE AND 14 ISN'T SO 12 IS THE ANS HERE.
     */
    int maxSum = 0;
    public NodeValue_ getNodeSize(TreeNode root) {
        if(root == null) {
            return new NodeValue_(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue_ left = getNodeSize(root.left);
        NodeValue_ right = getNodeSize(root.right);

        if(left.max < root.val && root.val < right.min) {
            maxSum = Math.max(maxSum, left.sum + right.sum + root.val);

            return new NodeValue_(Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    left.sum + right.sum + root.val);
        }

        return new NodeValue_(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.sum, right.sum));
    }
    public int maxSumBST(TreeNode root) {
        getNodeSize(root);
        return maxSum;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN A BINARY SEARCH TREE, AMONG THIS THERE COULD BE INVALID BST, FOR EG CHILDREN AT SOME STAGE
         * IS INVALID SO BST COULD BE INVALID, WE NEED TO FIND THE MAX SUM REPRESENTED BY A BST.
         *
         * APPROACH
         *
         * WE CAN HAVE THREE SITUATIONS
         *
         * WHEN NODE IS NULL, WHEN IT IS VALID BST AND WHEN IT IS INVALID BST
         *
         * WE WILL CREATE A CLASS WHICH TAKES MIN VALUE, MAX VALUE AND SUM FOR EVERY BST
         *
         * NOW WE WILL FOLLOW A POST ORDER SO THAT WE CAN GET LEFT AND RIGHT AND THEN WE EVALUATE WHETHER FOLLOWING IS BST
         * USING THE ROOT, HOW TO CHECK?, THE MAX VALUE FROM LEFT NODE SHOULD BE SMALLER THAN ROOT AND THE MIN VALUE FROM
         * RIGHT SHOULD BE GREATER THEN ROOT.
         *
         * WHEN ROOT IS NULL
         *
         * RETURN MIN AS INTEGER.MAX AND MAX AS INTEGER.MIN, THIS IS DONE BECAUSE WHEN THIS WILL BE TAKEN AS LEFT IT THE MAX
         * OF IT WOULD BE MIN AND WILL ALWAYS BE SMALLER THAN ROOT VAL, AND WHEN THIS IS TAKEN AS MIN FOR RIGHT IT WILL BE BIGGER
         * THAN ROOT VAL
         *
         * WHEN ROOT IS GREATER THAN LEFT.MAX AND RIGHT.MIN
         *
         * THIS IS WHEN BST IS VALID, UPDATE THE MAX AS MAX OF EITHER MAX OR LEFT SUM + RIGHT SUM + ROOT.VAL (AS IT IS VALID BST)
         *
         * ALSO RETURN MIN OF ROOT AND LEFT MIN, THIS IS DONE BECAUSE IT COULD BE THAT LEFT WAS NULL AND ITS MIN WAS PASSED
         * AS INT MAX
         *
         * RETURN MAX AS MAX OF RIGHT MAX AND ROOT, DONE BECAUSE RIGHT MAYBE WAS NULL SO WE DON'T ACCIDENTLY MAS INT MIN AS
         * MAX.
         *
         * RETURN SUM AS LEFT + RIGHT + ROOT VAL
         *
         * WHEN IT IS NOT VALID BST, RETURN MAX AS INT MAX, SO IT ALWAYS FAILS FOR EG NOW WHEN ROOT OF THIS COMPARES
         * ITS MAX ROOT WILL ALWAYS BE SMALLER, AND SIMILARLY PASS MIN AS INT MIN SO ROOT IS NEVER SMALLER THAN THIS INTMIN AND
         * WILL FAIL THE CHECK OF BST AND PASS SUM AS LEFT + RIGHT (CAN ALSO SEND ANY VALUE LIKE 0, THIS IS USED WHEN WE
         * ARE NOT USING A VARIABLE LIKE MAX THEN THIS WILL WORK FOR GETTING MAX SIZE BUT NOT FOR MAX SUM, EXPLAINED ABOVE)
         *
         */
    }

}
