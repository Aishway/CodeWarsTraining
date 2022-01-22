import java.util.ArrayDeque;
import java.util.Deque;

public class EsolangStick {
    public static void main(String[] args) {
        //Make a custom esolang interpreter for the language Stick. Stick is a simple, stack-based esoteric programming language with only 7 commands.
        //
        //Commands
        //^: Pop the stack.
        //
        //!: Add new element to stack with the value of 0.
        //
        //+: Increment element. 255+1=0.
        //
        //-: Decrement element. 0-1=255.
        //
        //*: Add ascii value of top element to the output stream.
        //
        //[: Skip past next ] if element value is 0.
        //
        //]: Jump back to the command after previous [ if element value is nonzero.
        //
        //Syntax and other info
        //You don't need to add support for nested brackets.
        //Non-command characters should be ignored.
        //Code will always have all brackets closed.
        //Note the highlighted next and previous in the commands reference.
        //Program begins with the top element having the value of 0 and being the only element in the stack.
        //Program ends when command executor reaches the end.
        //Examples
        //Hello, World!
        //'++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++*!'
        //Notes
        //Feel free to comment in the discourse area.
        //Swift versions must throw an error (conforming to the Error Protocol) when abnormal conditions occur.
        //Javascript versions should throw when abnormal conditions occur (like the stack being empty).

        System.out.println(interpret("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++++++++++*!++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++++++++++++++++++++++++++*!+++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++++++++++++*!+++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++*!+++++++++++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++++++++++++*!++++++++++++++++++++++++++++++++++++++++++++*!++" +
                "++++++++++++++++++++++++++++++*!++++++++++++++++++++++++++++++" +
                "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++*!+++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++*!++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++*!++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++*!++++++++++++++++++++++++++++++++++++" +
                "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" +
                "++*!+++++++++++++++++++++++++++++++++*!"));

        System.out.println(interpret("+*-*"));
    }

    public static String interpret(String code) {
        String message = "";
        char[] codeToCharArray = code.toCharArray();
        Deque<Integer> stars = new ArrayDeque<>();
        stars.addFirst(0);

        for (int i = 0; i < codeToCharArray.length; i++) {
            switch (codeToCharArray[i]) {
                case '^':
                    stars.removeFirst();
                    break;
                case '!':
                    stars.addFirst(0);
                    break;
                case '+':
                    stars.addFirst((stars.removeFirst() + 1) % 256);
                    break;
                case '-':
                    stars.addFirst((stars.removeFirst() + 255) % 256);
                    break;
                case '*':
                    message += (char) stars.peek().intValue();
                    break;
                case '[':
                    if (stars.peek() == 0) i = code.indexOf(']', i);
                    break;
                case ']':
                    if (stars.peek() != 0) i = code.lastIndexOf('[', i);
                    break;
            }
        }
        return message;
    }
}


