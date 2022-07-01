package Main;

import javax.swing.*;

public class Circulo {

    // Variáveis de intância
    private double x;
    private double y;
    private double raio;

    // Contrutor por omissão
    public Circulo () {
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    // Construtor parametrizado
    public Circulo (double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    // Construtor de cópia
    public Circulo (Circulo c) {
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    // Métodos de instância

    public double getX () {
        return this.x;
    }

    public double getY () {
        return this.y;
    }

    public double getRaio () {
        return this.raio;
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    public void setRaio (double raio) {
        this.raio = raio;
    }

    public void alteraCentro (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calculaArea () {
        return Math.PI * this.raio * this.raio;
    }

    public double calculaPerimetro () {
        return 2 * Math.PI * this.raio;
    }

    public boolean equals(Circulo obj) {
        return ((obj.getX() == this.x && obj.getY() == this.y && obj.getRaio() == this.y) || obj == this);
    }

    public String toString() {
        return "Circulo{" +
                "x=" + this.x +
                ", y=" + this.y +
                ", raio=" + this.raio +
                '}';
    }

    public Circulo clone() {
        return new Circulo(this);
    }
}
