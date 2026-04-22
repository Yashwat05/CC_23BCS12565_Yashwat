import java.io.*;
import java.util.*;

public class C_Fox_And_Names {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[][] used = new boolean[26][26];
        int[] indegree = new int[26];

        for (int i = 0; i < n - 1; i++) {
            String a = names[i];
            String b = names[i + 1];

            int len = Math.min(a.length(), b.length());
            int pos = -1;

            for (int j = 0; j < len; j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    pos = j;
                    break;
                }
            }

            if (pos == -1) {
                if (a.length() > b.length()) {
                    System.out.println("Impossible");
                    return;
                }
            } else {
                int u = a.charAt(pos) - 'a';
                int v = b.charAt(pos) - 'a';

                if (!used[u][v]) {
                    used[u][v] = true;
                    graph[u].add(v);
                    indegree[v]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            ans.append((char) ('a' + u));

            for (int v : graph[u]) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (ans.length() != 26) {
            System.out.println("Impossible");
        } else {
            System.out.println(ans.toString());
        }
    }
}
