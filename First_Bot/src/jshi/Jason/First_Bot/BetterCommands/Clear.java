//package jshi.Jason.First_Bot.BetterCommands;
//
//import java.util.List;
//
//import jshi.Jason.First_Bot.Main;
//import net.dv8tion.jda.api.entities.Message;
//import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
//import net.dv8tion.jda.api.hooks.ListenerAdapter;
//
//public class Clear extends ListenerAdapter{
//	
//	public void onGuildMessage(GuildMessageReceivedEvent event)
//	{
//		String[] args = event.getMessage().getContentRaw().split("//s+");
//		
//		
//		if(args[0].equalsIgnoreCase(Main.prefix + "clear"))
//		{
//			if(args.length < 2)
//			{
//				//error
//			}
//			else
//			{
//				try {
//					List<Message> messageDelete = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
//					event.getChannel().deleteMessages(messageDelete).queue();
//				}
//				catch(Exception e)
//				{
//					event.getChannel().sendMessage("Error try again :/");
//					e.printStackTrace();
//				}
//					
//			}
//		}
//	}
//}
// useless