package com.cars.rest;

import com.cars.preferences.Preference;
import com.cars.preferences.PreferenceException;
import com.cars.preferences.PreferenceManager;
import com.cars.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/preferences")
public class PreferenceService {
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Preference> getAllPreferences() {
        List<Preference> preferences = null;
        try {
            preferences = PreferenceManager.getAllPreferences(false);
        } catch (PreferenceException ex) {
            Logger.log(ex);
        }
        
        return preferences;
    }
    
    @Path("/all")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveAllPreferences(List<Preference> preferences) {
        try {
            PreferenceManager.setPreferences(preferences);
        } catch (PreferenceException ex) {
            Logger.log(ex);
        }
    }
    
    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void savePreference(Preference preference) {
        try {
            PreferenceManager.updatePreference(preference);
        } catch (PreferenceException ex) {
            Logger.log(ex);
        }
    }
}
