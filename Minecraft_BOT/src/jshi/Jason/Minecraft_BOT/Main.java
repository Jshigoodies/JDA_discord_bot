package jshi.Jason.Minecraft_BOT;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter /*implements EventListener*/{
	//ctrl + shift + o --> automatically imports everything
	public static JDA jda;
	private String prefix = ".";
	
	public static void main(String[] args) throws LoginException, InterruptedException
	, IOException {
		//Launch
		File f = new File("token.dat");
		Scanner input = new Scanner(f);
		
		String token = input.nextLine();
		
		jda = JDABuilder.createDefault(token).addEventListeners(new Main()).build(); //wow that is hard to read
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing("ANIME ANIME ANIME"));
		//jda.addEventListener(new Commands());
		jda.addEventListener(new Main());
	}

//	@Override
//	public void onEvent(GenericEvent event) {
//		// TODO Auto-generated method stub
//		if (event instanceof ReadyEvent)
//            System.out.println("API is ready!");
//	}

	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		Message msg = event.getMessage();
		if(msg.getContentRaw().equals("!ping"))
		{
			MessageChannel channel = event.getChannel(); //these are all pretty self explanatory
			long time = System.currentTimeMillis();
			channel.sendMessage("Pong! " + time).queue();		
		}
	}
	
	
}
