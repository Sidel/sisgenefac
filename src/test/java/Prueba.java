import com.fabrica.sisgenefac.util.Criptografo;
//import com.fabrica.sisgene.vo.UsuarioPorEncuesta;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ledis Rivera Changra
 */
public class Prueba {
    
    public Prueba() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     //@Test
     public void hello() {
         System.out.println("ejecutando pruebas");
         assertEquals("ledis", "ledis");
     }
     
     //@Test
     public void encriptarClave() {
         Criptografo seguridad = new Criptografo();
         String palabraOriginal = "ledis";
         String claveEncriptada = seguridad.encripta(palabraOriginal);
         System.out.println("clave encriptada:" + claveEncriptada);
         
         String claveDesencriptada = seguridad.desencripta(claveEncriptada);
         System.out.println("clave desencriptada:" + claveDesencriptada);
         
         assertEquals(palabraOriginal, claveDesencriptada);
     }
     
     @Test
     public void desencriptarClave() {
         String claveEncriptada = "KiR6K6kM93uDovoOwifE9DvSPDsXwGA0";
         Criptografo seguridad = new Criptografo();
         String claveDesencriptada = seguridad.desencripta(claveEncriptada);
         System.out.println("clave DESENCRIPTADA:" + claveDesencriptada);
         assertEquals("ledis", claveDesencriptada);
     }
     
//     @Test
     public void encriptarClaves() {
         String claves[] = {"ega48789933","scp45556764","cmg48767633","bms48988755","bml48785866",
             "amc48989333","dze45667654","lca77667755","paa48999933","amo38884455",
             "aaa49319333","cve46565432","mbd54455333","lrk48713544","brr48731833",
             "aam49090933","pam48733333","crp47656434","pla48738133","car49833323","aoa49887337"};
         Criptografo seguridad = new Criptografo();
         for ( String clave : claves ) {
             String claveEncriptada = seguridad.encripta(clave);
             System.out.println(claveEncriptada);
         }
     }
     
//     @Test
//     public void reconstruirClaveUsuarioExcel() {
//         
//         UsuarioPorEncuesta usuarioXEncuesta = null;
//         usuarioXEncuesta.setEncClave("gcm71983456");
//         usuarioXEncuesta.setEncApPaterno("GONZALES");
//         usuarioXEncuesta.setEncApMaterno("CASTRO");
//         usuarioXEncuesta.setEncNombres("Mariana Rosali");
//         usuarioXEncuesta.setEncDni("71983456");
//         
//         String claveUsuario = "";
//         String claveReconstruida = 
//            usuarioXEncuesta.getEncApPaterno().toLowerCase().charAt(0) +
//            usuarioXEncuesta.getEncApMaterno().toLowerCase().charAt(1) + 
//            usuarioXEncuesta.getEncNombres().toLowerCase().charAt(2) +
//            usuarioXEncuesta.getEncDni();
//         
//         assertEquals(claveUsuario, claveReconstruida);
//     }
     
//     @Test
     public void parsearRpta() {
         String cadena = "[01]Ramirez$Soto$Gabriel&[02]Sifuentes$Llanos$Adelaida";
         String[] subcadenas = cadena.split("&");
         for (int i=0; i<subcadenas.length; i++) {
             System.out.println("Elemento:" + subcadenas[i]);
         }
     }
}
