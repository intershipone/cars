package com.cars.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.cars.externaldata.FuelPrices;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Path("/fuel")
public class FuelService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public FuelPrices getFuelPrices() throws InterruptedException, ExecutionException {
        return FuelPrices.getFuelPrices();
    }
}
