package jshi.Jason.Improved_Bot.comamnds;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

public class Anime implements Command {
	private String name;
	private List<EmbedBuilder> mal; //potential use
	
	public Anime()
	{
		name = "anime";
		mal = new ArrayList<EmbedBuilder>();
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void run(Message message, String[] args) throws FileNotFoundException
	{
		EmbedBuilder error = new EmbedBuilder();
		if(args.length < 2)
		{
			error.setTitle(":red_circle: anime <author>");
			error.setColor(Color.RED);
			message.getChannel().sendTyping().queue();
			message.getChannel().sendMessage(error.build()).queue();
			error.clear();
			return;
		}
		if(args[1].equalsIgnoreCase("jshi"))
		{
			File f = new File("MyLiteralAnimeList.dat");
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
	}
	
	
	//Creating the whole list


}
