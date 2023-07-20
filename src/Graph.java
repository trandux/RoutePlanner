/**
 * This class represents a route graph.
 *
 * @author upiol
 * @version 1.0
 */

public class Graph {

    private String[] graph;

    /**
     * Creates a new graph.
     * @param graph Edges of the graph in String array.
     */

    public Graph(String[] graph) {

        this.graph = graph;

    }

    /**
     * Analyzes the graph and returns the adjacency matrix of it as int array.
     * @return Adjacency matrix of the graph.
     */

    public int[][] graphToAdjacencyMatrix() {

        int biggestCityIndex = 0;

        int currentCityIndex;

        for (String edge: graph) { // determines the biggest index in the graph

            String[] currentStringEdgeArray = edge.split(" ");

            for (String city: currentStringEdgeArray) {

                currentCityIndex = Integer.parseInt(city);

                if (currentCityIndex > biggestCityIndex) {

                    biggestCityIndex = currentCityIndex;
                }

            }

        }

        int arraySize = biggestCityIndex + 1;

        int[][] returnArray = new int[arraySize][arraySize];

        int startCityIndex = -1;

        int targetCityIndex = -1;

        for (String edge: graph) {

            String[] currentStringEdgeArray = edge.split(" ");

            for (int i = 0; i < 1; i++) {

                startCityIndex = Integer.parseInt(currentStringEdgeArray[i]);

                targetCityIndex = Integer.parseInt(currentStringEdgeArray[i + 1]);

            }

            returnArray[startCityIndex][targetCityIndex] = 1;

        }

        return returnArray;


    }

    /**
     * Returns the identity matrix according to the graph.
     * @return identity matrix.
     */

    public int[][] identityMatrix() {

        int[][] matrix = graphToAdjacencyMatrix();

        int matrixSize = matrix[0].length;

        int[][] returnMatrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {

                if (i == j) { returnMatrix[i][j] = 1; }

            }
        }

        return returnMatrix;
    }

    private static int[][] matrixMultiplication(int[][] firstMatrix, int[][] secondMatrix) {

        int length = firstMatrix.length;

        int[][] returnArray = new int[length][length];

        for (int i = 0; i < length; i++) {

            for (int j = 0; j < length; j++) {

                for (int k = 0; k < length; k++) {

                    returnArray[i][j] += firstMatrix[i][k] * secondMatrix[k][j];

                }

            }

        }

        return returnArray;

    }

    /**
     * Calculates powers of a matrix greater than 1.
     * @param matrix Matrix whose power will be calculated.
     * @param power Power to calculate
     * @return Power of given matrix.
     */

    public static int[][] matrixPower(int[][] matrix, int power) {

        int[][] matrixResult = matrixMultiplication(matrix, matrix);

        for (int i = power; i > 2; i--) {

            matrixResult = matrixMultiplication(matrixResult, matrix);

        }

        return matrixResult;
    }
}
