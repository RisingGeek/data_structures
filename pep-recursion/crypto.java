import java.util.Arrays;

public class crypto {
    public static String getUniqueString(int[] freq, String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i) - 'a'] == 0) {
                ans += str.charAt(i);
            }
            freq[str.charAt(i) - 'a']++;
        }

        return ans;
    }

    public static int StringToNumber(int[] mapping, String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans = ans * 10 + mapping[str.charAt(i) - 'a'];
        }
        return ans;
    }

    public static void crypto_rec(int[] mapping, boolean[] isTaken, String s1, String s2, String s3, String str) {
        if (str.length() == 0) {
            int num1 = StringToNumber(mapping, s1);
            int num2 = StringToNumber(mapping, s2);
            int num3 = StringToNumber(mapping, s3);
            if (num1 + num2 == num3) {
                for (int i = 0; i < mapping.length; i++) {
                    if (mapping[i] != -1) {
                        int letter = 'a' + i;
                        System.out.print((char) letter + " : " + mapping[i]+", ");
                    }
                }
                System.out.println();
            }
            return;
        }

        for (int num = 0; num <= 9; num++) {
            // istaken
            if (isTaken[num] == false) {
                isTaken[num] = true;
                mapping[str.charAt(0) - 'a'] = num;

                crypto_rec(mapping, isTaken, s1, s2, s3, str.substring(1));

                isTaken[num] = false;
                mapping[str.charAt(0) - 'a'] = -1;
            }
        }
    }

    public static void crypto_arithmetic(String s1, String s2, String s3) {
        int[] mapping = new int[26];
        int[] freq = new int[26];
        boolean[] isTaken = new boolean[10];
        Arrays.fill(mapping, -1);

        String str = getUniqueString(freq, s1 + s2 + s3);
        crypto_rec(mapping, isTaken, s1, s2, s3, str);
    }

    public static void main(String[] args) {

        String s1 = "send";
        String s2 = "more";
        String s3 = "money";
        crypto_arithmetic(s1, s2, s3);
    }
}