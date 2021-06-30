import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class FiatSharifAlgorithm {
    private final BigInteger n;
    private final BigInteger s;
    private final BigInteger v;
    private final String userName;
    private final Random random = new Random();
    private final Scanner in = new Scanner(System.in);
    private BigInteger r;

    public String getUserName() { return userName; }

    public FiatSharifAlgorithm() {
        System.out.println("Enter new user name");
        userName = in.nextLine();
        Random random = new Random();
        BigInteger p = BigInteger.probablePrime(64, random);
        BigInteger q = BigInteger.probablePrime(64, random);
        /*System.out.println("Enter two approximately equal random prime number on separate lines");
        BigInteger p = new BigInteger(in.nextLine());
        BigInteger q = new BigInteger(in.nextLine());*/
        n = p.multiply(q);
        BigInteger s1 = BigInteger.probablePrime(n.bitLength(), random);
        while (s1.compareTo(n.divide(BigInteger.TWO)) <= 0 || s1.compareTo(n) >= 0 || s1.equals(p) || s1.equals(q)) {
            s1 = BigInteger.probablePrime(n.bitLength(), random);
        }
        s = s1;
        v = s.modPow(BigInteger.TWO, n);
    }

    public BigInteger getX() {
        System.out.println("Enter the number in range 1 - n-1");
        r = new BigInteger(in.nextLine());
        return r.pow(2).mod(n);
    }

    public BigInteger getY(int e) { return r.multiply(s.pow(e)).mod(n); }

    public void showPublicKeys() {
        System.out.println("Public number:\n" + n);
        System.out.printf("Public key of %s:\n%s\n", userName, v);
    }
}
