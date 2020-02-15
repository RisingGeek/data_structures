public class queens_in_boxes {
    public static void queens_combi(boolean[] boxes, int tnq, int qpsf, int bn, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        for (int i = bn; i < boxes.length; i++) {
            queens_combi(boxes, tnq, qpsf + 1, i + 1, ans + "q" + qpsf + "b" + i + " ");
        }
    }

    public static void queens_permu(boolean[] boxes, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == false) {
                boxes[i] = true;
                queens_permu(boxes, tnq, qpsf + 1, ans + "q" + qpsf + "b" + i + " ");
                boxes[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int tnq = 3;
        boolean[] boxes = new boolean[5];
        queens_permu(boxes, tnq, 0, "");
    }
}