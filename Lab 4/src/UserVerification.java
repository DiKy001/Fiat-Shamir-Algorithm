import java.math.BigInteger;
import java.util.Random;

public class UserVerification {
    private final BigInteger n;
    private final BigInteger v;
    private final Random random = new Random();

    public UserVerification(String nn, String vv) {
        n = new BigInteger(nn);
        v = new BigInteger(vv);
    }

    public void verifyUser(FiatSharifAlgorithm user) {
        int t = 5;
        //int t = 1 + random.nextInt(5);
        int i = 1;
        System.out.println();
        System.out.println(t + " accreditations:");
        while (i <= t) {
            System.out.println("\nVerification accreditation " + i);
            BigInteger x = user.getX();
            int e = random.nextInt(2);
            BigInteger y = user.getY(e);
            //System.out.println(y.pow(2).mod(n) + " " + x.multiply(v.pow(e)).mod(n));
            if (y.pow(2).mod(n).equals(x.multiply(v.pow(e)).mod(n))) {
                System.out.println("Verification accreditation passed");
            } else {
                System.out.println("Verification accreditation failed");
                System.out.printf("\nVerification of user %s failed\n", user.getUserName());
                return;
            }
            i++;
        }
        System.out.printf("\nVerification of user %s passed\n", user.getUserName());
    }
}
