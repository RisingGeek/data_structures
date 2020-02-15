import java.util.Scanner;

public class problem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());
        for (int it = 0; it < t; it++) {
            int n = Integer.parseInt(scan.nextLine());
            String sample = scan.nextLine();
            String[] dict = sample.split(" ");
            String word = scan.nextLine();
            for (int i = 0; i < dict.length; i++) {
                System.out.print(dict[i] + " ");
            }
            System.out.println();
            System.out.println(word);
        }
    }
}