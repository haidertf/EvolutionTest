package co.com.epx.certification.userInterface.usuarioParticularUI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CrearUsuarioParticularUI {

    public static final Target MNU_PERSONALIZAR = Target.the("producto a seleccionar").located(By.xpath("//span[contains(text(),'Personalizar')][1]"));
    public static final Target BTN_PARTICULARES = Target.the("menu para el menu Particulares").located(By.xpath("//*[@id='foo_bar_13_lbOpcion_1']"));
    public static final Target BTN_NUEVO_CONTACTO = Target.the("botón para agregar nuevo contacto").located(By.xpath("//*[@id='MainContent_btnNuevoContacto']"));
    public static final Target MNU_TIPO_IDETIFICACION = Target.the("menu Tipo de Identificacion").located(By.xpath("//*[@id='TipoIdentificacion_chosen']/a"));
    public static final Target TXT_TIPO_IDETIFICACION = Target.the("ingresar tipo de identicicaion").located(By.xpath("//*[@id='TipoIdentificacion_chosen']/div/div/input"));
    public static final Target TXT_NUMERO_IDENTIFICACION = Target.the("ingresar numero de identificacion").located(By.id("txtIdentificacion"));
    public static final Target TXT_PRIMER_NOMBRE = Target.the("ingresar primer nombre").located(By.xpath("//*[@id='txtNombreContacto']"));
    public static final Target TXT_PRIMER_APELLIDO = Target.the("ingresar segundo apellido").located(By.xpath("//*[@id='txtPrimerApellido']"));
    public static final Target TXT_ESTRATO = Target.the("ingresar estrato").located(By.xpath("//*[@id='MainContent_wucCustomDataContact_rpIndices_txtData_0']"));
    public static final Target BTN_GUARDAR = Target.the("botón guardar").located(By.xpath("//*[@id='MainContent_btnGuardarContacto']"));
    public static final Target MNS_CREACION_USUARIO_EXITOSO = Target.the("mensaje creacion exitoso").located(By.xpath("//*[@id='gritter-item-1']/div[2]/div[2]/p"));

}
