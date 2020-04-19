package net.jordanlabs.primebotj.generator;

// Miller-Rabin primality test later?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeGenerator {
    private boolean[] primeCandidates;

    public List<Integer> primeNumbers(final int primeLimit) {
        primeCandidates = new boolean[primeLimit];
        Arrays.fill(primeCandidates, true);

        final int upperLimit = (int) Math.round(Math.sqrt(primeLimit));
        for (int i = 2; i < upperLimit; i++) {
            if (primeCandidates[i]) {
                final int indexSqr = i * i;
                int k = indexSqr;
                for (int j = 1; k < primeLimit; j++) {
                    primeCandidates[k] = false;
                    k = indexSqr + i * j;
                }
            }
        }
        return reportPrimes();
    }

    public static boolean isPrime(final int n) {
        if (n <= 1) {
            return false;
        } else if (n <= 3) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i+= 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> reportPrimes() {
        final List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < primeCandidates.length; i++) {
            if (primeCandidates[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
