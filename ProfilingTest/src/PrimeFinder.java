import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFinder {

    // Optimized version using Sieve of Eratosthenes algorithm
    public static List<Integer> findPrimesUpTo(int limit) {
        // Edge case
        if (limit < 2) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        // Sieve algorithm
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect results
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
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