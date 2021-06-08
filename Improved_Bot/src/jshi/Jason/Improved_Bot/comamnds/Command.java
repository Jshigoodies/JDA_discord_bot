package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;

public interface Command { // what does a general command have?
	
	public default void run(Message message)
	{
		
	}
	
	public default String getName()
	{
		return null;
	}
}
