package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;

public interface Command { // what does a general command have?
	
	public default void run(Message message, String[] args)
	{
		
	}
	
	public default String getName() //command name. ping is a command name
	{
		return null;
	}
}