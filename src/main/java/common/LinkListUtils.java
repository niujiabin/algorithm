package common;

/**
 * @author Administrator
 */
public class LinkListUtils {

    public static void forEachElement(ListNode node) {

        if (node == null) {
            return;
        }
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println(node.val);
    }
}
