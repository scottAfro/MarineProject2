package ie.gmit.computing;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DynamicButton extends ActionBarActivity 
{
		
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//buttonChoices(node);		
	}
	
	public void buttonChoices(Node node)
	{		
		setContentView(R.layout.activity_dynamic_button);
		LinearLayout layout = (LinearLayout) findViewById(R.id.rel_layout);
		
		Button back = (Button) findViewById(R.id.btnBack);
		back.setOnClickListener(new View.OnClickListener()
		{			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
			}
		});		
		
		/*if(node. )
		{
			for (int i = 0; i < n; i++) 
			{
		        Button button = new Button(this);
		        button.setText("Button :"+i);
		        button.setId(i);
		        final int buttonID = button.getId();
	
		        LinearLayout layout = (LinearLayout) findViewById(R.id.rel_layout);
		        layout.addView(button);
		        	        	        
		        button.setOnClickListener(new View.OnClickListener() 
		        {
		            public void onClick(View view) 
		            {
		                Toast.makeText(DynamicButton.this, "Button clicked index = " + buttonID, Toast.LENGTH_SHORT).show();
		            }
		        });
			}      
		}	*/
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dynamic_button, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
