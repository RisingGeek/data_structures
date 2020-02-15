public class power_set {
    public static void powerSet(String str, String ans) {
        System.out.print(ans+" ");
        for(int i=0;i<str.length();i++) {
            powerSet(str.substring(i+1), ans+str.charAt(i));
        }
    }

    public static void main(String[] args) {
        powerSet("abc", "");
    }
}