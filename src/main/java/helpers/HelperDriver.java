package helpers;

import webdriver.Driver;

public class HelperDriver {

    public static void inicializar(){
        Driver.getDriver().get(HelperLerProperties.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
    }

    public static void finalizar(){
        if(Driver.getDriver() != null){
            Driver.getDriver().quit();
            Driver.setDriver(null);
        }
    }
}
