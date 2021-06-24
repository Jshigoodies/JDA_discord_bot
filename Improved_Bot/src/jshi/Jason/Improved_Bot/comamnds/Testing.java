package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Testing implements Command{
	private String name;
	private String description;
	
	public Testing()
	{
		name = "testing";
		description = "Testing - no real use";
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public void run(Message message, String[] args)
	{
		message.getChannel().sendMessage("Testing").queue();
	}
	
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}

}
