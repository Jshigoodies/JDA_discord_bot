package jshi.Jason.Minecraft_BOT;

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
			
	}
	
    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild g = (Guild) event.getGuild();
        System.out.println("Joined new server "+g.getName());
    }
}
