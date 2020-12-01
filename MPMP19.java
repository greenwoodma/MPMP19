import java.math.BigInteger;
import java.util.stream.Stream;

public class MPMP19 {
    static BigInteger primeIndex = BigInteger.ONE;
    static BigInteger total = BigInteger.valueOf(2 * 2);
    static BigInteger THREE = BigInteger.valueOf(3);

    public static void main(String args[]) {

        long startTime = System.currentTimeMillis();

        Stream.iterate(THREE, i -> i.add(BigInteger.TWO))
                .filter(i -> Stream.iterate(BigInteger.TWO, k -> k.compareTo(i.sqrt()) <= 0, k -> k.add(BigInteger.ONE))
                        .allMatch(j -> !(i.mod(j).equals(BigInteger.ZERO))))
                .forEach(n -> {
                    long elapsed = System.currentTimeMillis() - startTime;
                    BigInteger remainder = (total = total.add(n.multiply(n)))
                            .mod(primeIndex = primeIndex.add(BigInteger.ONE));
                    if (remainder.equals(BigInteger.ZERO))
                        System.out.println(primeIndex + "\t" + n + "\t" + total + "\t" + elapsed);
                    System.err.println(primeIndex + "\t" + n + "\t" + total + "\t" + remainder + "\t" + elapsed);
                });
    }
}
