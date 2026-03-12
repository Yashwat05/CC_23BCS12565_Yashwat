import java.util.*;
public class labmst1 {
    
    public static int minimumSize(int[] nums, int op) {

        int maxs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            maxs = Math.max(maxs, n);
        }

        int lo = 1, hi = maxs;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            long split = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int s = entry.getKey();
                int cnt = entry.getValue();

                if (s <= mid) continue;

                split += (long) cnt * ((s + mid - 1) / mid - 1);
            }

            if (split > op)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }
    public static void main(String[] args){
        int[] a = {9};
        int r = minimumSize(a,2);
        System.out.println(r);
    }
}
