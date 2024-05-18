import java.util.*;
import java.util.EmptyStackException;

public class Main {
    public static void main(String[] args) {
        //                 12345
        Scanner scanner=new Scanner(System.in);
        int sizeArr;
        String input = scanner.nextLine();
        ArrayStack<Character> stack = new ArrayStack<>(input.length());
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
class ArrayStack<T> {
    private T[] array;
    private int index=-1;

    public ArrayStack(int size) {
        array = (T[]) new Object[size];
    }

    public void push(T t) {
        if (isFull())
            throw new StackOverflowError("Stack full");
        index++;
        array[index] = t;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        index--;
        return array[index+1];
    }

    public T top() {
        if (isEmpty())
            throw new EmptyStackException();
        return array[index];
    }

    public boolean isEmpty() {
        if(index == -1)
            return true;
        return false;
    }
    public boolean isFull() {
        if(index >= array.length-1)
            return true ;
        return false;
    }
}
