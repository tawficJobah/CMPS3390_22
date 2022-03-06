package a4.tjobah.weather;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.lang.reflect.GenericSignatureFormatError;

public class WeatherViewController implements UIBind{
    private APIBridge apiBridge;
    @FXML
    ComboBox comboLoc;
    @FXML
    Label labLatitude, labLongitude;

    @FXML
    protected void onLocationChanged(){
        String loc = comboLoc.getSelectionModel().getSelectedItem().toString();
        apiBridge.GenerateWeatherModel(loc);

    }
    @FXML
    protected void initialize(){
        apiBridge = new APIBridge(this);
    }

    @Override
    public void mapUI(WeatherModel weatherModel) {
        setLabelText(labLatitude,String.valueOf(weatherModel.getLat()));
        setLabelText(labLongitude,String.valueOf(weatherModel.getLon()));
    }
    private void setLabelText(Label label,String val){
        Platform.runLater(()-> label.setText(val));
    }
}