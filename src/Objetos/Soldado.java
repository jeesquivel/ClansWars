package Objetos;

public class Soldado extends Personaje {
    public Soldado(String nombre, long vida, long nivel, long nivelMaximo, ESTADO estado, long nivelAparicion, long costo, String apariencia, long golpesSegundo, long campos, long velocidad) {
        super(nombre, vida, nivel, nivelMaximo, estado, nivelAparicion, costo, apariencia, golpesSegundo, campos, velocidad);
    }
}
