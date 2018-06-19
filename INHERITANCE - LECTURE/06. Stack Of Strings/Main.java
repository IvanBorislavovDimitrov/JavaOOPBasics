public class Main {

    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();
        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        System.out.println(stack.isEmpty());
    }
}
