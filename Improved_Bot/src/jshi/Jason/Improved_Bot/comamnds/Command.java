package jshi.Jason.Improved_Bot.comamnds;

import java.io.IOException;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public interface Command { // what does a general command have?
	
	public default void run(Message message, String[] args) throws IOException
	{
		
	}
	
	public default String getName() //command name. ping is a command name
	{
		return null;
	}
	
	public default String getDescription()
	{
		return null;
	}
	
	//I want the existing commands to integrate with the built in slash commands
	public default void runSlash(SlashCommandEvent event)
	{
		
	}
	
}
