/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author Administrador
 */
public class Cidade {
    private Integer codigo;
    private String nome;
    private String s_estado;
    private Integer n_habitantes;
    private LocalDate d_emancipacao;
    private Double a_total;
    private Integer d_capital;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getS_estado() {
        return s_estado;
    }

    public void setS_estado(String s_estado) {
        this.s_estado = s_estado;
    }

    public Integer getN_habitantes() {
        return n_habitantes;
    }

    public void setN_habitantes(Integer n_habitantes) {
        this.n_habitantes = n_habitantes;
    }

    public LocalDate getD_emancipacao() {
        return d_emancipacao;
    }

    public void setD_emancipacao(LocalDate d_emancipacao) {
        this.d_emancipacao = d_emancipacao;
    }

    public Double getA_total() {
        return a_total;
    }

    public void setA_total(Double a_total) {
        this.a_total = a_total;
    }

    public Integer getD_capital() {
        return d_capital;
    }

    public void setD_capital(Integer d_capital) {
        this.d_capital = d_capital;
    }

    @Override
    public String toString() {
        return "cidade{" + "nome=" + nome + '}';
    }
    
    
    
}
