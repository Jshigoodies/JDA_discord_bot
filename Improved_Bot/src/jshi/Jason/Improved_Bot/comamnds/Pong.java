package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Pong implements Command{
	
	private String name;
	private String description;
	
	public Pong(){
		name = "ping";
		description = "Getting the latency";
	}
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public void run(Message message, String[] args){ //executes here
		message.getChannel().sendMessage("pong!").queue();
	}
	
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}

}
