package jshi.Jason.Improved_Bot;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import javax.security.auth.login.LoginException;

import jshi.Jason.Improved_Bot.comamnds.Anime;
import jshi.Jason.Improved_Bot.comamnds.Clear;
import jshi.Jason.Improved_Bot.comamnds.Command;
import jshi.Jason.Improved_Bot.comamnds.CommandHelper;
import jshi.Jason.Improved_Bot.comamnds.Help;
import jshi.Jason.Improved_Bot.comamnds.Pong;
import jshi.Jason.Improved_Bot.comamnds.Stop;
import jshi.Jason.Improved_Bot.comamnds.Testing;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
	
	public static JDA jda;
	public static String prefix = "~";
	
	private CommandHelper cmdhelp = new CommandHelper();
	
	public static void main(String[] args) throws LoginException, InterruptedException, IOException
	{
		File f = new File("token.dat");
		Scanner input = new Scanner(f);
		
		String token = input.nextLine();
		JDABuilder building = JDABuilder.createDefault(token);
		building.addEventListeners(new Main());
		jda = building.build();
		//done building
		
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing("ANIME ANIME ANIME"));
		
		input.close();
	}
	
	public String getPrefix()
	{
		return prefix;
	}
	
	public void loadCommands()
	{
		cmdhelp.registerCommand(new Pong());
		cmdhelp.registerCommand(new Stop());
		cmdhelp.registerCommand(new Clear());
		cmdhelp.registerCommand(new Help(cmdhelp));
		cmdhelp.registerCommand(new Anime());
		cmdhelp.registerCommand(new Testing());
	}
	
	// Events
	@Override
	public void onReady(ReadyEvent event)
	{
		loadCommands();
		System.out.println("[Improved_Bot]: First_Bot is Ready");
	}
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event)
	{
		User author = event.getAuthor();
		Message message = event.getMessage();
		String messageString = message.getContentRaw(); //whole string message if I ever need it
		String[] args = messageString.split(" ");
		
		/*
		for(int i = 0; i <args.length; i++)
		{
			System.out.println(args[i]);
		}
		*/
		if(author.isBot())
		{
			return;
		}
		if(!(messageString.substring(0, prefix.length()).equals(prefix)))
		{
			return;
		}
		Command cmd = cmdhelp.getCommand(args[0].toLowerCase().substring(prefix.length()));
		if(cmd == null)
		{
			message.addReaction("❌").queue();
			return;
		}
		try {
			cmd.run(message, args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
