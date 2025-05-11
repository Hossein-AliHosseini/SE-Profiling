import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

    // Unoptimized prime number finder
    public static List<Integer> findPrimesUpTo(int limit) {
        List<Integer> primes = new ArrayList<>();

        for (int num = 2; num <= limit; num++) {
            boolean isPrime = true;

            // Check divisibility up to num-1
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(num);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int limit = 1000000;
        List<Integer> primes = findPrimesUpTo(limit);
        System.out.println("Primes up to " + limit + ": " + primes);
    }
}