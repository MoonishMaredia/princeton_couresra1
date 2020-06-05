public class StackQueue27<Item> {

    private MyStackImplementation<Item> stack1;
    private MyStackImplementation<Item> stack2;

    private int size1 = 0;
    private int size2 = 0;

    public StackQueue27() {
        stack1 = new MyStackImplementation();
        stack2 = new MyStackImplementation();
    }

    public void enqueue(Item item) {
        stack1.push(item);
        size1++;
    }

    public Item dequeue() {

        int cnt = 0;
        while (size1 > 0) {
            stack2.push(stack1.pop());
            size1--;
            size2++;
        }
        Item ret = stack2.pop();
        size2--;
        return ret;
    }

    public int getSize() {
        return size1 + size2;
    }

    public static void main(String[] args) {
        StackQueue27<Integer> test = new StackQueue27<Integer>();
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        test.enqueue(4);
        test.enqueue(5);
        test.enqueue(6);
        test.enqueue(7);
        test.enqueue(8);
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());
        System.out.println(test.dequeue());

        System.out.println("=======Size of the Queue=====");
        System.out.println(test.getSize());
    }
}
