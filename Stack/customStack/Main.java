package Stack.customStack;

public class Main {

    public static void main(String[] args) throws Exception {

        CustomStack stack = new DynamicStack(5);

        stack.push(20);
        stack.push(25);
        stack.push(2);
        stack.push(30);
        stack.push(40);
        stack.push(35);
        stack.push(49);

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
