package Constructores;

import Objetos.IArma;

public interface IArmaFactoryMethod {
    public IArma crearArma(String tipo, String nombre,
                           long alcance, long danno, long rango, long nivel, long nivelMaximo, long nivelAparicion, String apariencia);
}
