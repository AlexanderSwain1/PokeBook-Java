package com.revature.pokebook.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UrlUtilities
{
	//private static Logger log = Logger.getLogger(UserService.class);
	
	public static String getAtLevel(String url, int level)
	{
		try
		{
			List<String> levels = new ArrayList<String>();
			levels.addAll(Arrays.asList(url.split("/")));
			levels.removeAll(Arrays.asList("", null));
			String result = levels.get(level - 1);
			return isInt(result) ? null : result;
		}
		catch (Exception e)
		{
			//log.error(e.getMessage());
			return null;
		}
	}
	public static Integer getPathParameter(String url)
	{
		try
		{
			String[] levels = url.split("/");
			return Integer.parseInt(levels[levels.length - 1]);
		}
		catch (Exception e)
		{
			//log.error(e.getMessage());
			return null;
		}
	}
	public static boolean isInt(String s)
	{
		try
		{
			Integer.parseInt(s);
			return true;
		}
		catch (Exception e)
		{
			//log.error(e.getMessage());
			return false;
		}
	}
}
