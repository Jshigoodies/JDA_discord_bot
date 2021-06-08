package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;

public class Pong implements Command{
	
	private String name;
	
	public Pong(){
		name = "ping";
	}
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public void run(Message message, String[] args){ //executes here
		message.getChannel().sendMessage("pong!").queue();
	}

}
