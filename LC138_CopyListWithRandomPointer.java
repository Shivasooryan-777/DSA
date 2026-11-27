public class LC138_CopyListWithRandomPointer {

    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Pass 1: Duplicate each node and insert it next to the original
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Pass 2: Set random pointers for duplicated nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Pass 3: Separate the original list and the copy list
        curr = head;
        Node dummy = new Node(0);
        Node copyCurr = dummy;

        while (curr != null) {
            Node nextOriginal = curr.next.next;
            Node copy = curr.next;

            copyCurr.next = copy;
            copyCurr = copy;

            curr.next = nextOriginal;
            curr = nextOriginal;
        }

        return dummy.next;
    }
}
