package linkedlist;

public class MaximumTwinSumOfALinkedList {
    // It is easy question
    // Just like check whether a string is palindrome or not
    // Toh usme bhi i ans n-i-1 node ko ek saath access krna padta tha toh usme direcly reverse kr dete the
    // ll ko mid ke baad , phir ek pointer start pr and ek mid pr fir dono ko ek ek badao toh i, n-i-1 dono ek saath access hogi

    public int pairSum(ListNode head) {

        ListNode j=reverseLL(findMiddleNode(head));

        ListNode i=head;

        int maxSum=Integer.MIN_VALUE;

        while (i!=null){
            int currSum=i.val+j.val;
            if(currSum>maxSum){maxSum=currSum;}
            i=i.next;
            j=j.next;
        }

        return maxSum;
    }

    public ListNode findMiddleNode(ListNode node){
        // in 5,4,2,1 it gives 2 as a middle node and vahi se reverse krna tha toh theek hai
        // in 5,4,2,1,7 it gives 2 as a middle node but hume 1 se reverse krna tha
        ListNode slow=node;
        ListNode fast=node;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public ListNode reverseLL(ListNode node){
        ListNode before=null;
        ListNode curr=node;
        ListNode after=node;

        while (curr!=null){
            after=curr.next;
            curr.next=before;

            before=curr;
            curr=after;
        }

        return before;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
