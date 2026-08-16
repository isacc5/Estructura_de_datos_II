import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GrafoLista {
    private HashMap<String, List<String>> grafo;
    public GrafoLista() {
        grafo = new HashMap<>();
    }

    public void agregarVertice(String vertice) {

        if (vertice == null || vertice.trim().isEmpty()) {
            System.out.println("Error: el vértice no puede estar vacío.");
            return;
        }

        vertice = vertice.trim();

        if (grafo.containsKey(vertice)) {
            System.out.println("El vértice " + vertice + " ya existe.");
            return;
        }

        grafo.put(vertice, new ArrayList<>());

        System.out.println(
            "Vértice " + vertice + " agregado correctamente."
        );
    }

    public void agregarArista(String v1, String v2) {

        if (!grafo.containsKey(v1) || !grafo.containsKey(v2)) {
            System.out.println(
                "Error: uno de los vértices no existe."
            );
            return;
        }

        if (v1.equals(v2)) {
            System.out.println(
                "Error: no se permiten aristas de un vértice consigo mismo."
            );
            return;
        }
 
        if (grafo.get(v1).contains(v2)) {
            System.out.println(
                "La arista " + v1 + " - " + v2 + " ya existe."
            );
            return;
        }
 
        grafo.get(v1).add(v2);
        grafo.get(v2).add(v1);

        System.out.println(
            "Arista " + v1 + " - " + v2 + " agregada."
        );
    }
  
    public void mostrarGrafo() {

        System.out.println("\nLista de Adyacencia:");

        for (String vertice : grafo.keySet()) {

            System.out.println(
                vertice + " -> " + grafo.get(vertice)
            );
        }
    }

    public int obtenerGrado(String vertice) {
        if (!grafo.containsKey(vertice)) {
            System.out.println(
                "Error: el vértice no existe."
            );
            return -1;
        }
        return grafo.get(vertice).size();
    }
    public boolean esConexo() {
        if (grafo.isEmpty()) {
            return true;
        }
        String inicio = grafo.keySet().iterator().next();
        Set<String> visitados = new java.util.HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {

            String actual = cola.poll();

            // Recorrer los vecinos del vértice actual
            for (String vecino : grafo.get(actual)) {

                if (!visitados.contains(vecino)) {

                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        return visitados.size() == grafo.size();
    }
}