package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;
public class Stop implements Command{
	
	private String name;
	
	public Stop()
	{
		name = "stop";
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
}
