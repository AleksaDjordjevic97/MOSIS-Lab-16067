package rs.elfak.mosis.aleksadjordjevic.myplaces;

import androidx.annotation.NonNull;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class MyPlace
{
    public String name;
    public String description;
    public String longitude;
    public String latitude;
    @Exclude
    public String key;
    public MyPlace(){}

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

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    @NonNull
    @Override
    public String toString()
    {
        return this.name;
    }
}
