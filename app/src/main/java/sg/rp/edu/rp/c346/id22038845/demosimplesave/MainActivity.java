package sg.rp.edu.rp.c346.id22038845.demosimplesave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        /*String msg = "No greetings!";
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();*/

        //step 1: obtain the sharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        //step 2: retrieve the saved data from the sharedPreferences
        //with a default value if no matching data
        String msg = prefs.getString("greetings", "No greetings name");
        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
        toast.show();

    }

    @Override
    protected void onPause(){
        super.onPause();
        //step 1: obtain the sharedPreferences instance
        SharedPreferences prefs = getPreferences(MODE_PRIVATE); //stays on the phone, saves non critical information like maybe remember me, username, should not save password or financial info.
        //step 2: create a sharedPreferences editor by calling edit()
        SharedPreferences.Editor prefEdit = prefs.edit();
        //step 3: set a key-value pair in the editor
        prefEdit.putString("greetings", "Hello!");
        //step 4: call commit() to save the changes made to the sharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}