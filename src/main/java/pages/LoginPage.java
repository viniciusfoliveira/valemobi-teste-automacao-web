package pages;

import helpers.HelperWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.Driver;

import java.util.List;

public class LoginPage {

    @FindBy(id = "cpf")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[.='Entrar na minha conta']")
    private WebElement botaoAcessarMinhaConta;

    @FindBy(xpath = "(//span[.='E-mail ou senha incorretos, revise e tente novamente'])[1]")
    private WebElement mensagemsFalha;

    @FindBy(xpath = "//input[@placeholder='Pesquise por ativos, notícias e muito mais']")
    private WebElement inputPesquisa;


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void preencherCampos(String login, String senha) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(senha);
        botaoAcessarMinhaConta.click();
    }

    public String getMensagemFalha() {
        HelperWait.waitVisible(mensagemsFalha, 60);
        return mensagemsFalha.getText();
    }

    public boolean getInput() {
        try {
            HelperWait.waitVisible(inputPesquisa, 60);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
