import java.util.*;

class Fenwick{
    int[] BIT;
    int n;

    Fenwick(int n) {
        this.n = n;
        BIT = new int[n + 1];
    }

    void update(int i, int v) {
        while (i <= n) {
            BIT[i] += v;
            i += (i & -i);
        }
    }

    int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    int rangeSum(int L, int R) {
        return query(R) - query(L - 1);
    }
}

public class FenwickTree {
    public static void main(String[] args) {
        int n = 5;
        Fenwick ft = new Fenwick(n);

        int[][] queries = {
            {1, 1, 5},
            {1, 2, 3},
            {2, 1, 2},
            {1, 5, 10},
            {2, 1, 5}
        };

        for (int[] q : queries) {
            if (q[0] == 1) {
                ft.update(q[1], q[2]);
            } else if (q[0] == 2) {
                System.out.println(ft.rangeSum(q[1], q[2]));
            }
        }
    }
}