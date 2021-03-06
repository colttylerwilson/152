package finalProject;

import java.util.Stack;

public class ExprNode {
	static public Stack operatorStack = new Stack();
	static public Stack exprStack = new Stack();
	public String c;
	public ExprNode operand1;
	public ExprNode operand2;

	public ExprNode() {
		c = " ";
		operand1 = null;
		operand2 = null;
	}

	public ExprNode(String num) {
		c = num;
		operand1 = null;
		operand2 = null;
	}

	public ExprNode(String op, ExprNode e1, ExprNode e2) {
		c = op;
		operand1 = e1;
		operand2 = e2;
	}

	public boolean isOperator(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
			return true;
		}
		return false;
	}

	public boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
		}
		return false;
	}

	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	public int precedence(String c) {
		if (c.equals("+") || c.equals("-"))
			return 1;
		else if (c.equals("*") || c.equals("/"))
			return 2;
		return 0;
	}

	public ExprNode parse(String input) throws StackError {
		String c;
		for (int i = 0; i < input.length(); i++) {
			c = input.substring(i, i + 1);
			if (c.equals("(")) {
				operatorStack.push(c);
			} else if (c.equals(".")) {
				ExprNode x = new ExprNode();
				if (exprStack.isEmpty()) {
					System.out.println("Problems");
					System.exit(0);
				}
				x = (ExprNode) exprStack.pop();
				while (input.length() - i >= 2 && isInteger(input.substring(i + 1, i + 2))) {
					c = c + input.substring(i + 1, i + 2);
					i++;
				}
				x.c = x.c + c;
				exprStack.push(x);
			} else if (Character.isLetter(c.charAt(0))) {
				exprStack.push(new ExprNode(Assignments.getAssignment(c)));
			} else if (isInteger(c)) {
				while (input.length() - i >= 2 && isInteger(input.substring(i + 1, i + 2))) {
					c = c + input.substring(i + 1, i + 2);
					i++;
				}
				exprStack.push(new ExprNode(c));
			} else if (isOperator(c)) {
				if (operatorStack.isEmpty()) {
					operatorStack.push(c);
				} else {
					while (precedence((String) operatorStack.peek()) >= precedence(c)) {
						String operator = (String) operatorStack.pop();
						ExprNode e2 = new ExprNode();
						e2 = (ExprNode) exprStack.pop();
						ExprNode e1 = new ExprNode();
						e1 = (ExprNode) exprStack.pop();
						exprStack.push(new ExprNode(operator, e2, e1));
						if (operatorStack.isEmpty()) {
							break;
						}
					}
					operatorStack.push(c);
				}
			} else if (c.equals(")")) {
				while (!((String) operatorStack.peek()).equals("(")) {
					String operator = (String) operatorStack.pop();
					ExprNode e2 = new ExprNode();
					e2 = (ExprNode) exprStack.pop();
					ExprNode e1 = new ExprNode();
					e1 = (ExprNode) exprStack.pop();
					exprStack.push(new ExprNode(operator, e2, e1));
				}
				operatorStack.pop();
			} else {
				throw new StackError("Problem with dat stack of $$$");
			}
		}
		while (operatorStack.size() >= 1) {
			String operator = (String) operatorStack.pop();
			ExprNode e2 = new ExprNode();
			e2 = (ExprNode) exprStack.pop();
			ExprNode e1 = new ExprNode();
			e1 = (ExprNode) exprStack.pop();
			exprStack.push(new ExprNode(operator, e2, e1));
		}
		return (ExprNode) exprStack.pop();
	}

	public String toString() {
		String output = "" + this.c;
		if (this.operand1 != null) {
			output += operand1.toString();
		}
		if (this.operand2 != null) {
			output += operand2.toString();
		}
		return output;
	}

	public void printTree(ExprNode ex) {
		if (ex.operand1 != null) {
			printTree(ex.operand1);
		}
		if (ex.operand2 != null) {
			printTree(ex.operand2);
		}
		System.out.print(ex.c + " ");
	}

	public double getFinal(ExprNode e) {
		if (e.operand1 == null && e.operand2 == null) {
			double d = Double.parseDouble(e.c);
			return d;
		} else {
			if (e.c.equals("+")) {
				return getFinal(e.operand2) + getFinal(e.operand1);
			} else if (e.c.equals("-")) {
				return getFinal(e.operand2) - getFinal(e.operand1);
			} else if (e.c.equals("*")) {
				return getFinal(e.operand2) * getFinal(e.operand1);
			} else if (e.c.equals("/")) {
				return getFinal(e.operand2) / getFinal(e.operand1);
			} else {
				return 0;
			}
		}
	}
}