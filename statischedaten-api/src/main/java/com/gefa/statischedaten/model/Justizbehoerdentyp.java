package com.gefa.statischedaten.model;

/*
 * @created 20/09/2021 10:29 PM
 * @author Ivan Aksak aksak@iname.com
 */
public class Justizbehoerdentyp {
    private Integer id;
    private String name;
    private String kurzbezeichnung;
    private String anzeigereihenfolge;


    public Justizbehoerdentyp() {
    }

    public Justizbehoerdentyp(String aName, String akurzbezeichnung) {
        this.setName(aName);
        this.setKurzbezeichnung(akurzbezeichnung);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKurzbezeichnung() {
        return kurzbezeichnung;
    }

    public void setKurzbezeichnung(String kurzbezeichnung) {
        this.kurzbezeichnung = kurzbezeichnung;
    }

    public String getAnzeigereihenfolge() {
        return anzeigereihenfolge;
    }

    public void setAnzeigereihenfolge(String anzeigereihenfolge) {
        this.anzeigereihenfolge = anzeigereihenfolge;
    }
}
