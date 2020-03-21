package io.treehouses.remote.bases;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseGetNetworkRequest extends AsyncTask<String, Void, Void> {
    private ArrayList<String> versionCodes;

    public BaseGetNetworkRequest(ArrayList<String> versionCodes) {
        this.versionCodes = versionCodes;
    }
    @Override
    protected Void doInBackground(String... strings) {
        try {
            InputStream response = new URL("https://www.npmjs.com/package/@treehouses/cli").openStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            Log.d("TAG", responseBody.substring(responseBody.length()-20));
            int lastIndex = 0;

            while(lastIndex != -1){

                lastIndex = responseBody.indexOf("{\"version\":",lastIndex);

                if(lastIndex != -1){
                    lastIndex += 12;
                    versionCodes.add(responseBody.substring(lastIndex, responseBody.indexOf("\"", lastIndex)));
                    Log.d("VERSION ", responseBody.substring(lastIndex, responseBody.indexOf("\"", lastIndex)));
                }
            }
        } catch (Exception e) {
            Log.d("Error Occured", "Link not found");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
