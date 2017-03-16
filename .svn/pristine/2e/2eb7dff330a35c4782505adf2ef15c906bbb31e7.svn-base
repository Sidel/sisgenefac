

import java.util.List;

/**
 *
 * @author Ledis Rivera Changra
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TIPO RPTA MIXTA:
//        String valorRpta = "[01]100";
//        valorRpta = valorRpta.substring(4,  valorRpta.length());
//        System.out.println("valorRpta:" + valorRpta);
//        
//        String variasRptasMixta = "[01]2$4$6";
//        String[] respuestas = rptasMixtas(variasRptasMixta, 3);
//        
//        for (String rpta : respuestas ) {
//            System.out.println("rpta:" + rpta);
//        }
        
        // TIPO RPTA MATRIZ SIMPLE:
        String rptaMatrizSimple = "[01]EN LOS ÚLTIMOS 7 DÍAS ¿TRABAJÓ USTED COMO DEPENDIENTE PARA ALGUNA EMPRESA " +
                "PRIVADA O ESTATAL?%1$Y DURANTE LOS ÚLTIMOS 12 MESES ¿TRABAJÓ UD. COMO DEPENDIENTE PARA ALGUNA EMPRESA PRIVADA O ESTATAL?%2";
//                Retirar [01]
//                Separar por $
//                String array[] = {
//                    EN LOS ÚLTIMOS 7 DÍAS ¿TRABAJÓ USTED COMO DEPENDIENTE PARA ALGUNA EMPRESA PRIVADA O ESTATAL?%1,
//                    Y DURANTE LOS ÚLTIMOS 12 MESES ¿TRABAJÓ UD. COMO DEPENDIENTE PARA ALGUNA EMPRESA PRIVADA O ESTATAL?%1   }
        String[] opciones = rptasMatrizSimple( rptaMatrizSimple, 2 );
//        for (String rpta : opciones ) {
//            System.out.println("rpta:" + rpta);
//        }
        
        for ( String opcion : opciones ) {
            String[] opcionValorMatrizSimple = opcionValorMatrizSimple(opcion, 2);
//	Separar por %
//	String array2[] = { EN LOS ÚLTIMOS 7 DÍAS ¿TRABAJÓ USTED COMO DEPENDIENTE PARA ALGUNA EMPRESA PRIVADA O ESTATAL?,  1 }
            for ( String columna : opcionValorMatrizSimple ) {
                System.out.println("columna:" + columna);
            }
        }
    }
                    
    private static String[] opcionValorMatrizSimple(String valorOpcionRpta, int numeroColumnas) {
        String [] opcionValorMatrizSimple = new String[numeroColumnas];
        opcionValorMatrizSimple = valorOpcionRpta.split("\\%");
        return opcionValorMatrizSimple;
    }
    
    private static String[] rptasMatrizSimple( String variasOpciones, int numeroFilas ) {
        variasOpciones = variasOpciones.substring(4, variasOpciones.length());
        System.out.println("Matriz Simple:" + variasOpciones);
        String[] rptasPorOpciones = new String[numeroFilas];
        rptasPorOpciones = variasOpciones.split("\\$");
        return rptasPorOpciones;
    }
    
    private static String[] rptasMixtas( String variasRptasMixta, int numeroRptas ) {
        variasRptasMixta = variasRptasMixta.substring(4,  variasRptasMixta.length());
        System.out.println("Mixta:" + variasRptasMixta);
        String[] rptasMixtas = new String[numeroRptas];
        rptasMixtas = variasRptasMixta.split("\\$");
        return rptasMixtas;
    }
    
}
