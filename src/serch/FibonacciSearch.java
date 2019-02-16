package serch;

public class FibonacciSearch {
    public int fibonacciSearch(int[] a, int v) {
        int[] f = fibonacci(a.length);
        int low = 0;
        int k = 0;
        int high = a.length - 1;
        while (high > f[k] - 1)
            k++;
        while (low <= high) {
            int mid = f[k] - 1;
            if (v == a[mid])
                return mid;
            if (v > a[mid]) {
                low = mid + 1;
                k = k - 2;
            } else {
                high = mid - 1;
                k = k - 1;
            }
        }
        return -1;
    }

    private int[] fibonacci(int a) {
        int[] f = new int[10];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 10; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
