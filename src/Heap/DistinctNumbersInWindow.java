package Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap();

        for(int i = 0;i< B;i++) {
            int ele = A.get(i);
            if(map.get(ele) == null)
                map.put(ele, 1);
            else
                map.put(ele, map.get(ele) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(map.size());
        for(int i=1;i<A.size() - B + 1; i++) {
            int prev = A.get(i-1);

            if(map.get(prev) == 1)
                map.remove(prev);
            else
                map.put(prev, map.get(prev) - 1);

            int cur = A.get(i + B - 1);

            if(map.get(cur) == null)
                map.put(cur, 1);
            else
                map.put(cur, map.get(cur) + 1);

            ans.add(map.size());
        }

        return ans;
    }

}
