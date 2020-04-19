package net.jordanlabs.primebotj;

import net.jordanlabs.primebotj.generator.PrimeGenerator;

import java.util.List;
import java.util.TimerTask;

public class PrimeRunner extends TimerTask {
    private final PrimeGenerator primeGenerator = new PrimeGenerator();
    private final List<Integer> primeNumbers;
    private int currentPrime;

    public PrimeRunner(final int maxNumber) {
        primeNumbers = primeGenerator.primeNumbers(maxNumber);
        currentPrime = 0;
    }

    @Override
    public void run() {
        if (currentPrime < primeNumbers.size()) {
            System.out.println(primeNumbers.get(currentPrime));
            currentPrime++;
        }
    }
}
