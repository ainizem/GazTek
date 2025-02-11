package Ventanas;

public class EstadoJuego {
    private int puntos;
    private int tiempoRestante;

    public EstadoJuego(int tiempoInicial) {
        this.puntos = 750; // Comenzar con 750 puntos
        this.tiempoRestante = tiempoInicial;
    }

    public EstadoJuego(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void restarPuntos(int puntos) {
        this.puntos = Math.max(0, this.puntos - puntos); // Evita que sea negativo
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void decrementarTiempo() {
        if (tiempoRestante > 0) {
            tiempoRestante--;
        }
    }
}

