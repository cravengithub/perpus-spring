/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.amikom.perpus.controller;

import edu.amikom.perpus.dao.BukuDao;
import edu.amikom.perpus.domain.Buku;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author utama
 */
@Controller
public class BukuController {

    @Autowired
    private BukuDao bukuDao;

    @RequestMapping(value = "/buku", method = RequestMethod.GET)
    public String showSearch(ModelMap map) {
        map.addAttribute("buku", new Buku());
        map.addAttribute("keterangan", "Ini adalah latihan web dengan Spring");
        return "buku/search";
    }

    @RequestMapping(value = "/buku", method = RequestMethod.POST)
    public String searchAction(@ModelAttribute("buku") Buku buku, ModelMap map) {
        map.addAttribute("buku", buku);
        map.addAttribute("bks", bukuDao.load(buku));
        return "buku/search";
    }

    @RequestMapping(value = "/buku/add", method = RequestMethod.GET)
    public String showAdd(ModelMap map) {
        map.addAttribute("buku", new Buku());
        map.addAttribute("flag", "Input");
        return "buku/form";
    }

    @RequestMapping(value = "/buku/edit_{id}", method = RequestMethod.GET)
    public String showEdit(ModelMap map, @PathVariable("id") String idString) {
        map.addAttribute("flag", "update");
        try {
            int id = Integer.parseInt(idString);
            map.addAttribute("buku", bukuDao.load(id));
            map.addAttribute("flag", "Ubah");
            return "buku/form";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/buku.htm";
    }

    @RequestMapping(value = "/buku/add", method = RequestMethod.POST)
    public String addAction(@ModelAttribute("buku") Buku buku) {
        bukuDao.save(buku);
        return "redirect:/buku.htm";
    }

    @RequestMapping(value = "/buku/edit_{id}", method = RequestMethod.POST)
    public String editAction(@ModelAttribute("buku") Buku buku) {
        bukuDao.update(buku);
        return "redirect:/buku.htm";
    }

    @RequestMapping(value = "/buku/delete_{id}", method = RequestMethod.GET)
    public String deleteAction(@PathVariable("id") String idString) {
        try {
            int id = Integer.parseInt(idString);
            Buku buku = bukuDao.load(id);
            bukuDao.delete(buku);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/buku.htm";
    }

    /**
     * @return the bukuDao
     */
    public BukuDao getBukuDao() {
        return bukuDao;
    }

    /**
     * @param bukuDao the bukuDao to set
     */
    public void setBukuDao(BukuDao bukuDao) {
        this.bukuDao = bukuDao;
    }
}
