public class all_strings_space {
    public static void allStringsSpaceProblem(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        String nstr = str.substring(1);
        char ch = str.charAt(0);
        allStringsSpaceProblem(nstr, ans + ch);
        allStringsSpaceProblem(nstr, ans + " " + ch);
    }

    public static void allStringsSpace(String str) {
        if (str.length() == 0)
            return;
        if (str.length() == 1) {
            System.out.println(str);
            return;
        }
        allStringsSpaceProblem(str.substring(1), str.substring(0, 1));
    }

    public static void main(String[] args) {
        String str = "ABC";
        allStringsSpace(str);
    }
}