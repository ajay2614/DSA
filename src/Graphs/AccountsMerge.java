package Graphs;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
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
    }
}
