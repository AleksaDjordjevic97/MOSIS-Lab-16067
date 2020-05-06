package rs.elfak.mosis.aleksadjordjevic.myplaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    static int NEW_PLACE = 1;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MainActivity.this,EditMyPlaceActivity.class);
                startActivityForResult(i,NEW_PLACE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();

        if (id == R.id.show_map_item)
        {
            Intent i = new Intent(this,MyPlacesMapsActivity.class);
            i.putExtra("state",MyPlacesMapsActivity.SHOW_MAP);
            startActivity(i);
        }
        else if (id == R.id.new_place_item)
        {
            Intent i = new Intent(this,EditMyPlaceActivity.class);
            startActivityForResult(i,NEW_PLACE);
        }
        else if (id == R.id.my_places_list_item)
        {
            Intent myPlacesIntent = new Intent(this,MyPlacesList.class);
            startActivity(myPlacesIntent);
        }
        else if (id == R.id.about_item)
        {
            Intent i = new Intent(this,About.class);
            startActivity(i);
        }
        else if(id == R.id.signout_item)
        {
            mAuth.signOut();
            Intent logoutIntent = new Intent(MainActivity.this, StartActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(logoutIntent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
