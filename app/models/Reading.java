package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import utilities.Conversions;

@Entity
public class Reading extends Model
{
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;

    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure)
    {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }

    //-------
    //getters
    //-------
    /**
     * Returns the Reading fields
     */
    public int getReading () { return 0; }
    public int getReadingCode ()
    {
        return code;
    }
    public double getReadingTemperature()
    {
        return temperature;
    }
    public double getReadingWindSpeed()
    {
        return windSpeed;
    }
    public double getReadingWindDirection()
    {
        return windDirection;
    }
    public int getReadingPressure()
    {
        return pressure;
    }
    public double getReadingFahrenheit()
    {
        return fahrenheit();
    }
    public int getBeaufort()
    {
        return beaufort();
    }
    public double fahrenheit()
    {
        return Conversions.convertToFahrenheit(this.temperature);
    }
    public String getWeatherCode()
    {
        return Conversions.convertWeatherCode(this.code);
    }
    public int beaufort()
    {
        return Conversions.convertToBeaufort(this.windSpeed);
    }
    public String getWindDirectionCompass()
    {
        return Conversions.windDirectionCompass(this.windDirection);
    }
    public double getWindChill()
    {
        return Conversions.convertToWindChill(this.temperature, this.windSpeed);
    }
    //-------
    //setters
    //-------
    public void setWindDirection(double windDirection)
    {
        //The windDirection must be between 0 and 360 degrees (inclusive)
        if ((windDirection >= 0) && (windDirection <= 360)){
            this.windDirection = windDirection;
        }
        else {
            this.windDirection = 0;
        }
    }
}