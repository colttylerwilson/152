package finalProject;

import java.util.Scanner;
import java.util.Stack;

public class StackIt {
	Scanner in;

	public static void main(String[] args) throws StackError {
		StackIt i = new StackIt();
		i.run();
		/*
		 * Assignments.testMap.put("a", "1"); String input = "12"; ExprNode e =
		 * new ExprNode(); ExprNode d = e.parse(input); System.out.println(
		 * "Final: " + e.getFinal(d)); String input1 = "2+2"; String input2 =
		 * "1+1"; ExprNode e = new ExprNode(); ExprNode d = e.parse(input1);
		 * ExprNode t = e.parse(input2); String input3 = e.getFinal(d) + "+" +
		 * e.getFinal(t); System.out.println(input3); ExprNode dt =
		 * e.parse(input3); System.out.println("Final: " + e.getFinal(dt));
		 */
	}

	public StackIt() {
		in = new Scanner(System.in);
	}

	public void run() throws StackError {
		while (true) {
			readInput();
		}
	}

	public void readInput() throws StackError {
		String input = in.nextLine();
		String delims = "[ ]+";
		String[] tokens = input.split(delims);
		System.out.println("Tokens length: " + tokens.length);
		String firstToken = tokens[0];
		if (Character.isLetter(firstToken.charAt(0))) {
			if (Assignments.getAssignment(firstToken) != null && tokens.length == 1) {
				Assignments.assign(firstToken);
			}

			else if (tokens.length > 2) {
				ExprNode e = new ExprNode();
				ExprNode d = e.parse(tokens[2]);
				Assignments.testMap.put(firstToken, Double.toString(e.getFinal(d)));
			} else {
				ExprNode e = new ExprNode();
				ExprNode d = e.parse(input);
				System.out.println(e.getFinal(d));
			}
		} else {
			ExprNode e = new ExprNode();
			ExprNode d = e.parse(input);
			System.out.println(e.getFinal(d));
		}
	}
}