package a4.tjobah.weather;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.reflect.GenericSignatureFormatError;

public class WeatherViewController implements UIBind{
    private APIBridge apiBridge;
    @FXML
    ComboBox comboLoc;
    @FXML
    Label labLatitude, labLongitude,labHigh,labLow,labCurrent,labFeelsLike,labPressure,labHumidity,
            labWeatherDescription,labWindSpeed;

    @FXML
    ImageView imgWeatherIcon,imgWindDirection;

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
        setLabelText(labHigh,weatherModel.getTempMax() + "ᵒ");
        setLabelText(labLow, weatherModel.getTempMin() + "ᵒ");
        setLabelText(labCurrent,weatherModel.getFeelsLike() + "ᵒ");
        setLabelText(labFeelsLike,weatherModel.getFeelsLike() + "ᵒ" );
        setLabelText(labHumidity,weatherModel.getHumidity() + "%");
        setLabelText(labPressure,weatherModel.getPressure() + "hPa");
        setLabelText(labWeatherDescription, weatherModel.getWeatherDescription());
        imgWeatherIcon.setImage(new Image(weatherModel.getWeatherIcon()));
        setLabelText(labWindSpeed,weatherModel.getWindSpeed() + "MPH");
        imgWindDirection.setRotate(weatherModel.getWindDirection());

    }
    private void setLabelText(Label label,String val){
        Platform.runLater(()-> label.setText(val));
    }
}