import java.util.*;

public class C_Watto_and_Mechanism {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        while (m-- > 0) {
            String s = sc.next();
            char[] arr = s.toCharArray();
            boolean found = false;

            for (int i = 0; i < arr.length && !found; i++) {
                char original = arr[i];

                for (char c : new char[]{'a','b','c'}) {
                    if (c == original) continue;

                    arr[i] = c;
                    String modified = new String(arr);

                    if (set.contains(modified)) {
                        found = true;
                        break;
                    }
                }

                arr[i] = original; // restore
            }

            if (found) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}