import java.math.BigInteger;
import java.util.List;

public class SolutionCheck {


    public static ListNode toList(String[] temp, ListNode lst){

        int length = 0;

        lst = new ListNode(Integer.parseInt(temp[length]));
        length += 1;
        while(length < temp.length) {
            lst = new ListNode(Integer.parseInt(temp[length]), lst);
            length += 1;
        }
        return lst;
    }

    public static void main(String[] args) {
        LeetCode2 lt = new LeetCode2();

        ListNode box1 = new ListNode();
        ListNode box2 = new ListNode();

        String [] first = {"5","6","4"};
        String [] second = {"1","0","0","0","0","0", "0","0","1"};

        ListNode lst = toList(first, box1);
        ListNode lst6 = toList(second, box2);

        System.out.println(lt.backnumber(lt.addTwoNumbers(lst, lst6)));



    }
}
