package model;

import jakarta.persistence.*;

@Entity
public class Emploi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_empl;

    @ManyToOne
    private Coordinateur coord;

    public Emploi(Coordinateur coord) {
        this.coord = coord;
    }
    public Emploi() {}

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

    @Override
    public String toString() {
        return "Emploi{" +
                "id_empl=" + id_empl +
                ", coord=" + coord +
                '}';
    }
}
