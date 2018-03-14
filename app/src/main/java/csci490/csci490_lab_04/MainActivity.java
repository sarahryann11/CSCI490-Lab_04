package csci490.csci490_lab_04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //name = findViewById(R.id.name);
        getJson("https://jsonplaceholder.typicode.com/users");
    }

    public String getJson(String url)
    {
        name = findViewById(R.id.name);
        JsonTask jt = new JsonTask(name);
        jt.execute(url);
        return url;
    }


    /*
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
    */


}
