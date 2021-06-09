package jshi.Jason.Improved_Bot.comamnds;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
	private Map<String, Command> commands = new HashMap<>();
	
	public void registerCommand(Command cmd)
	{
		commands.put(cmd.getName(), cmd);
	}
	
	public Command getCommand(String command_name)
	{
		return commands.get(command_name);
	}
	
	public Map<String, Command> getMap()
	{
		return commands;
	}
}
