package a5.tjobah.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements UIBind{

    private Spinner spinnerLocations;
    private APIBridge apiBridge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.apiBridge = new APIBridge(this, getApplicationContext());
        this.spinnerLocations = findViewById(R.id.spinLocations);

        spinnerLocations.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.i("LOCATION", spinnerLocations.getSelectedItem().toString());
                //apiBridge.GenerateWeatherModel(spinnerLocations.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void mapUI(WeatherModel weatherModel) {

    }
}