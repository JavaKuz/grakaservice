package com.anton.grakaservice.repository.model;


import javax.persistence.*;



@Entity
@Table(name = "Graka")
public class Graka {


    public enum Manufacturer {
        INTEL(0), AMD(1), NVIDIA(2);
        private int value;

        private Manufacturer(int choice) {
            value = choice;
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "preis")
    private double preis;

    @Enumerated(EnumType.STRING)
    @Column(name = "manufacturer")
    private Manufacturer manufacturer;

  /*  @Enumerated(EnumType.ORDINAL)
    private Manufacturer manu;*/


    public Graka(long id, String name, double preis, Manufacturer manufacturer) {
        super();
        this.id = id;
        this.name = name;
        this.preis = preis;
        this.manufacturer = manufacturer;
    }

    public Graka() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}



