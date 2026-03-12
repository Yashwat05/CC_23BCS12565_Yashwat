import java.util.Arrays;
import java.util.List;

public class labmst2 {
    
    public static int maxSum(List<Integer> nums, int k)
    {

        long MOD = 1_000_000_007;

        int[] bitCount = new int[32];

        for (int num : nums) 
        {
            for (int b = 0; b < 32; b++) 
            {
                if ((num & (1 << b)) != 0) 
                {
                    bitCount[b]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++)
        {
            long val = 0;

            for (int b = 0; b < 32; b++) 
            {
                if (bitCount[b] > 0) 
                {
                    val |= (1L << b);
                    bitCount[b]--;
                }
            }
            ans = (ans + (val * val) % MOD) % MOD;
        }

        return (int) ans;
    }
    public static void main(String[] args) 
    {
        List<Integer> a = Arrays.asList(2, 6, 5, 8);
        int r = maxSum(a, 3);
        System.out.println(r);
    }
}