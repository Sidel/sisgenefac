
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String elemento = "null";
        System.out.println("elemento:" + elemento);
        System.out.println("iguales:" + ("null".equals(elemento)));
        String elementoRetorna = "null".equals(elemento) ? "" : elemento;
        System.out.println("iguales(2):" + (null == elemento));
        System.out.println("elementoRetorna:" + elementoRetorna);
        
        
//        String subCadenaExito = "{\"success\":true,\"idPregunta\":";
        
        String cadenaExito = "{\"success\":true,\"idPregunta\":";
        String resultGuard = "{\"success\":true,\"idPregunta\":481}";

        int longitud = resultGuard.length();
        System.out.println("longitud:" + longitud);
        String subResultGuard = resultGuard.substring(0, 29);
        
        System.out.println("cadenaExito > " + cadenaExito);
        System.out.println("subResultGuard > " + subResultGuard);
        
        boolean iguales = cadenaExito.equals(subResultGuard);
        System.out.println("iguales? " + iguales);
        if ( iguales ) {
            String idPreg = resultGuard.substring(29, 30 + (longitud - 30 -1) );
            int idPregunta = Integer.parseInt(idPreg);
            System.out.println("idPregunta:" + idPregunta);
        }
        
        
        
//        String concatenado = "Tenis%2$Voley%1$Basketball%1$Soccer%2";
//        String separador = "\\$";
//        int numeroElementos = 4;
//        String[] elementos = getSeparateString(concatenado, separador, numeroElementos);
//        for (String elemento : elementos) {
//            System.out.println("elemento:" + elemento);
//        }
        
        
//        List<String> lista = new ArrayList();
//        lista.add("3");
//        lista.add("4");
//        System.out.println("N° elementos:" + lista.size());
//        lista.remove("3");
//        System.out.println("n° elemen:" + lista.size());
        
        String[] valoresRptasMixtas = {"3", "4"};
        List<String> lstRptasMixtas = vectorStringToArrayList(valoresRptasMixtas);
        
        int i = 0;
        while ( !lstRptasMixtas.isEmpty() ) {
            String valorRptaMixta = lstRptasMixtas.get(i);
            for ( int opcion = 0; opcion < 20; opcion++ ) {
                String opc = String.valueOf(opcion);
                if ( valorRptaMixta.equals(opc) ) {
                    System.out.println("rpta:" + opc);
                    lstRptasMixtas.remove(valorRptaMixta);
                    break;
                }
            }
            if ( lstRptasMixtas.isEmpty() ) {
                break;
            }
        }
    }
    
    private static List<String> vectorStringToArrayList(String[] vector) {
        List<String> lst = new ArrayList<String>();
        for ( int i = 0; i < vector.length; i++ ) {
            lst.add(vector[i]);
//            System.out.println("elem:" + lst.get(i));
        }
        return lst;
    }
    
    private static String[] getSeparateString( String concatenado, String separador, int numeroElementos ) {
//        System.out.println("concatenado:" + concatenado);
//        System.out.println("separador:" + separador);
//        System.out.println("numElementos:" + numeroElementos);
        String[] separados = concatenado.split(separador);
        for ( String separado : separados ) {
//            System.out.println("separado:" + separado);
        }
        return separados;
    }
    
}
