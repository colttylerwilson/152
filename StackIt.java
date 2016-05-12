package finalProject;
import java.util.Stack;

public class StackIt {
	
	public static void main(String [] args) throws StackError
	{
		Assignments.testMap.put("a", "12");
		String input = "2-1-1";
		ExprNode e = new ExprNode();
		ExprNode d = e.parse(input);
		System.out.println("Final: " + e.getFinal(d));
		/*
		String input1 = "2+2";
		String input2 = "1+1";
		ExprNode e = new ExprNode();
		ExprNode d = e.parse(input1);
		ExprNode t = e.parse(input2);
		String input3 = e.getFinal(d) + "+" + e.getFinal(t);
		System.out.println(input3);
		ExprNode dt = e.parse(input3);
		System.out.println("Final: " + e.getFinal(dt));
		*/
	}
		
}