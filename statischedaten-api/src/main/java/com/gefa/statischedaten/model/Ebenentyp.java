package com.gefa.statischedaten.model;

/*
 * @created 29/09/2021 2:58 AM
 * @author Ivan Aksak aksak@iname.com
 */
public class Ebenentyp {

    private int id;
    private String name;
    private String beschreibung;
    private String anzeigereihenfolge;

    public Ebenentyp(int anId) {
        id = anId;
    }

    public Ebenentyp(int anId, String aName, String aBeschreibung) {
        this(anId);
        this.name = aName;
        this.beschreibung = aBeschreibung;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
