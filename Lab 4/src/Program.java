import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Creating user");
        FiatSharifAlgorithm user = new FiatSharifAlgorithm();
        user.showPublicKeys();
        System.out.println("\nVerification of user");
        System.out.println("Enter public number and key on separate lines of the user being verified");
        UserVerification verification = new UserVerification(in.nextLine(), in.nextLine());
        verification.verifyUser(user);
    }
}
