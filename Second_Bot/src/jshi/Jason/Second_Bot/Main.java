package jshi.Jason.Second_Bot;

import java.util.Collections;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;

public class Main extends ListenerAdapter{
	
	public static JDA jda;
	
	public static void main(String[] args) throws LoginException
	{
		String token = "ODQ4OTk2MTg5MTYwMDc5Mzcw.YLUvUQ.7dM_nlcpTOx9ZNeAWpFzGxc9_JU"; //i'm too lazy to put it into a dat file. It's the wrong one, don't bother.
		
		JDABuilder building = JDABuilder.createDefault(token);
		building.setActivity(Activity.playing("Anime"));
		building.addEventListeners(new Main());
		jda = building.build();
		//done building
		
		jda.upsertCommand("ping", "Calculate ping of the bot").queue();
		jda.getPresence().setStatus(OnlineStatus.DO_NOT_DISTURB);
		jda.updateCommands();
	}
	
	@Override
	public void onSlashCommand(SlashCommandEvent event)
	{
		System.out.println("In here");
		if (!event.getName().equals("ping")) return;
		
		event.reply("Pong!").addActionRow(Button.danger("stop:stop", "Button"), Button.secondary("stop:cancel", "Button2")).setEphemeral(true).queue(); //i'm so confused
	}
}
