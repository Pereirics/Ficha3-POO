package Main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Encomenda {

    // Variáveis de instância
    private String nomeCliente;
    private int nifCliente;
    private String moradaCliente;
    private int numeroEncomenda;
    private LocalDateTime dataEncomenda;
    private LinhaEcomenda[] linhasEncomenda;

    // Construtor por omissão
    public Encomenda() {
        this.nomeCliente = "";
        this.nifCliente = 0;
        this.moradaCliente = "";
        this.numeroEncomenda = 0;
        this.dataEncomenda = LocalDateTime.now();
        this.linhasEncomenda = new LinhaEcomenda[0];
    }

    // Construtor parametrizado
    public Encomenda(String nomeCliente, int nifCliente, String moradaCliente, int numeroEncomenda, LocalDateTime dataEncomenda, LinhaEcomenda[] linhasEncomenda) {
        this.nomeCliente = nomeCliente;
        this.nifCliente = nifCliente;
        this.moradaCliente = moradaCliente;
        this.numeroEncomenda = numeroEncomenda;
        this.dataEncomenda = dataEncomenda;
        this.linhasEncomenda = linhasEncomenda;
    }

    // Construtor cópia
    public Encomenda(Encomenda e) {
        this.nomeCliente = e.getNomeCliente();
        this.nifCliente = e.getNifCliente();
        this.moradaCliente = e.getMoradaCliente();
        this.numeroEncomenda = e.getNumeroEncomenda();
        this.dataEncomenda = e.getDataEncomenda();
        this.linhasEncomenda = e.getLinhasEncomenda();
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public int getNifCliente() {
        return this.nifCliente;
    }

    public String getMoradaCliente() {
        return this.moradaCliente;
    }

    public int getNumeroEncomenda() {
        return this.numeroEncomenda;
    }

    public LocalDateTime getDataEncomenda() {
        return this.dataEncomenda;
    }

    public LinhaEcomenda[] getLinhasEncomenda() {
        return this.linhasEncomenda;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setNifCliente(int nifCliente) {
        this.nifCliente = nifCliente;
    }

    public void setMoradaCliente(String moradaCliente) {
        this.moradaCliente = moradaCliente;
    }

    public void setNumeroEncomenda(int numeroEncomenda) {
        this.numeroEncomenda = numeroEncomenda;
    }

    public void setDataEncomenda(LocalDateTime dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public void setLinhasEncomenda(LinhaEcomenda[] linhasEncomenda) {
        this.linhasEncomenda = linhasEncomenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Encomenda e = (Encomenda) o;
        return Objects.equals(e.nomeCliente, this.nomeCliente) &&
               Objects.equals(e.moradaCliente, this.moradaCliente) &&
               Arrays.equals(e.linhasEncomenda, this.linhasEncomenda) &&
               Objects.equals(e.dataEncomenda, this.dataEncomenda) &&
               (e.nifCliente == this.nifCliente) &&
               (e.numeroEncomenda == this.numeroEncomenda);
    }

    @Override
    public String toString() {
        return "Encomenda{" +
               "\nNome cliente: " + this.nomeCliente +
               "\nNIF cliente: " + this.nifCliente +
               "\nMorada cliente: " + this.moradaCliente +
               "\nNumero cliente: " + this.numeroEncomenda +
               "\nData encomenda: " + this.dataEncomenda +
               "\nLinhas encomenda: " + Arrays.toString(this.linhasEncomenda) +
               "\n}";
    }

    @Override
    public Encomenda clone() {
        return new Encomenda(this);
    }

    public double calculaValorTotal() {
        double total = 0;
        for (LinhaEcomenda linha : this.linhasEncomenda) {
            total += linha.calculaValorLinhaEnc();
        }
        return total;
    }

    public double calculaValorDesconto() {
        double total = 0;
        for (LinhaEcomenda linha : this.linhasEncomenda) {
            total += linha.calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos() {
        int total = 0;
        for (LinhaEcomenda linhaEcomenda: this.linhasEncomenda) {
            total += linhaEcomenda.getQuantidadeEnc();
        }
        return total;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for (LinhaEcomenda linhaEcomenda: this.linhasEncomenda) {
            if (linhaEcomenda.getReferencia().equals(refProduto)) {
                return true;
            }
        }
        return false;
    }

    public void adicionaLinha(LinhaEcomenda linha) {
        LinhaEcomenda[] novo = new LinhaEcomenda[this.linhasEncomenda.length + 1];
        System.arraycopy(this.linhasEncomenda, 0, novo, 0, this.linhasEncomenda.length);
        novo[this.linhasEncomenda.length + 1] = linha;
        this.setLinhasEncomenda(novo);
    }

    public void removeProduto(String refProduto) {
        for (int i = 0; i < this.linhasEncomenda.length; i++) {
            if (this.linhasEncomenda[i].getReferencia().equals(refProduto)) {
                System.arraycopy(this.linhasEncomenda, i+1, this.linhasEncomenda, i, this.linhasEncomenda.length-i);
                break;
            }
        }
    }
}
