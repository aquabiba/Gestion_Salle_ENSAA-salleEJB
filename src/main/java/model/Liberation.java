package model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Liberation {
    private String libelle_lib;
    public Liberation(){}

    @Override
    public String toString() {
        return "Liberation{" +
                "libelle_lib='" + libelle_lib + '\'' +
                '}';
    }

    public String getLibelle_lib() {
        return libelle_lib;
    }

    public void setLibelle_lib(String libelle_lib) {
        this.libelle_lib = libelle_lib;
    }
}
