import java.math.BigInteger;
import java.util.stream.Stream;

public class MPMP19 {

    // To make the maths simpler we start by knowing that the first
    // prime is 2 and so set the index to 1 and the total to 4
    static BigInteger primeIndex = BigInteger.ONE;
    static BigInteger total = BigInteger.valueOf(2 * 2);

    // There isn't a BigInteger.THREE constant so let's create one
    static BigInteger THREE = BigInteger.valueOf(3);

    public static void main(String args[]) {

        // log the start time
        long startTime = System.currentTimeMillis();

        // produce a stream of integers starting at three and adding
        // two each time to get the next number (i.e. we skip all even
        // numbers as we know they will never be prime
        Stream.iterate(THREE, i -> i.add(BigInteger.TWO))

                // check to see if i is prime by checking that i mod j is
                // none zero for all numbers j between 2 and the square root of i
                // The call to allMatch is "fail fast" so as soon as we find one
                // number that divides in exactly we stop.
                .filter(i -> Stream.iterate(BigInteger.TWO, k -> k.compareTo(i.sqrt()) <= 0, k -> k.add(BigInteger.ONE))
                        .allMatch(j -> !(i.mod(j).equals(BigInteger.ZERO))))

                .forEach(n -> {
                    // for each prime number we've found...

                    // log how long it was since we started
                    long elapsed = System.currentTimeMillis() - startTime;

                    // update the prime index and the running total all while
                    // calculating the remainder of dividing the total by the
                    // prime index
                    BigInteger remainder = (total = total.add(n.multiply(n)))
                            .mod(primeIndex = primeIndex.add(BigInteger.ONE));

                    // if the total is divisible by the prime index (i.e. remainder
                    // is zero then log this as a TSV row to the standard output stream
                    if (remainder.equals(BigInteger.ZERO))
                        System.out.println(primeIndex + "\t" + n + "\t" + total + "\t" + elapsed);

                    // log all the details as a TSV row to the standard error stream
                    // so we can go back and look at all the remainders etc. to try and spot
                    // any interesting patterns.
                    System.err.println(primeIndex + "\t" + n + "\t" + total + "\t" + remainder + "\t" + elapsed);
                });
    }
}
