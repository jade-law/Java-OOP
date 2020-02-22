//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
public class NumberSequences {
    public static void main(String[] args) {
        String question = "Enter the first character of the sequence to generate\n(C)ollatz, (F)ib, or (E)xit: ";
        System.out.print(question);
        Scanner scan = new Scanner(System.in);
        String seq = scan.next();
        while (!seq.equals("E")) {
            if (seq.equals("C")) {
                System.out.print("Enter the starting number (1 - 100): ");
                int startNum = scan.nextInt();
                int num = startNum;
                int steps = 0;
                System.out.print("\nCollatz Sequence: " + startNum + " ");
                while (num != 1) {
                    if (num % 2 == 1) {
                        num *= 3;
                        num += 1;
                    } else {
                        num /= 2;
                    }
                    steps += 1;
                    System.out.print(num + " ");
                }
                System.out.print("\nNumber of steps: " + steps + "\n");
            } else if (seq.equals("F")) {
                System.out.print("Enter the length of the desired fib sequence (1 - 40): ");
                int len = scan.nextInt();
                int prevNum = 0;
                int curNum = 1;
                int tempNum;
                System.out.print("\nFib Sequence: " + prevNum + " ");
                while (len - 1 > 0) {
                    tempNum = curNum;
                    curNum += prevNum;
                    prevNum = tempNum;
                    System.out.print(curNum + " ");
                    len -= 1;
                }
                System.out.print("\n");
            }
            System.out.print("--------------------");
            System.out.print("\n" + question);
            seq = scan.next();
        }
        System.out.print("--------------------\n");
    }
}