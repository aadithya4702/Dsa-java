package JavaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class groupAnagrams {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> anv = groupAnagrams(strs);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String p = new String(c);

            if (res.containsKey(p)) {
                res.get(p).add(strs[i]);
            } else {
                res.put(p, new ArrayList<>());
                res.get(p).add(strs[i]);
            }
        }

        for (List<String> group : res.values()) {
            ans.add(group);
        }
        return ans;
    }
}