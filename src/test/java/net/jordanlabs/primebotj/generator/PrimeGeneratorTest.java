package net.jordanlabs.primebotj.generator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeGeneratorTest {
    @Test
    void numberOfFoundPrimesMatchExpected() {
        // Given
        final PrimeGenerator primeGenerator = new PrimeGenerator();
        final int expectedPrimeCount = 5_761_455;

        // When
        final List<Integer> primes = primeGenerator.primeNumbers(100_000_000);

        // Then
        assertThat(primes).hasSize(expectedPrimeCount);
    }

    @ParameterizedTest
    @CsvSource({"2,true", "5,true", "9,false"})
    void checkIfNumberIsPrime(final int givenNumber, final boolean expectedIsPrime) {
        // When
        final boolean isPrime = PrimeGenerator.isPrime(givenNumber);

        // Then
        assertThat(isPrime).isEqualTo(expectedIsPrime);
    }
}
