public class word_break {

    public static boolean isPresent(String[] dict, String word) {
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equals(word))
                return true;
        }
        return false;
    }

    public static void word_break_problem(String[] dict, String word, String ans) {
        if (word.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            String curr = word.substring(0, i + 1);
            if (isPresent(dict, curr)) {
                word_break_problem(dict, word.substring(i + 1), ans + curr + " ");
            }
        }
    }

    public static void main(String[] args) {
        String[] dict = { "i", "love", "sam", "sung", "samsung", "mobile" };
        String word = "ilovesamsung";
        word_break_problem(dict, word, "");
    }
}