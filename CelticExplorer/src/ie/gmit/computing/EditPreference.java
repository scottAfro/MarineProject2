package ie.gmit.computing;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class EditPreference extends PreferenceActivity
{
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference_settings);
	}
}
