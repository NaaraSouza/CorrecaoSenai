package br.com.senai.Naara.application.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-05-31T14:54:05.699-0300") // @Generated é usado para marcar o código-fonte que foi gerado. Ele também pode ser usado para diferenciar o código escrito pelo usuário do código gerado em um único arquivo.
@StaticMetamodel(Despesas.class) // @StaticMetamodel permite gerar e referenciar estaticamente os atributos de cada entidade do seu modelo.

public class Despesas_ {
	public static volatile SingularAttribute<Despesas, String> data;
	public static volatile SingularAttribute<Despesas, String> descricao;
	public static volatile SingularAttribute<Despesas, Double> valor;
	public static volatile SingularAttribute<Despesas, Boolean> edit;
	public static volatile SingularAttribute<Despesas, Integer> id;
}
