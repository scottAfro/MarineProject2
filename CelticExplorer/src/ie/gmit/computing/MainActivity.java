package ie.gmit.computing;

import android.support.v7.app.ActionBarActivity;
import android.content.*;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity 
{	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button camButton = (Button) findViewById(R.id.cameraPage);
        camButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) 
            {
                Intent i  = new Intent(MainActivity.this, CamerPage.class);
                startActivity(i);
            }

        });
        
        Button settingButton = (Button) findViewById(R.id.btnSettings);
        settingButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) 
            {
                Intent j  = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(j);
            }

        });
    }
   

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) 
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }   
}
