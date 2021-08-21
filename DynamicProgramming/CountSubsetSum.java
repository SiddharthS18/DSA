package DynamicProgramming;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 5, 6, 8, 10 };
        int sum = 10;
        int n = arr.length;
        int output = knapsack(arr, sum, n);
        System.out.println("The output is " + output);
    }

    static int knapsack(int[] arr, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        t[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0 && i != 0)
                    t[i][j] = 1;
                else if (i == 0 && j != 0)
                    t[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = (t[i - 1][j - arr[i - 1]] + t[i - 1][j]);

                else
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[n][sum];
    }
}
