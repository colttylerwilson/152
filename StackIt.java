package finalProject;
import java.util.Stack;

public class StackIt {
	
	public static void main(String [] args) throws StackError
	{
		String input = "(1/2)+2";
		ExprNode e = new ExprNode();
		ExprNode d = e.parse(input);
		e.printTree(d);
		System.out.println("Final " + e.getFinal(d));
	}
		
}