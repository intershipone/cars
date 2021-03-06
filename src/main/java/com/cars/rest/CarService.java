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
import com.cars.Car;
import com.cars.dataloader.CarDataLoader;

@Path("/car")
public class CarService {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") int id) {
        Car car = new CarDataLoader().getCar(id);

        return car;
    }
    
    @Path("/manufacturer/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCarsForManufacturer(@PathParam("id") int id) {
        List<Car> cars = new CarDataLoader().getCarsByManufacturer(id);
        
        return cars;
    }

    @Path("{query}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> searchCars(@PathParam("query") String query) {

        List<Car> cars = new CarDataLoader().getCarsBySearch(query);
        return cars;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCar(Car car) {
        new CarDataLoader().saveCar(car);
    }
}
