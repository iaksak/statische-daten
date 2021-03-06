package com.gefa.statischedaten.model;

/*
 * @created 29/09/2021 2:58 AM
 * @author Ivan Aksak aksak@iname.com
 */
public class Ebenentyp {

    private Integer id;
    private String name;
    private String beschreibung;
    private String anzeigereihenfolge;

    public Ebenentyp() {
    }

    public Ebenentyp(String aName, String aBeschreibung) {
        this.name = aName;
        this.beschreibung = aBeschreibung;
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

    public String getBeschreibung() {
        return beschreibung;
    }
    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getAnzeigereihenfolge() {
        return anzeigereihenfolge;
    }
    public void setAnzeigereihenfolge(String anzeigereihenfolge) {
        this.anzeigereihenfolge = anzeigereihenfolge;
    }
}
