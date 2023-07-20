/**
 * This class serves as entry point for the program and contains main method.
 *
 * <p> This program takes the path to a .txt data of a graph, indexes of start and destination cities and a length as
 * command-line arguments. It calculates the number of paths of the given length between the start city and the
 * destination city based on the graph of the given input file.
 *
 * The result is then displayed on console
 *
 * <p>Usage: java Main [path to the data] [index of start city] [index of destination city] [length]
 *
 * @author upiol
 * @version 1.0
 *
 *
 */

public class Main {

    /**
     * This is the entry point of the program.
     *
     * @param args contains the path to .txt data of the graph, indexes of start and destination cities and length of
     *             searched paths between cities.
     *
     *
     */

    public static void main(String[] args) {

        int startCityIndex = Integer.parseInt(args[1]);

        int targetCityIndex = Integer.parseInt(args[2]);

        int power = Integer.parseInt(args[3]);

        FileLoader firstMap = new FileLoader(args[0]);

        String[] edgesStringArray = firstMap.readFile();

        Graph graph = new Graph(edgesStringArray);

        int[][] adjacencyMatrix = graph.graphToAdjacencyMatrix();

        int[][] resultMatrix = graph.identityMatrix();

        switch(power) {

            case 0:

                break;

            case 1:

                resultMatrix = adjacencyMatrix;

                break;

            default:

                resultMatrix = Graph.matrixPower(adjacencyMatrix, power);

        }

        System.out.println(resultMatrix[startCityIndex][targetCityIndex]);

    }
}