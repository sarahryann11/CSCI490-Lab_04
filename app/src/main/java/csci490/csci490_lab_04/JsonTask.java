package csci490.csci490_lab_04;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Sarah on 3/13/2018.
 */

public class JsonTask extends AsyncTask<String, Void, String> {
    private TextView text;
    public JsonTask(TextView textView)
    {
        text = textView;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.i("JSON", s);
        text.setText(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url = null;
        URLConnection connection = null;
        InputStreamReader isr = null;

        try {
            url = new URL(strings[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            isr = new InputStreamReader((connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = new BufferedReader(isr);
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while(i < 25){
            try {
                line += br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

        return line;
    }
}