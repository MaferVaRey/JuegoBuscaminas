class Tablero {
    private static final int filas = 9;
    private static final int columnas = 9;
    private int[][] tableroOculto = new int[filas][columnas];
    private char[][] tableroVisible = new char[10][10];

    public void inicializarTableros() {
        LógicaCasillas generador = new LógicaCasillas();
        generador.GeneracionDeTablero(tableroOculto);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    tableroVisible[i][j] = (char) ('0' + j);
                } else if (j == 0) {
                    tableroVisible[i][j] = (char) ('0' + i);
                } else {
                    tableroVisible[i][j] = '*';
                }
            }
        }
    }

    public void mostrarTablero() {
        System.out.println("Este es el tablero en el que estás jugando:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + tableroVisible[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean validarCoordenadas(int fila, int columna) {
        return fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas;
    }

    public boolean descubrirCasilla(int fila, int columna) {
        if (tableroOculto[fila][columna] == 9) {
            tableroVisible[fila + 1][columna + 1] = 'X'; // Mina marcada
            return true;
        } else if (tableroVisible[fila + 1][columna + 1] != '*') {
            return false;
        } else if (tableroOculto[fila][columna] == 0) {
            descubrirCasillasVacias(fila, columna);
        } else {
            tableroVisible[fila + 1][columna + 1] = (char) (tableroOculto[fila][columna] + '0');
        }
        return false;
    }

    private void descubrirCasillasVacias(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas || tableroVisible[fila + 1][columna + 1] != '*') {
            return;
        }
        tableroVisible[fila + 1][columna + 1] = (char) (tableroOculto[fila][columna] + '0');
        if (tableroOculto[fila][columna] == 0) {
            int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
            for (int i = 0; i < 8; i++) {
                int x = fila + dx[i];
                int y = columna + dy[i];
                descubrirCasillasVacias(x, y);
            }
        }
    }

    public boolean haGanado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tableroVisible[i + 1][j + 1] == '*' && tableroOculto[i][j] != 9) {
                    return false;
                }
            }
        }
        return true;
    }

    public void marcarMina(int fila, int columna) {
        if (tableroVisible[fila + 1][columna + 1] == '*') {
            tableroVisible[fila + 1][columna + 1] = 'M'; // Marcar mina
        }
    }
}