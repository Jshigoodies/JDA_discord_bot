package jshi.Jason.Improved_Bot.comamnds;

import java.util.List;

import net.dv8tion.jda.api.entities.Message;

public class Clear implements Command{
	
	private String name;
	
	public Clear()
	{
		name = "clear";
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void run(Message message, String[] args)
	{
		if(args.length < 2)
		{
			message.getChannel().sendMessage("clear <number>").queue();
			return;
		}
		else
		{
			try {
				List<Message> messages = message.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
				for(int i = 0; i < messages.size(); i++)
				{
					messages.get(i).delete().queue();
				}
			}
			catch(Exception e)
			{
				message.getChannel().sendMessage("error").queue();
				e.printStackTrace();
			}
		}
	}
}
