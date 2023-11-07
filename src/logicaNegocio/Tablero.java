package logicaNegocio;

/**
 * Clase encargada de generar y disponer para el juego los dos tableros
 * (matrices) que serán usados.
 */
class Tablero {
    private static final int filas = 9;
    private static final int columnas = 9;
    private int[][] tableroOculto = new int[filas][columnas];
    private char[][] tableroVisible = new char[10][10];

    /**
     * Este método genera las dos matrices que corresponden al juego. EL tablero de juego que
     * es generado en la clase logicaNegocio.LogicaCasillas y la segunda que será el tablero visible se generará
     * con la fila 0 (completa) y la columna 0 (completa) con los números correspondientes a cada fila
     * y cada columna respectivamente. El resto de casillas del tablero visible estará compuestas por *
     *
     * Complejidad temporal: complejidad cuadrática O(N^2)
     */
    public void inicializarTableros() {
        LogicaCasillas generador = new LogicaCasillas();
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

    /**
     * Este método se encargará de imprimir en pantalla en tablero oculto.
     *
     * Complejidad temporal: complejidad cuadrática O(N^2)
     */
    public void mostrarTablero() {
        System.out.println("Este es el tablero en el que estás jugando:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + tableroVisible[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * Se encarga de verificar si la posición ingresada está dentro de los límites del tabler
     *
     * @param fila número de filas de la matriz
     * @param columna número de columnas de la matriz
     * @return false or true dependiendo si no está o si está dentro de los límites del tablero
     *
     * COmplejidad temporal: complejidad constante O(1)
     */
    public boolean validarCoordenadas(int fila, int columna) {
        return fila >= 1 && fila <= filas && columna >= 1 && columna <= columnas;
    }

    /**
     * Evalúa la acción que debe hacerse sobre una cailla seleccionada. Si es una mina la marca con una x,
     * si es una casilla con un número la destapa, si es una casilla una casilla vacía llama al método
     * descubrirCasillasVacias, si es una casilla ya destapa 'anula' el movimiento.
     * @param fila filas en la matriz
     * @param columna columnas en la matriz
     * @return true or false dependiendo si la casilla es una mina o no.
     *
     * Colejidad temporal: complejidad cuadrática O(N^2) (descubrirCasillasVacias)
     */
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

    /**
     * Una vez se destapó una casilla vacía se encarga de destapar todas las casillas vacías que hay alrededor.
     * @param fila filas en la matriz
     * @param columna comlumnas en la matriz
     *
     * Complejidad temporal: comlejidad cuadrática O(N^2)
     */
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

    /**
     * Evalua si ya se han descubierto todas las casillas (coordenadas) menos las casillas que contengan
     * una mina
     * @return true si ya se destaparon todas las casillas o false si todavia queda alguna casilla sin
     * destapar que no sea una mina
     *
     * Complejidad temporal: complejidad cuadrática O(N^2)
     */
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

    /**
     * Cuando el jugador desee marcar una mina evalua si la casilla no ha sido marcada ya. EN tal
     * caso de que no haya sido marcada ya reemplaza el * con M.
     * @param fila filas de la matriz
     * @param columna columnas de la matriz
     *
     * Complejidad temporal: Complejidad constante O(1)
     */
    public void marcarMina(int fila, int columna) {
        if (tableroVisible[fila + 1][columna + 1] == '*') {
            tableroVisible[fila + 1][columna + 1] = 'M'; // Marcar mina
        }
    }
}