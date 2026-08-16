public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("     TALLER #1 - ESTRUCTURA DE DATOS II");
        System.out.println("==========================================");

        // =====================================================
        // EJERCICIO 1 - MATRIZ DE ADYACENCIA
        // =====================================================

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("       EJERCICIO 1 - MATRIZ");
        System.out.println("==========================================");

        GrafoMatriz grafoMatriz = new GrafoMatriz(4);

        // Agregar 4 vértices
        grafoMatriz.agregarVertice();
        grafoMatriz.agregarVertice();
        grafoMatriz.agregarVertice();
        grafoMatriz.agregarVertice();

        // Agregar las aristas solicitadas:
        // 1-2, 2-3, 3-4, 4-1, 1-3

        grafoMatriz.agregarArista(1, 2);
        grafoMatriz.agregarArista(2, 3);
        grafoMatriz.agregarArista(3, 4);
        grafoMatriz.agregarArista(4, 1);
        grafoMatriz.agregarArista(1, 3);

        // Mostrar matriz
        grafoMatriz.mostrarMatriz();

        // Consultar si existe la arista 2-4
        System.out.println("\n¿Existe una arista entre 2 y 4?");

        if (grafoMatriz.existeArista(2, 4)) {
            System.out.println("Resultado: TRUE");
        } else {
            System.out.println("Resultado: FALSE");
        }

        // =====================================================
        // EJERCICIO 2 - LISTA DE ADYACENCIA
        // =====================================================
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("       EJERCICIO 2 - LISTA");
        System.out.println("==========================================");
        GrafoLista grafoLista = new GrafoLista();
        grafoLista.agregarVertice("X");
        grafoLista.agregarVertice("Y");
        grafoLista.agregarVertice("Z");
        grafoLista.agregarVertice("W");
        grafoLista.agregarArista("X", "Y");
        grafoLista.agregarArista("Y", "Z");
        grafoLista.agregarArista("Z", "W");
        grafoLista.agregarArista("W", "X");
        grafoLista.agregarArista("Y", "W");
        grafoLista.mostrarGrafo();

        System.out.println("\nGrado del vértice Y: "
                + grafoLista.obtenerGrado("Y"));

        // =====================================================
        // EJERCICIO 3 - GRAFO CONEXO
        // =====================================================

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("       EJERCICIO 3 - GRAFO CONEXO");
        System.out.println("==========================================");

        if (grafoLista.esConexo()) {
            System.out.println("¿El grafo es conexo? TRUE");
        } else {
            System.out.println("¿El grafo es conexo? FALSE");
        }

        // =====================================================
        // VALIDACIONES
        // =====================================================

        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("             VALIDACIONES");
        System.out.println("==========================================");

        System.out.println("\n1. Intentando agregar vértice repetido:");

        grafoLista.agregarVertice("Y");

        System.out.println("\n2. Intentando agregar arista repetida:");

        grafoLista.agregarArista("X", "Y");

        System.out.println("\n3. Intentando agregar arista con vértice inexistente:");

        grafoLista.agregarArista("X", "A");

        System.out.println("\n4. Intentando agregar un vértice consigo mismo:");

        grafoLista.agregarArista("X", "X");

        System.out.println("\n5. Consultando un vértice inexistente:");

        System.out.println(
            "Grado de A: " + grafoLista.obtenerGrado("A")
        );

        System.out.println("\n==========================================");
        System.out.println("          FIN DEL PROGRAMA");
        System.out.println("==========================================");
    }
}