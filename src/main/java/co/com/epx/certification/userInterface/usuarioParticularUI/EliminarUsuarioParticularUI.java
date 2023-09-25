package co.com.epx.certification.userInterface.usuarioParticularUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EliminarUsuarioParticularUI {

    public static final Target TXT_USUARIO_A_ELIMINAR = Target.the("Introducir texto a buscar").located(By.xpath("//*[@id='MainContent_citiesTabPage_ASPxGridViewNatural_DXSE_I']"));
    public static final Target BTN_ELIMINAR = Target.the("botón para eliminar usuario").located(By.xpath("//*[@id='MainContent_citiesTabPage_ASPxGridViewNatural_cell0_0_ctl01_0']/span"));

}
