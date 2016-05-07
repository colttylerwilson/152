package finalProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assignment {
	Map<String, Integer> testMap;
	Scanner in;
	
	public Assignment()
	{
		testMap = new HashMap<String, Integer>(1000);
		in = new Scanner(System.in);
	}
	
	public void Run()
	{
		while(true)
		{
			readInput();
		}
	}
	
	public void updateMap(String variableName, int value)
	{
		testMap.put(variableName, value);
	}
	
	public void readInput()
	{
		String input = in.nextLine();
		String delims = "[ ]+";
		String[] tokens = input.split(delims);
		String variableName = tokens[0];
		if(testMap.get(variableName) != null && tokens.length < 2)
		{
			print(variableName);
		}
		else
		{
			int value = Integer.parseInt(tokens[2]);
			updateMap(variableName, value);
		}
	}
	
	public void print(String variableName)
	{
		System.out.println(testMap.get(variableName));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment a = new Assignment();
		a.Run();
	}
}
