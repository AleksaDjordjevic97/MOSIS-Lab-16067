package rs.elfak.mosis.aleksadjordjevic.myplaces;

import androidx.annotation.NonNull;

public class MyPlace
{
    String name;
    String description;

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

    @NonNull
    @Override
    public String toString()
    {
        return this.name;
    }
}