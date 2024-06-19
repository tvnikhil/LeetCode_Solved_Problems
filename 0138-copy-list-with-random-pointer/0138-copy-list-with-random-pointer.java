/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nn = new Node(temp.val);
            Node nextNode = temp.next;
            temp.next = nn;
            nn.next = nextNode;
            temp = nextNode;
        }
        temp = head;
        while (temp != null) {
            Node nn = temp.next;
            if (temp.random != null)
                nn.random = temp.random.next;
            else
                nn.random = null;
            temp = nn.next;
        }
        temp = head;
        Node dummy = new Node(-1);
        Node copyHead = dummy;
        while (temp != null) {
            Node copy = temp.next;
            Node nextNode = copy.next;
            dummy.next = copy;
            dummy = dummy.next;
            temp.next = nextNode;
            temp = nextNode;
        }
        return copyHead.next;
    }
}