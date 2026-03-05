import java.util.Scanner;
import java.util.Stack;

public class Exam3 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        boolean vaild = false;

        for (int i = 0; i <  s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')' || c == '}' || c == ']'){
                if (stack.isEmpty()){
                    vaild = true;
                    break;
                }

                char top = stack.pop();
                if(c == '(' || c == '{' || c == '[' || c == ')' || c == '}' || c == ']'){
                    vaild = true;
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            vaild = true;
        }

        if(vaild){
            System.out.println("Result: true");
        }else {
            System.out.println("Result: false");
        }
    }
}
