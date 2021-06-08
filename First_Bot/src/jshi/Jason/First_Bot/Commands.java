package jshi.Jason.First_Bot;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Invite.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{	
		Message msg = event.getMessage();
		
		MessageChannel channel = event.getChannel(); //these are all pretty self explanatory
		
		if(msg.getContentRaw().equals("!ping"))
		{
			String username = event.getAuthor().getName();
			long time = System.currentTimeMillis();
			channel.sendMessage("Pong! \n" + username + "\n" + time).queue();
			channel.sendMessage(":D").queue();
		}
		
		if(msg.getContentRaw().equals("!kill me"))
		{
			channel.sendMessage("k").queue();
			int year = channel.getTimeCreated().getYear();
			int day = channel.getTimeCreated().getDayOfYear();
			channel.sendMessage("This channel was created in year: " + year + " day: " + day).queue();
		}
		
		if(msg.getContentRaw().equals("fuck"))
		{
			msg.delete().queue();
		}
		
		if(msg.getContentRaw().equals("!embed"))
		{
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Jshi", "https://images2.alphacoders.com/836/thumb-1920-836180.png");
			info.setDescription("Description");
			info.setColor(Color.BLUE);
			info.setImage("https://images6.alphacoders.com/836/thumb-1920-836183.png");
			info.setThumbnail("https://images3.alphacoders.com/836/thumb-1920-836184.png");
			info.addBlankField(true);
			info.addBlankField(true);
			info.addBlankField(true);
			info.addBlankField(true);
			info.addField("name", "box", true);
			info.setFooter("text", event.getMember().getUser().getAvatarUrl());
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
			
	}
	
    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild g = (Guild) event.getGuild();
        System.out.println("Joined new server "+g.getName());
    }
}
