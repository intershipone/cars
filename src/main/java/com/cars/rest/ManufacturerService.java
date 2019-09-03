package com.cars.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cars.Manufacturer;
import com.cars.dataloader.ManufacturerDataLoader;

@Path("/manufacturer")
public class ManufacturerService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Manufacturer> getManufacturers() {
        List<Manufacturer> manufacturers = new ManufacturerDataLoader().getManufacturers();
        
        return manufacturers;
    }
    
    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Manufacturer getManufacturer(@PathParam("id") int id) {
        Manufacturer manufacturer = new ManufacturerDataLoader().getManufacturer(id);
        
        return manufacturer;
    }
}
