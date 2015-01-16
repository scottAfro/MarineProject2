/**
 * Scott Kennedy
 * Camera Page which allows the user to take picture of 
 * plastic micro - pollutants
 */
package ie.gmit.computing;

import java.io.*;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.view.ViewDebug.IntToString;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class CamerPage extends ActionBarActivity 
{
	private static final int REQUEST_CODE = 1;

	private Camera camObj;
	private ShowCamera showCam;
	private ImageView imageView;
	

	/**
	 * Directly using the Camerma Api 
		public static Camera isCameraAvailiable()
	{
		Camera obj = null;
		try 
		{
			obj = Camera.open();
		} catch (Exception e)
		{
			// TODO: handle exception
		}
		return obj;
	}
	
	private PictureCallback capturedIt  = new PictureCallback()
	{		
		public void onPictureTaken(byte[] data, Camera camera)
		{
			Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			if(bitmap == null)
			{
				Toast.makeText(getApplicationContext(), "not taken", Toast.LENGTH_SHORT).show();
			}
			else
			{
				Toast.makeText(getApplicationContext(), "taken", Toast.LENGTH_SHORT).show();
			}
			camObj.release();
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camer_page);
		imageView = (ImageView) findViewById(R.id.result);
		camObj = isCameraAvailiable();
		showCam = new ShowCamera(this, camObj);
		FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		preview.addView(showCam);
	}
	
	public void snapIt(View view)
	{
		camObj.takePicture(null, null, capturedIt);
	}		
 */
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camer_page);
		imageView = (ImageView)findViewById(R.id.result);
		imageView.setOnClickListener(new OnClickListener()
		{			
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				open();
			}
		});
		
		LocationManager myLocationMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		LocationListener myLocaionLis = new MyLocationListener();
		myLocationMan.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, myLocaionLis);
	}
	
	public void open()
	{
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(intent, 0);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bitmap bp = (Bitmap) data.getExtras().get("data");
		imageView.setImageBitmap(bp);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camer_page, menu);
		return true;
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
	
	/**	 
	 *This is an inner class for the gps location finder	 *
	 */
	public class MyLocationListener implements LocationListener
	{
		@Override	
		public void onLocationChanged(Location local)	
		{	
			local.getLatitude();		
			local.getLongitude();		
			String text = "My Location " + "Latitud = " + local.getLatitude() + "Longitud = " + local.getLongitude();		
			Toast.makeText( getApplicationContext(), text, Toast.LENGTH_SHORT).show();	
		}

		@Override	
		public void onProviderDisabled(String provider)	
		{	
			Toast.makeText( getApplicationContext(),"Gps Disabled",	Toast.LENGTH_SHORT ).show();	
		}

		@Override	
		public void onProviderEnabled(String provider)	
		{	
			Toast.makeText( getApplicationContext(),"Gps Enabled", Toast.LENGTH_SHORT).show();	
		}

		@Override	
		public void onStatusChanged(String provider, int status, Bundle extras)	
		{	
		}

	}// End of Class MyLocationListener 
	
	
}
