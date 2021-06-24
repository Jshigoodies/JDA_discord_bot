package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
public class Stop implements Command{
	
	private String name;
	private String description;
	
	public Stop()
	{
		name = "stop";
		description = "stop the bot";	
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void run(Message message, String args[])
	{
		message.reply("Shutting Down").queue();
		System.exit(0);
	}
	
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}
}
