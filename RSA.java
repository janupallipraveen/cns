import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = new BigInteger("17");
        BigInteger d = e.modInverse(phi);

        System.out.print("Enter Message : ");
        BigInteger message = new BigInteger(sc.nextLine());

        // Encryption
        BigInteger cipherText = message.modPow(e, n);
        System.out.println("Encrypted Message : " + cipherText);

        // Decryption
        BigInteger decryptedText = cipherText.modPow(d, n);
        System.out.println("Decrypted Message : " + decryptedText);
    }
}
