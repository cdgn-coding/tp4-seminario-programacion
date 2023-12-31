package com.tp4.programacion.persistance.hibernate;

import com.tp4.programacion.business.ScheduleService;
import com.tp4.programacion.model.Schedule;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateScheduleRepository implements ScheduleService {
    private EntityManager em;
    private static HibernateScheduleRepository instance;

    public HibernateScheduleRepository(EntityManager em) {
        this.em = em;
    }

    public static HibernateScheduleRepository getInstance() {
        if (instance == null) {
            synchronized (HibernateScheduleRepository.class) {
                if (instance == null) {
                    EntityManager em =  PersistenceUtil.getEntityManagerFactory().createEntityManager();
                    instance = new HibernateScheduleRepository(em);
                }
            }
        }
        return instance;
    }


    @Override
    public void addSchedule(Schedule schedule) {
        em.getTransaction().begin();
        em.persist(ScheduleEntity.fromDomain(schedule));
        em.getTransaction().commit();
    }

    @Override
    public void update(Schedule schedule) {
        em.merge(ScheduleEntity.fromDomain(schedule));
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return em.createQuery("from Schedule", ScheduleEntity.class).getResultList()
                .stream().map(ScheduleEntity::toDomain).toList();
    }
}
