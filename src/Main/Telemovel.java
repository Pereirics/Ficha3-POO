package Main;

import java.util.Arrays;
import java.util.Objects;

public class Telemovel {

    // Variáveis de instância
    private String marca;
    private String modelo;
    private int[][] resolucao;
    private double mensagensArm;
    private double fotosArm;
    private double appsArm;
    private double totalOcupado;
    private int numFotos;
    private int numApps;
    private String[] nomeApps;

    // Construtor por omissão
    public Telemovel () {
        this.marca = "";
        this.modelo = "";
        this.resolucao = new int[1][1];
        this.mensagensArm = 0;
        this.fotosArm = 0;
        this.appsArm = 0;
        this.totalOcupado = 0;
        this.numFotos = 0;
        this.numApps = 0;
        this.nomeApps = new String[0];
    }

    // Construtor parametrizado
    public Telemovel (String marca, String modelo, int[][] resolucao, double mensagensArm, double fotosArm, double appsArm, double totalOcupado, int numFotos, int numApps, String[] nomeApps) {
        this.marca = marca;
        this.modelo = modelo;
        this.resolucao = resolucao;
        this.mensagensArm = mensagensArm;
        this.fotosArm = fotosArm;
        this.appsArm = appsArm;
        this.totalOcupado = totalOcupado;
        this.numFotos = numFotos;
        this.numApps = numApps;
        this.nomeApps = nomeApps;
    }

    // Construtor de cópia
    public Telemovel (Telemovel t) {
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.resolucao = t.getResolucao();
        this.mensagensArm = t.getMensagensArm();
        this.fotosArm = t.getFotosArm();
        this.appsArm = t.getAppsArm();
        this.totalOcupado = t.getTotalOcupado();
        this.numFotos = t.getNumFotos();
        this.numApps = t.getNumApps();
        this.nomeApps = t.getNomeApps();
    }

    // Métodos de instância
    private int getNumFotos() {
        return this.numFotos;
    }

    private String[] getNomeApps() {
        return this.nomeApps;
    }

    private int getNumApps() {
        return this.numApps;
    }

    private double getTotalOcupado() {
        return this.totalOcupado;
    }

    private double getAppsArm() {
        return this.appsArm;
    }

    private double getFotosArm() {
        return this.fotosArm;
    }

    private double getMensagensArm() {
        return this.mensagensArm;
    }

    private int[][] getResolucao() {
        return this.resolucao;
    }

    private String getModelo() {
        return this.modelo;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setResolucao(int[][] resolucao) {
        this.resolucao = resolucao;
    }

    public void setAppsArm(double appsArm) {
        this.appsArm = appsArm;
    }

    public void setFotosArm(double fotosArm) {
        this.fotosArm = fotosArm;
    }

    public void setMensagensArm(double mensagensArm) {
        this.mensagensArm = mensagensArm;
    }

    public void setNomeApps(String[] nomeApps) {
        this.nomeApps = nomeApps;
    }

    public void setNumApps(int numApps) {
        this.numApps = numApps;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public void setTotalOcupado(double totalOcupado) {
        this.totalOcupado = totalOcupado;
    }

    public String toString () {
        return  "Telemóvel{" +
                "Marca: " + this.marca +
                ", Modelo: " + this.modelo +
                ", Resolução: " + Arrays.toString(this.resolucao) +
                ", Armazenamento Mensagens: " + this.mensagensArm +
                ", Armazanamento Fotos: " + this.fotosArm +
                ", Armazenamento Apps: " + this.appsArm +
                ", Total ocupado: " + this.totalOcupado +
                ", Numero de fotos: " + this.numFotos +
                ", Numero de apps: " + this.numApps +
                ", Nomes de apps: " + Arrays.toString(this.nomeApps) +
                "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Telemovel telemovel = (Telemovel) o;
        return Double.compare(telemovel.getMensagensArm(), getMensagensArm()) == 0 && Double.compare(telemovel.getFotosArm(), getFotosArm()) == 0 && Double.compare(telemovel.getAppsArm(), getAppsArm()) == 0 && Double.compare(telemovel.getTotalOcupado(), getTotalOcupado()) == 0 && getNumFotos() == telemovel.getNumFotos() && getNumApps() == telemovel.getNumApps() && Objects.equals(getMarca(), telemovel.getMarca()) && Objects.equals(getModelo(), telemovel.getModelo()) && Arrays.deepEquals(getResolucao(), telemovel.getResolucao()) && Arrays.equals(getNomeApps(), telemovel.getNomeApps());
    }

    public boolean existeEspaco (int numeroBytes) {
        double disp = this.mensagensArm + this.fotosArm + this.appsArm - this.totalOcupado;
        return disp - numeroBytes > 0;
    }

    public void instalaApp (String nome, int tamanho) {
        if (existeEspaco(tamanho)) {
            String[] novo = Arrays.copyOf(this.nomeApps, this.nomeApps.length+1);
            novo[this.nomeApps.length] = nome;
            this.nomeApps = novo;
            this.numApps++;
            this.totalOcupado += tamanho;
        }
    }

    public void recebeMsg (String msg, int tamanho) {
        if (existeEspaco(tamanho)) {
            this.totalOcupado += tamanho;
        }
    }

    public double tamMedioApps () { // O enunciado estatodo mal feito, faltam bastantes variaveis de instancia ou ent&atilde;o esta muito mal explicado
        return 0;
    }
}
