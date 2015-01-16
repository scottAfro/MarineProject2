package ie.gmit.computing;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends ActionBarActivity
{
	private TextView checkbox;
	private TextView textShip;
	private TextView textName;
	private TextView textAddress;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String Name = "nameKey"; 
	public static final String Ship = "shipKey"; 
	public static final String Email = "emailKey";
	
	SharedPreferences sharedpreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		checkbox = (TextView)findViewById(R.id.checkbox);
		textShip = (TextView)findViewById(R.id.txtShip);
		textName = (TextView)findViewById(R.id.txtName);
		textAddress = (TextView)findViewById(R.id.txtAddress);
		
		sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
		
		 if (sharedpreferences.contains(Name))
	      {
			 textName.setText(sharedpreferences.getString(Name, ""));

	      }
		 if (sharedpreferences.contains(Email))
	      {
			 textShip.setText(sharedpreferences.getString(Ship, ""));

	      }
		 if (sharedpreferences.contains(Email))
	      {
			 textAddress.setText(sharedpreferences.getString(Email, ""));

	      }
	}	
	
	public void run(View view)
	{
	      String n  = textName.getText().toString();	     
	      String e  = textAddress.getText().toString();
	      String s  = textShip.getText().toString();	      
	      
	      Editor editor = sharedpreferences.edit();
	      editor.putString(Name, n);	      
	      editor.putString(Email, e);
	      editor.putString(Ship, s);	      

	      editor.commit(); 

	   }

	
	/*protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		SharedPreferences prefs = getSharedPreferences("key", 0);  //PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor sedt = prefs.edit();
		
		checkbox.setText(new Boolean(prefs.getBoolean("checkbox", false)).toString());		
		textShip.setText(prefs.getString("textShip", " "));
		textName.setText(prefs.getString("textName", " "));
		textAddress.setText(prefs.getString("textAddress", ""));
	}*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) 
		{       
			case R.id.edit_pref:
			startActivity(new Intent(this, EditPreference.class));        
			return true;      
		}  
		return super.onOptionsItemSelected(item);
	}
}
