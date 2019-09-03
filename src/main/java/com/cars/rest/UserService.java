package com.cars.rest;

import com.cars.usermanagement.User;
import com.cars.usermanagement.UserManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserService {
    
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean login(User user, @Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        return UserManager.login(user, session);
    }
    
    @Path("/logout")
    @GET
    public boolean logout(@Context HttpServletRequest request){
        HttpSession session = request.getSession();
        return UserManager.logout(session);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getLoggedInUser(@Context HttpServletRequest request) {
        HttpSession session = request.getSession();
        return UserManager.getUserForSession(session);
    }
}
