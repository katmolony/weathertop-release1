package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Admin extends Controller
{
    public static void index()
    {
        Logger.info("Rendering Admin");

        // TODO - get list of all readings, and send them to the view
        List<Reading> readings = Reading.findAll();

        render ("admin.html", readings);
    }
}

