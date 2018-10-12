package tn.esprit.pidev.services;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Action;

@Remote
public interface ActionServiceRemote {
	
		public boolean ajouterAction(Action action);

		List<Action> findAll();

		boolean deleteActionById(int actionId);

		void updateAction(Action action);
		
		List<Action> findAllPast();

		public Map<String, Long> getActionByTypes();
		

	}

