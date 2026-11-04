import java.util.Scanner;
public class HillCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] key = {{3, 3}, {2, 5}};
        int[][] invKey = {{15, 17}, {20, 9}};   
        System.out.print("Enter Plain Text : ");
        String text = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        if (text.length() % 2 != 0)
            text += "X";                       
        String encrypted = "";
        String decrypted = "";
        for (int i = 0; i < text.length(); i += 2) {
            int m0 = text.charAt(i) - 'A';
            int m1 = text.charAt(i + 1) - 'A';
            int c0 = (key[0][0] * m0 + key[0][1] * m1) % 26;
            int c1 = (key[1][0] * m0 + key[1][1] * m1) % 26;
            encrypted += (char) (c0 + 'A');
            encrypted += (char) (c1 + 'A');
        }
        System.out.println("Encrypted Text : " + encrypted);
        for (int i = 0; i < encrypted.length(); i += 2) {
            int c0 = encrypted.charAt(i) - 'A';
            int c1 = encrypted.charAt(i + 1) - 'A';
            int p0 = (invKey[0][0] * c0 + invKey[0][1] * c1) % 26;
            int p1 = (invKey[1][0] * c0 + invKey[1][1] * c1) % 26;
            decrypted += (char) (p0 + 'A');
            decrypted += (char) (p1 + 'A');
        }
        System.out.println("Decrypted Text : " + decrypted);
    }
}
