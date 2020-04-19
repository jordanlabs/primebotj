package net.jordanlabs.primebotj;

import java.time.Duration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class App {

    public void printPrimes(final int maxNumber, final Duration interval) {
        final PrimeRunner primeRunner = new PrimeRunner(maxNumber);
        final Timer intervalTimer = new Timer(false);
        intervalTimer.scheduleAtFixedRate(
            primeRunner,
            0,
            TimeUnit.SECONDS.toMillis(interval.getSeconds())
        );
    }

    public static void main(String[] args) {
        final App app = new App();
        app.printPrimes(10, Duration.ofSeconds(2));
    }
}
