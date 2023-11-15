package ifsuldeminas.telefonia.model.entity;

import ifsuldeminas.telefonia.model.entity.comercial.Celular;
import ifsuldeminas.telefonia.model.entity.comercial.Plano;
import ifsuldeminas.telefonia.model.entity.pessoal.Cliente;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Operadora {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;

    //Adicionando a ligação entre Cliente e Operadora
    @OneToMany
    @JoinColumn(name = "operadora_id") // será gerado a chave estrangeira na tabela de Cliente.
    private Set<Cliente> clientetes;

    @OneToMany
    @JoinColumn(name = "operadora_id")
    //Adicionando a ligação entre cliente e Plano
    private Set<Celular> celulares;
    @OneToMany
    @JoinColumn(name = "operadora_id")
    private Set<Plano> planos;

}
