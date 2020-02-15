import java.util.LinkedList;
import java.util.Collections;

public class merge_sort {

    public static LNode getMid(LNode root) {
        LNode slow = root;
        LNode fast = root.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static LNode merge(LNode node1, LNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        LNode result = null;

        if (node1.data <= node2.data) {
            result = node1;
            result.next = merge(node1.next, node2);
        } else {
            result = node2;
            result.next = merge(node1, node2.next);
        }
        return result;
    }

    public static LNode mergeSort(LNode head) {
        if (head == null || head.next == null)
            return head;

        LNode mid = getMid(head);
        LNode nextMid = mid.next;
        mid.next = null;

        LNode first = mergeSort(head);
        LNode second = mergeSort(nextMid);
        return merge(first, second);

        // return head;
    }

    // public static void merge2(List<Integer>leftList, List<Integer>rightList) {

    // }
    // public static void mergeSort2(List<Integer> list) {
    // if (list.size() <= 1)
    // return;

    // int mid = list.size() / 2;
    // List<Integer>leftList = list.subList(0, mid+1);
    // List<Integer>rightList = list.subList(mid+1, list.size());
    // mergeSort2(leftList);
    // mergeSort2(rightList);
    // merge2(leftList, rightList);
    // }

    public static void main(String[] args) {
        // LNode head = new LNode(2);
        // LNode temp = head;
        // temp.next = new LNode(5);
        // temp = temp.next;
        // temp.next = new LNode(3);
        // temp = temp.next;
        // temp.next = new LNode(4);
        // temp = temp.next;
        // temp.next = new LNode(1);
        // temp = temp.next;
        // temp.next = new LNode(6);
        // temp = head;

        // head = mergeSort(head);
        // temp = head;
        // while (temp != null) {
        // System.out.print(temp.data + "->");
        // temp = temp.next;
        // }

        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(60);
        list.add(30);
        list.add(50);
        list.add(40);
        list.add(20);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }

}