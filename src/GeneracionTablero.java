import java.util.Random;
public class GeneracionTablero {
    static int filas = 9, columnas = 9;
    static int[][] tablero = new int[filas][columnas];

    public static void main(String[] args) {
        GeneracionDeTablero(tablero);
        // Mostrar el tablero (solo para fines de demostración)
        imprimirTablero(tablero);
    }

    public static void GeneracionDeTablero(int[][] tablero) {
        // Generar 10 bombas en posiciones aleatorias
        generarBombas(tablero, 10);

        // Calcular y actualizar los números en el tablero
        calcularNumeros(tablero);
    }

    public static void generarBombas(int[][] tablero, int bombas) {
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

    public static void calcularNumeros(int[][] tablero) {
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

    public static boolean dentroDeLimites(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }

    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
}
