package rs.elfak.mosis.aleksadjordjevic.myplaces;

import androidx.annotation.NonNull;

public class MyPlace
{
    String name;
    String description;
    String longitude;
    String latitude;
    int ID;

    public MyPlace(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public MyPlace(String name)
    {
        this(name,"");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public void setLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    @NonNull
    @Override
    public String toString()
    {
        return this.name;
    }
}
