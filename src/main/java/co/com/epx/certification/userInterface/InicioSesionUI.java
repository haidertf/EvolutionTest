package co.com.epx.certification.userInterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://epxstandardcoretesting.azurewebsites.net/")
public class InicioSesionUI extends PageObject {

    public static final Target TXT_NOMBRE_USUARIO = Target.the("Se ingresa el nombre del usuario").located(By.xpath("//*[@id='Login1_UserName_I']"));
    public static final Target TXT_CONTRASENA2 = Target.the("Se ingresa la contraseña").located(By.xpath("//*[@id='Login1_Password']/tbody/tr/td/input[2]"));
    public static final Target TXT_CONTRASENA1 = Target.the("Se ingresa la contraseña").located(By.xpath("//*[@id='Login1_Password']/tbody/tr/td/input[1]"));
    public static final Target BTN_INGRESAR = Target.the("Se da clic en ingresar").located(By.xpath("//*[@id='Login1_btnLogIn']"));
    public static final Target LBL_DOC_PENDIENTES = Target.the("Titulo documentos pendientes").located(By.xpath("//*[@id='main-container']/div[2]/div[2]/div[1]/h1"));
}
