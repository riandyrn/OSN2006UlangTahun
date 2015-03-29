import java.io.BufferedInputStream;
import java.util.Scanner;


public class Main {
	
	int N = 0;
	int Q = 0;
	
	String[][] container;
	String[] qContainer;
	private Scanner stdin;
	
	private int putParamOnRange(int param)
	{
		int ret = 0;
		
		if(param <= 1)
		{
			ret = 1;
		}
		else if(param >= 10000)
		{
			ret = 10000;
		}
		else
		{
			ret = param;
		}
		
		return ret;
	}
	
	public void readInput()
	{
		stdin = new Scanner(new BufferedInputStream(System.in));
		
		N = putParamOnRange(stdin.nextInt());
		Q = putParamOnRange(stdin.nextInt());
		
		container = new String[N][2];
		qContainer = new String[Q];
		
		for(int row = 0; row < N; row++)
		{
			container[row][0] = stdin.next().toUpperCase();
			container[row][1] = stdin.next();
		}
		
		for(int qRow = 0; qRow < Q; qRow++)
		{
			qContainer[qRow] = stdin.next().toUpperCase();
		}
	}
	
	private String getTelephoneNumber(String name)
	{
		String ret = "";
		boolean found = false;
		int row = 0;
		
		while(!found && row < N)
		{
			if(name.equals(container[row][0]))
			{
				ret = container[row][1];
				found = true;
			}
			else
			{
				row++;
			}
		}
		
		return ret;
	}
	
	public void processInput()
	{
		for(int row = 0; row < Q; row++)
		{
			System.out.println(getTelephoneNumber(qContainer[row]));
		}
	}
	
	public static void main(String args[])
	{
		Main main = new Main();
		main.readInput();
		main.processInput();
	}
}
