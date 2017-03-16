import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexanderwong
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class test {
  
    public test() {
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

    @Test
    public void hello() {    
//    assertEquals("test was unsuccessful", "alex", "alexander");
        assertEquals("led", "ledis");
    }
  
//  @Test
    public void testMultiplicar() {
        System.out.println("multiplicando");
        double numero1 = 3.0;
        double numero2 = 2.0;

        double producto = numero1 * numero2;
        double esperado = 6;
        assertEquals(6.0,esperado, producto);
    }
  
//  @Test
//   public void testEscenario01() {
//       ListaDoble lista = new ListaDoble();
//       // La lista debe estar vacia al inicio
//       assertTrue(lista.isEmpty());
//
//       // Insertemos 5 elementos
//       lista.insertar(100);
//       lista.insertar(50);
//       lista.insertar(200);
//       lista.insertar(-50);
//       lista.insertar(0);
//       assertArrayEquals(lista.toArray(),
//               new int[]{-50,0,50,100,200});
//   }
}
