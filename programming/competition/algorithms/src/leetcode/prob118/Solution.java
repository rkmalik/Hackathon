package leetcode.prob118;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(
            int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (numRows <= 0)
            return result;

        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);

        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < i - 1; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }

            cur.add(1);
            pre = cur;
            result.add(cur);
        }
        return result;
    }
}