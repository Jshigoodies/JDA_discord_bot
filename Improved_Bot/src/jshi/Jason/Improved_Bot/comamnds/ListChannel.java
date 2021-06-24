package jshi.Jason.Improved_Bot.comamnds;

import java.awt.Color;
import java.util.List;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class ListChannel implements Command{
	
	private String name;
	private String description;
	private JDA jda;
	
	private Guild guild;
	private List<TextChannel> guildCh;
	private EmbedBuilder list;
	
	public ListChannel(JDA _jda)
	{
		name = "listchannel";
		description = "lists out all the channels in the server";
		jda = _jda;
		list = new EmbedBuilder();
		list.setColor(Color.GREEN);
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
		channelSetUp();
		if(args.length == 1)
		{
			String channels = "";
			for(int i = 0; i<guildCh.size(); i++)
			{
				channels = channels + guildCh.get(i).getName() + "\n";
			}
			list.setTitle(channels);
			message.getChannel().sendMessage(list.build()).queue();
			//don't need to list.clear();
		}
		if(args.length == 2)
		{
			if(args[1].equalsIgnoreCase("test"))
			{
				int num = -1;
				for(int i = 0; i<guildCh.size(); i++)
				{
					if(guildCh.get(i).getName().equalsIgnoreCase("commands")) // i could put this in a dat file and it will probably solve a lot of problems with this
					{
						num = i;
						break;
					}
				}
				
				if(num != -1)
				{
					guildCh.get(num).sendMessage("look at me, I'm sending into a different channel").queue();
				}
				else
				{
					message.getChannel().sendMessage("ERROR").queue();
				}
			
			}
		}
		
		
	}
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}
	
	
	//methods
	public void channelSetUp()
	{
		guild = jda.getGuildById("772158782758715403");
		guildCh = guild.getTextChannels();
	}

}
