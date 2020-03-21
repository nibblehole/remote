package io.treehouses.remote.bases;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;

import java.io.IOException;

public class BaseGetNetworkRequest extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... strings) {
        try {
            Log.d("WEBSITE" , Jsoup.connect(strings[0]).execute().body());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
