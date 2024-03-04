package es.udc.sistemasinteligentes;

import es.udc.sistemasinteligentes.busqueda.Estado;

public class CuadradoMagico extends Estado {
    final private int[][] cuadrado;
    final private int n;

    public CuadradoMagico(int[][] matrix) throws IllegalArgumentException {
        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("Matriz no cuadrada");
        }
        this.n = n;
        cuadrado = matrix;
    }
    public int[][] getCuadrado() { return cuadrado; }
    public int get() { return n; }
    public int getSolucion() { return n * (n * n + 1) / 2; }

    public boolean esCuadradoMagico() {
        int solucion = getSolucion();
        int sumaDiagonal1 = 0;
        int sumaDiagonal2 = 0;
        int sumaFila;
        int sumaColumna;

        for (int i = 0; i < n; i++) {
            sumaFila = 0;
            sumaColumna = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += cuadrado[i][j];
                sumaColumna += cuadrado[j][i];
            }
            if (sumaFila != solucion || sumaColumna != solucion) {
                return false;
            }
            sumaDiagonal1 += cuadrado[i][i];
            sumaDiagonal2 += cuadrado[i][n - i - 1];
        }
        if (sumaDiagonal1 != solucion || sumaDiagonal2 != solucion) { return false; }
        return true;
    }

    public static CuadradoMagico completar(CuadradoMagico original) {
        return null;
    }


}
