package app.com.vcareall.tmbnotificaitonsample_android;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
	public MyFirebaseMessagingService() {
	}

	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
		mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(mainIntent);
		Log.d("TAG", "From: " + remoteMessage.getFrom());
		if (remoteMessage.getData().size() > 0) {
			Log.d("TAG", "Message data payload: " + remoteMessage.getData());
		}
		if (remoteMessage.getNotification() != null) {
			Log.d("TAG", "Message Notification Body: " + remoteMessage.getNotification().getBody());
			PreferenceManager.setDefaults(PreferencesConstants.MESSAGE, remoteMessage.getNotification().getBody(),
					getApplicationContext());
		}
	}
}
