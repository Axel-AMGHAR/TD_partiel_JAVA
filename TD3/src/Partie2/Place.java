package Partie2;

public class Place {

    public boolean isEstLibre() {
        return estLibre;
    }

    private Vehicule vehiculeGaree;

    private boolean estLibre = true;
    private double coutJour;
    private double capacité;

    public Place(double cp, double cj) {
        capacité = cp;
        coutJour = cj;
    }
    public boolean estLibre() {
        return estLibre;
    }
    public void affecterVehicule(Vehicule v){
        vehiculeGaree = v;
        estLibre = false;
    }
    public double getCoutJour() {
        return coutJour;
    }
    public double getCapacité() {
        return capacité;
    }
    public Vehicule getVehiculeGaree() {
        return this.vehiculeGaree;
    }
}