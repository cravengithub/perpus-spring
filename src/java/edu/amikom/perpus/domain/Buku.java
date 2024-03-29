package edu.amikom.perpus.domain;
// Generated May 19, 2019 11:22:43 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Buku generated by hbm2java
 */
@Entity
@Table(name = "buku")
public class Buku implements java.io.Serializable {

    private Integer idBuku;
    private String isbn;
    private String judul;
    private int jumlahSalinan;
    private int tahun;
    private String penerbit;
    private String pengarang;
    private String ringkasan;
    private Set<DetailTransaksi> detailTransaksis = new HashSet<DetailTransaksi>(0);

    public Buku() {
    }

    public Buku(String isbn, String judul, int jumlahSalinan, String penerbit, String pengarang, String ringkasan) {
        this.isbn = isbn;
        this.judul = judul;
        this.jumlahSalinan = jumlahSalinan;
        this.penerbit = penerbit;
        this.pengarang = pengarang;
        this.ringkasan = ringkasan;
    }

    public Buku(String isbn, String judul, int jumlahSalinan, String penerbit, String pengarang, String ringkasan, Set<DetailTransaksi> detailTransaksis) {
        this.isbn = isbn;
        this.judul = judul;
        this.jumlahSalinan = jumlahSalinan;
        this.penerbit = penerbit;
        this.pengarang = pengarang;
        this.ringkasan = ringkasan;
        this.detailTransaksis = detailTransaksis;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id_buku", unique = true)
    public Integer getIdBuku() {
        return this.idBuku;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    @Column(name = "isbn", length = 30)
    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Column(name = "judul", length = 100)
    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @Column(name = "jumlah_salinan")
    public int getJumlahSalinan() {
        return this.jumlahSalinan;
    }

    public void setJumlahSalinan(int jumlahSalinan) {
        this.jumlahSalinan = jumlahSalinan;
    }

    @Column(name = "penerbit", length = 100)
    public String getPenerbit() {
        return this.penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    @Column(name = "pengarang", length = 100)
    public String getPengarang() {
        return this.pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    @Column(name = "ringkasan")
    public String getRingkasan() {
        return this.ringkasan;
    }

    public void setRingkasan(String ringkasan) {
        this.ringkasan = ringkasan;
    }

    @Column(name = "tahun")
    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
    
    

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buku")
    public Set<DetailTransaksi> getDetailTransaksis() {
        return this.detailTransaksis;
    }

    public void setDetailTransaksis(Set<DetailTransaksi> detailTransaksis) {
        this.detailTransaksis = detailTransaksis;
    }

}
