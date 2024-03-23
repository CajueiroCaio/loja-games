package com.generation.lojagames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O atributo nomeProduto é obrigatório!")
    @Size(min = 2, max = 100, message = "O atributo nomeProduto deve conter no mínimo 02 e no máximo 100 caracteres!")
    private String nomeProduto;

    @NotNull(message = "O atributo descricaoDoProduto é obrigatório!")
    @Size(min = 5, max = 255, message = "O atributo descricaoDoProduto deve conter no mínimo 05 e no máximo 255 caracteres!")
    private String descricaoDoProduto;

    @NotNull(message = "Preço é obrigatório!")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0")
    @Digits(integer = 6, fraction = 2, message = "O preço deve ter no máximo 6 dígitos inteiros e 2 fracionários")
    private BigDecimal preco;

    @Size(min = 2, max = 100, message = "O atributo nomeEmpresaDesenvolvedoraProduto deve conter no mínimo 02 e no máximo 100 caracteres!")
    private String nomeEmpresaDesenvolvedoraProduto;

    @NotNull(message = "O atributo dataLancamento é obrigatório!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    @ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoDoProduto() {
        return descricaoDoProduto;
    }

    public void setDescricaoDoProduto(String descricaoDoProduto) {
        this.descricaoDoProduto = descricaoDoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getNomeEmpresaDesenvolvedoraProduto() {
        return nomeEmpresaDesenvolvedoraProduto;
    }

    public void setNomeEmpresaDesenvolvedoraProduto(String nomeEmpresaDesenvolvedoraProduto) {
        this.nomeEmpresaDesenvolvedoraProduto = nomeEmpresaDesenvolvedoraProduto;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
