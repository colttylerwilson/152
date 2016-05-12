package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignments {
	static Map<String, String> testMap = new HashMap<String, String>(1000);
	static Scanner in;
	
	
	public Assignments()
	{
		in = new Scanner(System.in);
	}
	
	public static void assign(String input)
	{
		String delims = "[ ]+";
		String[] tokens = input.split(delims);
		String variableName = tokens[0];
		if(testMap.get(variableName) != null && tokens.length < 2)
		{
			print(variableName);
		}
		else
		{
			String value = tokens[2];
			testMap.put(variableName, value);
		}
	}
	
	public static String getAssignment(String variableName)
	{
		return testMap.get(variableName);
	}
	
	public static void print(String variableName)
	{
		System.out.println(testMap.get(variableName));
	}
}
