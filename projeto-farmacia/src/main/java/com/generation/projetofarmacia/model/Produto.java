package com.generation.projetofarmacia.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Atribua um nome ao produto!")
	@Size(max = 100, message = "O atributo nome deve ter no minimo 05 e no máximo 50 caracteres!")
	private String nome;

	@NotBlank(message = "Faça uma breve descrição do produto!")
	@Size(min = 5, max = 1000, message = "O atributo nome deve ter no minimo 05 e no máximo 1000 caracteres!")
	private String descricao;

	@NotNull(message = "Coloque a quantidade disponível na loja!")
	private Integer quantidade;

	@NotBlank
	@Size
	private String fabricante;

	@NotNull(message = "Por favor, insira o valor do produto!")
	@Positive
	private BigDecimal preco;
	
	// Relacionamento com Categoria
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	
	// Get and Set - Categoria
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// Métodos Getters and Setters - Produto
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}