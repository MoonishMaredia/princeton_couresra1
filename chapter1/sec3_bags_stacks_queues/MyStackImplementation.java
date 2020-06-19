public class MyStackImplementation<Item> {

    private Item[] arr = (Item[]) new Object[1];
    private int N = 0;

    public void resize(int max) {

        /**
         * Resizes the array "arr" so that it is equal to provided parameter size.
         * Modifies the array size and copies over existing element in same order
         * @input: max. Size you want for the resulting array
         * @return No return.
         */

        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public void push(Item item) {

        /**
         * Adds item to the top of stack.
         * Resizes array to 2x its original length if adding to last element of array
         * @input: item. Item to be added into the array
         * @return No return.
         */

        if (arr.length == N) resize(arr.length * 2);
        arr[N] = item;
        N++;
    }

    public Item pop() {

        /**
         * Removes most recent item entered into the stack
         * Resizes array to 0.5 its original length if array will be 25% of total capacity
         * @input: item. Item to be added into the array
         * @return No return.
         */

        N--;
        Item ret = arr[N];
        if (N > 0 && N < arr.length / 4) resize(arr.length / 2);
        return ret;
    }

    public static void main(String[] args) {
        MyStackImplementation<Integer> test = new MyStackImplementation<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        System.out.println(test.pop());
        test.push(4);
        test.push(5);
        test.push(6);
        System.out.println(test.pop());
        System.out.println(test.pop());
        test.push(7);
        test.push(8);
        System.out.println(test.pop());
        test.push(9);
    }
}
