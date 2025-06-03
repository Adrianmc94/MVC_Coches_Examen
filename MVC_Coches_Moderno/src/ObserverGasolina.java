public class ObserverGasolina implements Observer {

    @Override
    public void update(Coche coche) {
        if ( coche.gasolina < 10){
            System.out.println("OBSERVER! te estas quedando sin gasolina!");
        }

    }
}
