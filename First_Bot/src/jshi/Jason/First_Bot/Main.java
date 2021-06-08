package jshi.Jason.First_Bot;

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
	public static String prefix = "!";
	
	public static void main(String[] args) throws LoginException, InterruptedException
	, IOException {
		//Launch
		File f = new File("token.dat");
		Scanner input = new Scanner(f);
		
		String token = input.nextLine();
		
		JDABuilder building = JDABuilder.createDefault(token);
		building.addEventListeners(new Commands());
		jda = building.build();
		//done building
		
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.getPresence().setActivity(Activity.playing("ANIME ANIME ANIME"));
		//jda.addEventListener(new Commands());
	}
	
}
