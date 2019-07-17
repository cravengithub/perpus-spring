/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.amikom.perpus.dao;

import edu.amikom.perpus.domain.Buku;
import java.util.List;

/**
 *
 * @author utama
 */
public interface BukuDao {

    public void save(Buku buku);

    public void update(Buku buku);

    public void delete(Buku buku);

    public Buku load(int id);

    public List<Buku> load();

    public List<Buku> load(Buku buku);
}
