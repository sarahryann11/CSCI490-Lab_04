package csci490.csci490_lab_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            urlConnection("https://jsonplaceholder.typicode.com/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String urlConnection(String str) throws IOException
    {
        URL url = new URL(str);
        URLConnection connection = url.openConnection();

        InputStreamReader is = new InputStreamReader((connection.getInputStream()));
        BufferedReader br = new BufferedReader(is);
        String newStr = br.readLine();

        Log.i("String", newStr);
        return str;

    }


}
