package gin.util;

public class MathsUtils {

    public static long factorial(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("factorial: i must be greater than 0");
        }
        long current = 1;
        for (int j = 1; j <= i; j++) {
            current *= j;
        }
        return current;
    }

    public static int choose(int n, int k) {
        if (n < k) {
            throw new IllegalArgumentException("choose: n must be greater or equal than k");
        }
        return (int) (factorial(n) / (factorial(k) * factorial(n - k)));

    }
}
