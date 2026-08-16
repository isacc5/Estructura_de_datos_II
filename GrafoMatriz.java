public class GrafoMatriz {

    private int[][] matriz;
    private int cantidadVertices;

    public GrafoMatriz(int capacidad) {
        matriz = new int[capacidad][capacidad];
        cantidadVertices = 0;
    }

    public void agregarVertice() {

        if (cantidadVertices >= matriz.length) {
            System.out.println("No se pueden agregar más vértices.");
            return;
        }

        cantidadVertices++;

        System.out.println(
            "Vértice " + cantidadVertices + " agregado correctamente."
        );
    }

    public void agregarArista(int v1, int v2) {

        if (v1 <= 0 || v2 <= 0 ||
            v1 > cantidadVertices || v2 > cantidadVertices) {

            System.out.println("Error: uno de los vértices no existe.");
            return;
        }

        if (v1 == v2) {
            System.out.println(
                "Error: no se permiten aristas de un vértice consigo mismo."
            );
            return;
        }

        if (matriz[v1 - 1][v2 - 1] == 1) {
            System.out.println("La arista ya existe.");
            return;
        }

        matriz[v1 - 1][v2 - 1] = 1;
        matriz[v2 - 1][v1 - 1] = 1;

        System.out.println(
            "Arista " + v1 + " - " + v2 + " agregada correctamente."
        );
    }

    public boolean existeArista(int v1, int v2) {

        if (v1 <= 0 || v2 <= 0 ||
            v1 > cantidadVertices || v2 > cantidadVertices) {

            return false;
        }

        return matriz[v1 - 1][v2 - 1] == 1;
    }

    public void mostrarMatriz() {

        System.out.println("\nMatriz de Adyacencia:");

        System.out.print("    ");

        for (int i = 1; i <= cantidadVertices; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int i = 0; i < cantidadVertices; i++) {

            System.out.print((i + 1) + "   ");

            for (int j = 0; j < cantidadVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }
}