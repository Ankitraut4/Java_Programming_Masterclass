package com.company;

public class Motherbord {
    private String name;
    private String manifacture;
    private int graphiccard;
    private int ram;

    public Motherbord(String name, String manifacture, int graphiccard, int ram) {
        this.name = name;
        this.manifacture = manifacture;
        this.graphiccard = graphiccard;
        this.ram = ram;
    }

    public String getName() {
        return name;
    }

    public String getManifacture() {
        return manifacture;
    }

    public int getGraphiccard() {
        return graphiccard;
    }

    public int getRam() {
        return ram;
    }
}
