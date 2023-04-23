package steps;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helpers.HelperDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.LoginPage;
import pages.TradeMapPage;
import webdriver.Driver;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    TradeMapPage tradeMapPage = new TradeMapPage();


    public static ExtentTest test;
    public static ExtentReports report;

    @Dado("que eu esteja na tela de home")
    public void queEuEstejaNaTelaDeHome() {
        HelperDriver.inicializar();
    }

    @Quando("preencher os dados com o login invalido")
    public void preencherOsDadosComOLoginInvalido(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps();
        loginPage.preencherCampos(data.get(0).get("login"), data.get(0).get("senha"));

    }

    @Quando("preencher os dados com o login valido")
    public void preencherOsDadosComOLoginValido(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();
        loginPage.preencherCampos(data.get(0).get("login"), data.get(0).get("senha"));

    }

    @Entao("validar mensagem de login valido")
    public void validarMensagemDeLoginValido() {
        Assert.assertTrue(loginPage.getInput());
        tradeMapPage.sairPagina();

    }

    @Entao("validar mensagem de login invalido")
    public void validarMensagemDeLoginInvalido() {
        Assert.assertEquals(loginPage.getMensagemFalha(), "E-mail ou senha incorretos, revise e tente novamente");
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        HelperDriver.finalizar();
    }
}
