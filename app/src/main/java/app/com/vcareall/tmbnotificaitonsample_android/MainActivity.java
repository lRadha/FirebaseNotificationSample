package app.com.vcareall.tmbnotificaitonsample_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tokenNumber = (TextView) findViewById(R.id.tokenNumber);
		tokenNumber.setText(PreferenceManager.getDefaults(PreferencesConstants.TOKEN, MainActivity.this));
		TextView notificationMessage = (TextView) findViewById(R.id.notificationMessage);
		if (PreferenceManager.getDefaults(PreferencesConstants.MESSAGE, getApplicationContext()) != null) {
			notificationMessage.setText(PreferenceManager.getDefaults(PreferencesConstants.MESSAGE, MainActivity
					.this));
		}
	}
}
