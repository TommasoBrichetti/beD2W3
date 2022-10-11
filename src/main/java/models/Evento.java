package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String titolo;

    private String data;

    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoevento;

    private int numeropartecipanti;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "evento")
    public Set<Partecipazione> partecipazioni;

    public Evento( String titolo, String data, String descrizione, TipoEvento tipoevento, int numeropartecipanti,
                   Location location) {
        this.titolo = titolo;
        this.data = data;
        this.descrizione = descrizione;
        this.tipoevento = tipoevento;
        this.numeropartecipanti = numeropartecipanti;
        this.location = location;

    }

    public Evento() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo( String titolo ) {
        this.titolo = titolo;
    }

    public String getData() {
        return data;
    }

    public void setData( String data ) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione( String descrizione ) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoevento() {
        return tipoevento;
    }

    public void setTipoevento( TipoEvento tipoevento ) {
        this.tipoevento = tipoevento;
    }

    public int getNumeropartecipanti() {
        return numeropartecipanti;
    }

    public void setNumeropartecipanti( int numeropartecipanti ) {
        this.numeropartecipanti = numeropartecipanti;
    }

    public Set<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "titolo='" + titolo + '\'' +
                ", data='" + data + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", tipoevento=" + tipoevento +
                ", numeropartecipanti=" + numeropartecipanti +
                '}';
    }
}
