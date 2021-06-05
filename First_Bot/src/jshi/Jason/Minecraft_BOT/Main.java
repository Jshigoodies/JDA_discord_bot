package jshi.Jason.Minecraft_BOT;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class Main /*implements EventListener*/{
	//ctrl + shift + o --> automatically imports everything
	public static JDA jda;
	private static String prefix = ".";
	
	public static void main(String[] args) throws LoginException, InterruptedException
	, IOException {
		//Launch
		File f = new File("token.dat");
		Scanner input = new Scanner(f);
		
		String token = input.nextLine();
		
		jda = JDABuilder.createDefault(token).addEventListeners(new Commands()).build(); //wow that is hard to read
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing("ANIME ANIME ANIME"));
		//jda.addEventListener(new Commands());
	}
	
	public String getPrefix()
	{
		return prefix;
	}
}
