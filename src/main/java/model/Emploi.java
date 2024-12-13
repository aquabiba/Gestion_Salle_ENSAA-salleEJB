package model;

import jakarta.persistence.*;

@Entity
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empl;
    private String desc_empl;
    @Lob
    private Byte[] emploiPDF;
    @ManyToOne
    private Coordinateur coord;


    public Emploi() {}

    public String getDesc_empl() {
        return desc_empl;
    }

    public void setDesc_empl(String desc_empl) {
        this.desc_empl = desc_empl;
    }

    public Emploi(Coordinateur coord) {
        this.coord = coord;
    }
    public int getId_empl() {
        return id_empl;
    }

    public void setId_empl(int id_empl) {
        this.id_empl = id_empl;
    }

    public Coordinateur getCoord() {
        return coord;
    }

    public void setCoord(Coordinateur coord) {
        this.coord = coord;
    }

    public Byte[] getEmploiPDF() {
        return emploiPDF;
    }

    public void setEmploiPDF(Byte[] emploiPDF) {
        this.emploiPDF = emploiPDF;
    }

    @Override
    public String toString() {
        return "Emploi{" +
                "id_empl=" + id_empl +
                ", coord=" + coord +
                '}';
    }
}
