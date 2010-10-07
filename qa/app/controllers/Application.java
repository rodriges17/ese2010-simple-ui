package controllers;

import java.util.ArrayList;
import java.util.List;

import models.User;

import play.mvc.*;
import play.test.Fixtures;

public class Application extends Controller {
	
	static List users = new ArrayList<User>();

    public static void index() {

        render(users);
    }

	public static void createUser(){
		String name;
		name = params.get("name");
		
    	User user = new User(name);
    	users.add(user);
    	renderJSON(user);
    }

}