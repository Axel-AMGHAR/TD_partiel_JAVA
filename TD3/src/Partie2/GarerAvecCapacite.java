package Partie2;

import java.util.ArrayList;

public class GarerAvecCapacite implements StrategieGarer {

    @Override
    public void seGarer(ArrayList<Place> places, Vehicule v) {
        double capacite = 0;

        for (Place p : places) {

            if (p.getCapacité() < capacite && p.estLibre())
                capacite += p.getCapacité();
        }

        for (Place p : places) {
            if (capacite == p.getCapacité())
                p.affecterVehicule(v);

        }
    }
}


