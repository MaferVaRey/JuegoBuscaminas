import java.util.Random;

/**
 *
 */
class LógicaCasillas {
    private static final int filas = 9;
    private static final int columnas = 9;

    public void GeneracionDeTablero(int[][] tablero) {
        generarBombas(tablero, 10);
        calcularNumeros(tablero);
    }

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

    private boolean dentroDeLimites(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }
}