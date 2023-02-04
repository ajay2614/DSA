package Graphs;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {

    /**
     *Time Complexity: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E)) where N = no. of indices or nodes and E = no.
     *  of emails. The first term is for visiting all the emails. The second term is for merging the accounts.
     *  And the third term is for sorting the emails and storing them in the answer array.
     *
     * Space Complexity: O(N)+ O(N) +O(2N) ~ O(N) where N = no. of nodes/indices. The first and second space
     * is for the ‘mergedMail’ and the ‘ans’ array. The last term is for the parent and size array used
     * inside the Disjoint set data structure.
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> map = new HashMap<>();

        int n = accounts.size();
        DisjointSet disjointSet = new DisjointSet(accounts.size());

        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                if(map.containsKey(accounts.get(i).get(j)) == false) {
                    map.put(accounts.get(i).get(j), i);
                }
                else {
                    disjointSet.unionBySize(map.get(accounts.get(i).get(j)), i);
                }
            }
        }

        ArrayList<ArrayList<String>> mergeList = new ArrayList<>();

        for(int i=0;i<n;i++) {
            mergeList.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> iter : map.entrySet()) {
            int val = iter.getValue();
            String ele = iter.getKey();

            int par = disjointSet.findUPar(val);

            mergeList.get(par).add(ele);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ArrayList<String> temp = mergeList.get(i);
            if(temp.size() == 0)
                continue;
            Collections.sort(temp);
            temp.add(0, accounts.get(i).get(0));

            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {

        String accounts[][] = {{"John","johnsmith@mail.com","john_newyork@mail.com"},
                {"John","johnsmith@mail.com","john00@mail.com"},
                {"Mary","mary@mail.com"},
                {"John","johnnybravo@mail.com"}};

        List<List<String>> accountsList = new ArrayList<>();

        for(String acc[] : accounts) {
            List<String> accList =  Arrays.stream(acc).collect(Collectors.toList());
            accountsList.add(accList);
        }

        AccountsMerge accountsMergeObj = new AccountsMerge();
        accountsMergeObj.accountsMerge(accountsList);

        /**
         * IN THIS QUESTION GIVEN A LIST OF LIST STRINGS, WHERE FIRST ENTRY IS NAME AND OTHERS ARE THE MAIL, WHAT CAN HAPPEN
         * IS IF THERE IS SAME MAIL IN DIFFERENT ENTRIES, WE NEED TO COMBINE BOTH THE ENTRIES TOGETHER AND RETURN AS ANS
         * FOR EG IN ABOVE ACCOUNTS johnsmith@mail.com IS COMMON BETWEEN 1ST AND SECOND, SO WE NEED TO COMBINE THE RECORDS
         * AND RETURN AS ANS "John","johnsmith@mail.com","john_newyork@mail.com", "john00@mail.com"
         *
         * WE WILL USE THE DISJOINT SET FOR THIS QUESTION
         *
         * FIRSTLY WHAT WE WILL DO IS USE A HASHMAP WITH STRING AS KEY AND AN INTEGER AS VALUE, NOW IF THERE COMES A ENTRY
         * WHERE IT IS COMMON WE WILL SIMPLY UNITE THEM USING DISJOINT SET, FOR EG WHEN johnsmith@mail.com WOULD HAVE
         * APPEARED AS COMMON WE WOULD HAVE UNITED IT WITH THE PREVIOUS INDEX IT CAME SO THAT ITS ULTIMATE PARENT
         * BECOMES THAT PREVIOUS INDEX, NOW WILL ITERATE VIA THE MAP, AND WILL HAVE EVERY KEY IN A LIST BASED ON THEIR ULTIMATE
         * PARENT, BECAUSE OF THIS WE WOULD BE ABLE TO MERGE 1ST AND 2ND TOGETHER IN LIST, SINCE WE ALWAYS NEEDED THE FIRST
         * VALUE WHICH IS NAME SORT OF AS A PRIMARY KEY, WE WILL ITERATE THROUGH N, SORT THE LIST HAVING RECORDS AND ADD THE NAME AT
         * 0TH INDEX AND ADD THIS LIST IN FINAL ANSWER.
         */
    }
}
