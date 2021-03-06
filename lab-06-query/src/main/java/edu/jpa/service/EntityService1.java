package edu.jpa.service;

import edu.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.03.15
 */
public class EntityService1 extends EntityService {

    @Override
    public List<Employee> getEmployeesByDepartmentName(String name) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        String queryText = "select e " +
                "from Employee e " +
                "where e.department.name = :name";
        TypedQuery<Employee> query = em.createQuery(queryText, Employee.class);
        query.setParameter("name", name);
        List<Employee> result = query.getResultList();
        em.getTransaction().rollback();
        em.close();
        return result;
    }

    @Override
    public List<DepartmentInfo> getDepartmentsInfo() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        String queryText = "select " +
                "new edu.jpa.service.DepartmentInfo(e.department.name, count(e.department)) " +
                "from Employee e " +
                "group by e.department.name";
        TypedQuery<DepartmentInfo> query = em.createQuery(queryText, DepartmentInfo.class);
        List<DepartmentInfo> result = query.getResultList();
        em.getTransaction().rollback();
        em.close();
        return result;
    }
}
