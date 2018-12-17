package Partie2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Parking implements Iterable<Vehicule>{
    @Override
    public Iterator<Vehicule> iterator() {
        return new Iterator<Vehicule>() {
            private Place placeCourante = placeSuivante(LocalDate.MIN);

            public Place placeSuivante (LocalDate date)
            {
                Place actuelle = null;
                for (Place p : places)
                {
                    if (p.estLibre())
                        continue;
                    Vehicule v = p.getVehiculeGaree();
                    if (v.getDateArrivee().isAfter(date))
                    {
                        actuelle = p;
                        break;
                    }
                }

                return actuelle;
            }


            @Override
            public boolean hasNext() {

                return placeCourante != null;
            }

            @Override
            public Vehicule next() {
                if (placeCourante == null) return null;
                Vehicule res = placeCourante.getVehiculeGaree();
                placeCourante = placeSuivante(res.getDateArrivee());

                return res;
            }
        };
    }

    public void toSTring() {
         System.out.println("Parking{" +
                "places=" + places +
                '}');
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    private ArrayList<Place> places;

    public Parking() {
        places = new ArrayList<Place>();
    }
    public void ajouter(Place place) {
        places.add(place);
    }

    public void garerVehicule(Vehicule v,StrategieGarer s,Parking p)
    {
        s.seGarer(p.getPlaces() ,v);
    }

}