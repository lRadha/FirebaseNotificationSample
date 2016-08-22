package app.com.vcareall.tmbnotificaitonsample_android;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
	public MyFirebaseInstanceIDService() {
	}

	@Override
	public void onTokenRefresh() {
		String refreshedToken = FirebaseInstanceId.getInstance().getToken();
		Log.d("TAG", "Refreshed token: " + refreshedToken);
		PreferenceManager.setDefaults(PreferencesConstants.TOKEN, refreshedToken, getApplicationContext());
		Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
		mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(mainIntent);
	}
}
