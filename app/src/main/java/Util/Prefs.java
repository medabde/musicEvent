package Util;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

/**
 * Created by Med Abde on 3/22/2018.
 */

public class Prefs {
    SharedPreferences sharedPreferences;

    public Prefs(Activity activity) {
        sharedPreferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public void setCity(String city){
        sharedPreferences.edit().putString("city",city).apply();
    }

    public String getCity(){
        return sharedPreferences.getString("city","paris");
    }


}
