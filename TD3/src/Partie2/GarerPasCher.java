package Partie2;

import java.util.ArrayList;

public class GarerPasCher implements StrategieGarer {


    @Override
    public void seGarer(ArrayList<Place> places, Vehicule v) {

        double moinCher = 100;

        for (Place p : places) {

            if (p.getCoutJour() < moinCher && p.estLibre())
                moinCher = p.getCoutJour();
        }

        for (Place p : places) {
            if (moinCher == p.getCoutJour())
                p.affecterVehicule(v);
        }

    }
}
