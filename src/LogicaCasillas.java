import java.util.Random;
/**
 * Clase que crea el tablero sobre el que se va a jugar
 */
class LogicaCasillas {

    /**
     * Atributos de la clase
     */
    private static final int filas = 9;
    private static final int columnas = 9;

    /**
     * Se encarga de generar el tablero sobre el que se va a jugar
     * @param tablero Es la matriz sobre la que se juega con cada uno de los
     * números que la conforma
     *
     * Complejidad temporal: Complejidad cuadrática O(N^2) (Método calcular números)
     */
    public void GeneracionDeTablero(int[][] tablero) {
        generarBombas(tablero, 10);
        calcularNumeros(tablero);
    }

    /**
     * Coloca las bombas del juego en posiciones aleatorias dentro de la matriz de
     * juego
     * @param tablero Es la matriz donde se está jugando (tablero de juego)
     * @param bombas El numero de bombas que van sobre el tablero
     *
     * COmplejidad temporal: Complejidad lineal O(N)
     */
    private void generarBombas(int[][] tablero, int bombas) {
        Random random = new Random();

        while (bombas > 0) {
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (tablero[fila][columna] != 9) {
                tablero[fila][columna] = 9;
                bombas--;
            }
        }
    }

    /**
     * Calcula los numeros que van al rededor de cada mina. Primero evalúa si en la casilla
     * existe una mina y si esto es verdadero incrementa en uno el valor de todas las casillas del rededor
     * siempre y cuando estas no sean ya una mina
     * @param tablero Es la matriz de juego (tablero de juego)
     *
     * Complejidad temporal: Complejidad cuadrática O(N^2)
     */
    private void calcularNumeros(int[][] tablero) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == 9) {
                    for (int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (dentroDeLimites(x, y) && tablero[x][y] != 9) {
                            tablero[x][y]++;
                        }
                    }
                }
            }
        }
    }

    /**
     * Se encarga de verificar si la posición que se está pidiendo buscar en la matriz
     * está dentro de los límites de la matriz
     *
     * @param x verifica si la posición dada en filas está dentro de la matriz
     * @param y verifica si la posición dada en columnas está dentro de la matriz
     * @return False or true dependiendo si la posición si está dentro de la matriz
     *
     * Complejidad temporal: Complejidad constante O(1)
     */
    private boolean dentroDeLimites(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }
}