 
package com.cars.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cars.Enquiry;
import com.cars.dataloader.EnquiryDataLoader;

@Path("/enquiry")
public class EnquiryService {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Enquiry getEnqury(@PathParam("id") int id) {
        Enquiry enquiry = new EnquiryDataLoader().getEnquiry(id);
        
        return enquiry;
    }
    
    @Path("{carId}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enquiry> getEnquiryForCar(@PathParam("carId") int carId) {
        List<Enquiry> enquiries = new EnquiryDataLoader().getEnquirysForCar(carId);
        
        return enquiries;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveEnquiry(Enquiry enquiry) {
        new EnquiryDataLoader().saveEnquiry(enquiry);
    }
    
}
