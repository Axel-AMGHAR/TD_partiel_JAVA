package Partie2;

import java.util.ArrayList;

public class GarerPasCherAvecCapacité implements StrategieGarer {

    private double capacité;
    private ArrayList<Place> placesBonneCapacité;

    public GarerPasCherAvecCapacité (double capacite)
    {
        this.capacité = capacite;
    }

    @Override
    public void seGarer(ArrayList<Place> p, Vehicule v) {
        double moinCher = 100;
        for (Place pa : p)
        {
            if(pa.getCapacité() == this.capacité && pa.estLibre())
                placesBonneCapacité.add(pa);
        }

        for (Place pa : placesBonneCapacité)
        {
            if(pa.getCoutJour() < moinCher && pa.estLibre())
                moinCher = pa.getCoutJour();
        }

        for (Place pa : p)
        {
            if (moinCher == pa.getCoutJour())
                pa.affecterVehicule(v);
        }
    }
}
