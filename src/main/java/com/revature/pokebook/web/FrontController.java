package com.revature.pokebook.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pokebook.controllers.FollowController;
import com.revature.pokebook.controllers.LikeController;
import com.revature.pokebook.controllers.MessageController;
import com.revature.pokebook.controllers.UserController;
import com.revature.pokebook.utilities.UrlUtilities;

public class FrontController extends HttpServlet
{
	UserController userController = new UserController();
	MessageController messageController = new MessageController();
	FollowController followController = new FollowController();
	LikeController likeController = new LikeController();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        //log.info("Received request: " + request.getRequestURI());

		//API logic
		String controllerName = UrlUtilities.getAtLevel(request.getRequestURI(), 2);
		String actionName = UrlUtilities.getAtLevel(request.getRequestURI(), 3);
		Integer pathParameter = UrlUtilities.getPathParameter(request.getRequestURI());
		
		//Controller Mapping
		response.setContentType("application/json");
		switch (controllerName) 
		{
			case "users":
				if (actionName == null)
				{
					if (pathParameter == null)
						userController.getUsers(request, response);
					else
						userController.getUser(pathParameter, request, response);
				}
				else
					switch (actionName)
					{
						case "create":
							userController.create(request, response);
							break;
						case "update":
							userController.update(request, response);
							break;
						case "delete":
							userController.delete(request, response);
							break;
						case "login":
							userController.login(request, response);
							break;
						case "logout":
							userController.logout(request, response);
							break;
						default:
							response.setStatus(400);
							//log.error("Bad request");
							break;
					}
				break;
			case "messages":
				if (actionName == null)
				{
					if (pathParameter == null)
						messageController.getMessages(request, response);
					else
						messageController.getMessage(pathParameter, request, response);
				}
				else
					switch (actionName)
					{
						case "create":
							messageController.create(request, response);
							break;
						case "update":
							messageController.update(request, response);
							break;
						case "delete":
							messageController.delete(request, response);
							break;
						default:
							response.setStatus(400);
							//log.error("Bad request");
							break;
					}
				break;
			case "follows":
				if (actionName == null)
				{
					if (pathParameter == null)
						followController.getFollows(request, response);
					else
						followController.getFollow(pathParameter, request, response);
				}
				else
					switch (actionName)
					{
						case "create":
							followController.create(request, response);
							break;
						case "update":
							followController.update(request, response);
							break;
						case "delete":
							followController.delete(request, response);
							break;
						default:
							response.setStatus(400);
							//log.error("Bad request");
							break;
					}
				break;
			case "like":
				if (actionName == null)
				{
					if (pathParameter == null)
						likeController.getLikes(request, response);
					else
						likeController.getLike(pathParameter, request, response);
				}
				else
					switch (actionName)
					{
						case "create":
							likeController.create(request, response);
							break;
						case "update":
							likeController.update(request, response);
							break;
						case "delete":
							likeController.delete(request, response);
							break;
						default:
							response.setStatus(400);
							//log.error("Bad request");
							break;
					}
				break;
			default:
				response.setStatus(400);
				//log.error("Bad request");
				break;
		}
	}
}
