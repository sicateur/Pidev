package com.massconnections.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.massconnections.Domains.Project;

/**
 * Session Bean implementation class ProjectCrudEJB
 */
@Stateless
public class ProjectService implements ProjectServiceRemote,ProjectServiceLocal {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProjectService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addProject(Project p) {
		em.persist(p);
		
	}

	@Override
	public List<Project> getProjects() {
		List<Project> projects = null;
		try{
		projects = em.createQuery("select DISTINCT(p) from Project p LEFT JOIN FETCH p.donations LEFT JOIN FETCH p.projectDocuments where p.state = 1").getResultList();
		}catch(Exception e){
			
		}
		return projects;
	}
	
	@Override
	public List<Project> getProjectsWithDonation() {
		List<Project> projects = null;
		try{
		projects = em.createQuery("select DISTINCT(p) from Project p LEFT JOIN FETCH p.donations LEFT JOIN FETCH p.projectDocuments").getResultList();
		}catch(Exception e){
			
		}
		return projects;
	}
	
	

	@Override
	public Project getById(int id) {
		return em.find(Project.class, id);
	}

	@Override
	public void update(Project p) {
		em.merge(p);
	}

	@Override
	public void delete(Project p) {
		em.detach(em.merge(p));
	}


}
