package jshi.Jason.Minecraft_BOT;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		Message msg = event.getMessage();
		if(msg.getContentRaw().equals("!ping"))
		{
			MessageChannel channel = event.getChannel(); //these are all pretty self explanatory
			long time = System.currentTimeMillis();
			channel.sendMessage("Pong! " + time);
		}
	}
}
