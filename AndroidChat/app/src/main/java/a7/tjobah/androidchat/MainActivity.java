package a7.tjobah.androidchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText txtUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = findViewById(R.id.txtUserName);
    }

    public void onLoginClicked(View v){
        String userName = txtUsername.getText().toString();
        boolean nameIsValid = userName.matches("^\\w{2,9}[a-zA-Z0-9]$");

        if(nameIsValid){
            Log.i("LOGIN","name was valid");
            Intent intent = ChatActivity.createIntent(this, userName);
            startActivity(intent);
        } else{
            Log.i("LOGIN","Not valid");
            Snackbar snackbar = Snackbar.make(txtUsername,
                    "User Name must be 3-10 characters long and alpha numeric only!",
                    Snackbar.LENGTH_LONG);
            snackbar.setDuration(5000);
            snackbar.setAnchorView(txtUsername);
            snackbar.show();
        }
    }
}