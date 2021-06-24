package jshi.Jason.Improved_Bot.comamnds;

import java.awt.Color;
import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Clear implements Command{
	
	private String name;
	private String description;
	
	public Clear()
	{
		name = "clear";
		description = "delete messages";
	}
	
	@Override
	public String getName() {
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
		EmbedBuilder error = new EmbedBuilder();
		if(args.length < 2)
		{
			error.setTitle(":red_circle: clear <number>");
			error.setColor(Color.RED);
			message.getChannel().sendTyping().queue();
			message.getChannel().sendMessage(error.build()).queue();
			error.clear();
			return;
		}
		else
		{
			try {
				List<Message> messages = message.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
				for(int i = 0; i < messages.size(); i++)
				{
					messages.get(i).delete().submit();
				}
			}
			catch(Exception e)
			{
				error.setTitle(":red_circle: Error unknown");
				error.setColor(Color.RED);
				message.getChannel().sendTyping().queue();
				message.getChannel().sendMessage(error.build()).queue();
				error.clear();
			}
		}
	}
	
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}
}
