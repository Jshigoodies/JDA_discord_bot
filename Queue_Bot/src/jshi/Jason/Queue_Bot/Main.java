package jshi.Jason.Queue_Bot;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter{
	
	public static JDA jda;
	public static String prefix = "!";
	
	
	public static void main(String[] args) throws LoginException, InterruptedException, IOException
	{
		File f = new File("token.dat");
		Scanner input = new Scanner(f);
		
		String token = input.nextLine(); //where the token should be
		JDABuilder building = JDABuilder.createDefault(token);
		building.addEventListeners(new Main());
		
		jda = building.build();
		//done building
		
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setActivity(Activity.playing("Next Stduent Please"));
		
		input.close(); // close file
		
	}
	
	//the methods
	public String getPrefix()
	{
		return prefix;
	}
	public void loadCommands()
	{
		
	}
	
	
	
	// Events
	@Override
	public void onReady(ReadyEvent event)
	{
		System.out.println("[The_Waiter]: Waiter is Online");
	}
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		User author = event.getAuthor();
		Message message = event.getMessage();
		String messageString = message.getContentRaw();
		String[] args = messageString.split(" ");
		
		if(author.isBot())
		{
			return;
		}
		if(!(messageString.substring(0, prefix.length()).equals(prefix))) //make sure the prefix is there
		{
			return;
		}
		
		//Need to make a Command class and CommandHelper
	}
	
	
	
	
	
	
	
	
	
	
}
