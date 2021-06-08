package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;

public class Pong implements Command{
	
	String name;
	
	public Pong(){
		name = "ping";
	}
	public String getName(){
		return name;
	}
	
	
	public void run(Message message){ //executes here
		message.getChannel().sendMessage("pong!").queue();
	}

}
