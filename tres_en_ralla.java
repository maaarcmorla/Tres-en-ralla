import java.util.Scanner;

public class TresEnRaya {
    static char[][] tablero = new char[3][3];
    static char jugadorActual = 'X';
    
    public static void main(String[] args) {
        inicializarTablero();
        mostrarTablero();
        while (!hayGanador() && !tableroLleno()) {
            int[] coordenadas = pedirCoordenadas();
            int fila = coordenadas[0];
            int columna = coordenadas[1];
            if (tablero[fila][columna] != ' ') {
                System.out.println("Esa casilla ya está ocupada. Inténtalo de nuevo.");
            } else {
                tablero[fila][columna] = jugadorActual;
                cambiarJugador();
                mostrarTablero();
            }
        }
        if (hayGanador()) {
            System.out.println("¡Felicidades! El jugador " + jugadorActual + " ha ganado.");
        } else {
            System.out.println("El juego ha terminado en empate.");
        }
    }
    
    public static void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    
    public static void mostrarTablero() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
        }
    }
    
    public static int[] pedirCoordenadas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Turno del jugador " + jugadorActual + ".");
        System.out.print("Introduce la fila (0-2): ");
        int fila = scanner.nextInt();
        System.out.print("Introduce la columna (0-2): ");
        int columna = scanner.nextInt();
        return new int[] {fila, columna};
    }
    
    public static void cambiarJugador() {
        jugadorActual = jugadorActual == 'X' ? 'O' : 'X';
    }
    
    public static boolean hayGanador() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2] && tablero[i][0] != ' ') {
                return true;
            }
        }
        // Comprobar columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == tablero[1][j] && tablero[0][j] == tablero[2][j] && tablero[0][j] != ' ') {
                return true;
            }
        }
        // Comprobar diagonal principal
        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && tablero[0][0] != ' ') {
            return true;
        }
        // Comprobar diagonal secundaria
        if (tablero
