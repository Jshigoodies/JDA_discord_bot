package jshi.Jason.Improved_Bot.comamnds;

import java.awt.Color;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

public class Help implements Command{
	
	private String name;
	private CommandHelper cmdhelp;
	
	
	public Help(CommandHelper _cmdhelp)
	{
		name = "help";
		cmdhelp = _cmdhelp;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void run(Message message, String[] args)
	{
		EmbedBuilder help = new EmbedBuilder();
		help.setTitle("Help Info");
		help.setDescription("Commands");
		help.setColor(Color.PINK);
		//help.addBlankField(true);
		
		//list of commands
		String allCMD = "";
		for(String key : cmdhelp.getMap().keySet())
		{
			allCMD = allCMD + key + "\n";
		}
		
		help.addField("List", allCMD, false);
		
		message.getChannel().sendTyping().queue();
		message.getChannel().sendMessage(help.build()).queue();
		help.clear(); //need to do this every time
		
	}
}
