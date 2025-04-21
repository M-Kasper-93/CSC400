public interface Stack<T> { //stack interface
        public void push(T newEntry);
        public T pop();
        public T peek();
    }

public class ListStack<T> implements Stack<T> { //stack with linked list implementation
    private Node<T> stackTop;

    private static class Node<T> { //node class to link list elements
        T item;
        Node<T> next;
        Node(T item, Node<T> next) { //parameterized constructor
            this.item = item;
            this.next = next;
        }
        public void push(T newEntry) {//pushes operand or operator item to stack or push result 
            stackTop = new Node<>(newEntry, stackTop); 
        }

        public T pop() { //pop items from stack to perform operation
            T item = stackTop.item; //retrieve current top node from list
            stackTop = stackTop.next; //update pointer
            return item;
        }
    }

public class PostFixCalc
    public int evaluatePostfix(String expression, Stack<Integer> stack) { //evaluate expression from stack
        String[] tokens = expression.split(" "); //splits expression into tokens
        for (String token : tokens) {
            if (token.matches("-?//d+")) { //need to make sure token is an integer in order to do math
                stack.push(Integer.parseInt(token)); //push operand as an integer
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (token) {
                    case "+": stack.push(operand1 + operand2); break;
                    case "-": stack.push(operand1 - operand2); break;
                    case "*": stack.push(operand1 * operand2); break;
                    case "/": stack.push(operand1 / operand2); break;
                    case "%": stack.push(operand1 % operand2); break;
                    default: throw new IllegalArgumentException("Invalid operator.");
                }
            }
        }
        return stack.pop();
    } 

    public static void main(String[] args) {
        Stack<String> calculator = new ListStack<>;
        
        //expression 1
        String expression1 = "6 3 / 4 +";
        System.out.println(expression1 + " equals: " + calculator.evaluatePostfix(expression1));

        //expression 2
        String expression2 = "12 3 * 25 -";
        System.out.println(expression2 + " equals: " + calculator.evaluatePostfix(expression2));

        //expression 3 (with % operator)
        String expression3 = "17 5 % 3 *";
        System.out.println(expression3 + " equals: " + calculator.evaluatePostfix(expression3));
    
        //expression 4 (invalid expression)
        String expression3 = "9 +";
        System.out.println(expression3 + " equals: " + calculator.evaluatePostfix(expression3));
    }
}
