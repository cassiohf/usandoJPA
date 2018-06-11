package br.jus.tjpb.usandoJPA;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jus.tjpb.usandoJPA.entity.Exemplo;

public class BuscarDados {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplos");
		EntityManager manager = factory.createEntityManager();
		
		//Exemplo buscado = manager.find(Exemplo.class, 1L);
		
		List<Exemplo> lista = manager.createQuery("select e from Exemplo as e where e.finalizado=false").getResultList();
		
		for (Exemplo exemplo : lista) {
			System.out.println(exemplo.getDescricao());
		}
		
		manager.close();
		factory.close();

	}

}
