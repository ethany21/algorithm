import java.math.BigInteger;

class LeetCode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger big = new BigInteger(backnumber(l1)).add(new BigInteger(backnumber(l2)));

        String [] box = big.toString().split("");

        ListNode temp = new ListNode();

        ListNode result = recover(box, temp);

        return result;

    }
    public String backnumber(ListNode lst){

        if(lst == null){
            return "";
        }
        return backnumber(lst.next)+ Integer.toString(lst.val);
    }

    public ListNode recover(String [] temp, ListNode lst){

        int length = 0;
        lst = new ListNode(Integer.parseInt(temp[length]));
        length += 1;
        while(length < temp.length) {
            lst = new ListNode(Integer.parseInt(temp[length]), lst);
            length += 1;
        }
        return lst;
    }
}
