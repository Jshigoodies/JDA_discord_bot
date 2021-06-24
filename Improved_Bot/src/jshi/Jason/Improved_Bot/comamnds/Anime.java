package jshi.Jason.Improved_Bot.comamnds;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
//anime <author>
//anime <author> add <name of anime>
public class Anime implements Command {
	private String name;
	private String description;
	private List<EmbedBuilder> mal; //potential use
	private EmbedBuilder error_one;
	private EmbedBuilder error_two;
	public Anime()
	{
		name = "anime";
		description = "getting an anime list - <command_prefix>anime <author>";
		mal = new ArrayList<EmbedBuilder>();
		
		//Error 1
		error_one = new EmbedBuilder();
		error_one.setTitle(":red_circle: anime <author>");
		error_one.setColor(Color.RED);
		
		//Error 2
		error_two = new EmbedBuilder();
		error_two.setTitle(":red_circle: anime <author> add <Name of Anime>");
		error_two.setColor(Color.RED);
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public String getDescription()
	{
		return description;
	}
	
	@Override
	public void run(Message message, String[] args) throws FileNotFoundException
	{
		if(args.length < 2)
		{
			message.getChannel().sendTyping().queue();
			message.getChannel().sendMessage(error_one.build()).queue();
			return;
		}
		if(args.length == 2) // anime jshi
		{
			if(args[1].equalsIgnoreCase("jshi"))
			{
				File f = new File("MyLiteralAnimeList.txt");
				Scanner input = new Scanner(f);
				EmbedBuilder list = new EmbedBuilder();
				list.setTitle("Jshi's Anime List", "https://github.com/Jshigoodies");
				list.setColor(Color.GREEN);
				list.setDescription("Note that some of the manga are animes too");
				list.setFooter("Made by jshi", "https://images7.alphacoders.com/112/thumb-1920-1126216.jpg");
				
				ArrayList<String> wholeList = new ArrayList<String>();
				String wholeWord = "";
				
				while(input.hasNext())
				{
					wholeList.add(input.nextLine());
				}
				Collections.sort(wholeList, String.CASE_INSENSITIVE_ORDER); //sort in alphabetical order
				for(int i = 0; i<wholeList.size(); i++)
				{
					wholeWord = wholeWord + wholeList.get(i) + "\n";
				}
				list.addField("My Anime List", wholeWord, false);
				message.getChannel().sendTyping().queue();
				message.getChannel().sendMessage(list.build()).queue();
			}
			else
			{
				message.getChannel().sendTyping().queue();
				message.getChannel().sendMessage(error_one.build()).queue();
			}
		}
		if(args.length >= 4) //anime jshi add "name"
		{
			if(args[1].equalsIgnoreCase("jshi"))
			{
				if(args[2].equalsIgnoreCase("add"))
				{
					String animeName = "";
					for(int i = 3; i<args.length; i++)
					{
						animeName = animeName + args[i] + " ";
					}
					//add it
					try {
						FileWriter fw = new FileWriter("MyLiteralAnimeList.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.newLine();
				        bw.write(animeName);
				        bw.newLine();
				        bw.close();
				        message.reply(":green_apple: added " + animeName).queue();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					message.getChannel().sendTyping().queue();
					message.getChannel().sendMessage(error_one.build()).queue();
				}
			}
			else
			{
				message.getChannel().sendTyping().queue();
				message.getChannel().sendMessage(error_one.build()).queue();
			}
		}
	}
	
	@Override
	public void runSlash(SlashCommandEvent event)
	{
		
	}
	
}
