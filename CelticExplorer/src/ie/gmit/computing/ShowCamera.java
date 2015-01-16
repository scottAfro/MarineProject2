package ie.gmit.computing;

import java.io.*;
import android.content.*;
import android.hardware.Camera;
import android.view.*;

public class ShowCamera extends SurfaceView implements SurfaceHolder.Callback
{
	private SurfaceHolder holdMe;
	private Camera theCamera;
	
	public ShowCamera(Context context, Camera camera)
	{
		super(context);
		theCamera = camera;
		holdMe = getHolder();
		holdMe.addCallback(this);
	}
	
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3)
	{
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		// TODO Auto-generated method stub
		try
		{
			theCamera.setPreviewDisplay(holder);
			theCamera.startPreview();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
