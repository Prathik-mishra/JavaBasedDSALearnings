import java.util.Stack;

public class questions_on_stack {
    //here we use recursion to do out task --> as follows
    public static void addData(int data,Stack<Integer> s){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();
        addData(data,s);
        s.push(top);
    }

    //for reversing a stack we make use of recursion:
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()) return;

        int top = s.pop();
        reverse(s);
        addData(top,s);

    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        //Qusetion is to a element at the bottom of the stack//

        s.push(1);
        s.push(2);
        s.push(3);

//        int data = 4;
//
//        addData(data,s);

        reverse(s);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
