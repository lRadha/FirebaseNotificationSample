package app.com.vcareall.tmbnotificaitonsample_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceManager {

	private static SharedPreferences prefs;
	private static Editor mEditor;

	private PreferenceManager(Context context) {
	}

	@SuppressLint("CommitPrefEdits")
	public static Editor getEditor(Context context) {
		prefs = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
		mEditor = prefs.edit();
		return mEditor;
	}

	public static void setDefaults(String key, String value, Context context) {
		prefs = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
		mEditor = prefs.edit();
		mEditor.putString(key, value);
		mEditor.apply();
	}

	public static String getDefaults(String key, Context context) {
		SharedPreferences preferences = android.preference.PreferenceManager.getDefaultSharedPreferences(context);
		return preferences.getString(key, null);
	}
}
