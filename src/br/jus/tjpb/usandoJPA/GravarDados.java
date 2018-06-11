package br.jus.tjpb.usandoJPA;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jus.tjpb.usandoJPA.entity.Exemplo;

public class GravarDados {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("exemplos");
		EntityManager manager = factory.createEntityManager();
		
		Exemplo e;
		
		for (int i = 3; i < 13; i++) {
			e = new Exemplo();
			e.setDescricao("Exemplo "+i);
			e.setFinalizado(true);
			e.setDataFinalizacao(Calendar.getInstance());
			
			manager.getTransaction().begin();
			manager.persist(e);
			manager.getTransaction().commit();
		}
		
		manager.close();
		factory.close();
	}

}
