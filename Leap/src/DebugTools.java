

public class DebugTools
{
	
	private boolean debug;
	
	public DebugTools()
	{
		debug = false;
	}
	
	public DebugTools(boolean enabled)
	{
		if(enabled == true)
		{
			debug = true;
		}
	}
	
	public void switchDebugState()
	{
		debug = !debug;
	}
	
	public void debugPrint(String str)
	{
		System.out.print(str);
	}
	
	public void debugPrintln(String str)
	{
		debugPrint(str + "\n");
	}
}