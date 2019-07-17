/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.amikom.perpus.dao.impl;

import edu.amikom.perpus.dao.BukuDao;
import edu.amikom.perpus.domain.Buku;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author utama
 */
@Repository
public class BukuDaoImpl implements BukuDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Buku buku) {
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            ss.save(buku);
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Buku buku) {
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            ss.update(buku);
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Buku buku) {
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            ss.delete(buku);
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Buku load(int id) {
        Buku buku = null;
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            buku = (Buku) ss.createCriteria(Buku.class)
                    .add(Restrictions.eq("idBuku", id))
                    .uniqueResult();
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buku;
    }

    @Override
    public List<Buku> load() {
        List<Buku> buku = new LinkedList<Buku>();
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            buku = ss.createCriteria(Buku.class).list();
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buku;
    }

    public List<Buku> load(Buku buku) {
        List<Buku> bks = new LinkedList<Buku>();
        try {
            Session ss = sessionFactory.openSession();
            Transaction tx = ss.beginTransaction();
            if (buku.getJudul().equals("") && buku.getPengarang().equals("")) {
                bks = ss.createCriteria(Buku.class).list();
            } else if (buku.getJudul().equals("")) {
                bks = ss.createCriteria(Buku.class)
                        .add(Restrictions.like("pengarang", "%" + buku.getPengarang() + "%")).list();
            } else if (buku.getPengarang().equals("")) {
                bks = ss.createCriteria(Buku.class)
                        .add(Restrictions.like("judul", "%" + buku.getJudul() + "%")).list();
            } else {
                bks = ss.createCriteria(Buku.class)
                        .add(Restrictions.like("judul", "%" + buku.getJudul() + "%"))
                        .add(Restrictions.like("pengarang", "%" + buku.getPengarang() + "%")).list();
            }
            tx.commit();
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bks;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
