package finalProject;

import java.util.Scanner;
import java.util.Stack;

public class StackIt {
	Scanner in;
	
	public static void main(String[] args) throws StackError {
		StackIt i = new StackIt();
		i.run();
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