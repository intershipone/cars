package com.cars.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cars.Leak;


@Path("/leak")
public class LeakService {
    
    @Path("{number}/{size}")
    @GET
    public void leak(@PathParam("number") int number, @PathParam("size") int size) {
        System.out.println(number);
        System.out.println(size);
        Leak.addToCollection(number, size);
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSize() {
        return Long.toString(Leak.getSize());
    }
    
    @DELETE
    public void drainLeak() {
        Leak.drainCollection();
    }
}
