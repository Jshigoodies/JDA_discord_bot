package jshi.Jason.Improved_Bot.comamnds;

import net.dv8tion.jda.api.entities.Message;

public class Testing implements Command{
	private String name;
	
	public Testing()
	{
		name = "Testing";
	}
	
	@Override
	public void run(Message message, String[] args)
	{
		
	}
	
	@Override
	public String getName()
	{
		return name;
	}

}
