import java.util.ArrayList;

public class Model {

    static Observer observerGsolina = new ObserverGasolina();

    private static ArrayList<Coche> parking = new ArrayList<>();


    public static String listarCoches() {
        String r = "";
        for (Coche c : parking) {
            r += "Modelo: " + c.modelo + ", Matrícula: " + c.matricula + " Velocidad: " + c.velocidad + " Gasolina en el depósito: " + c.gasolina +  "\n";
        }
        return r;

    }
    //funcion para crear un nuevo coche
    public static void crearCoche(String modelo, String matricula) {
        parking.add(new Coche(modelo,matricula));

    }
    //funcion para cambiar la velocidad de un coche
    public static Integer modificarVelocidad(String matricula1, String velocidad) {
        Coche coche = buscarCoche(matricula1);
        if (coche != null) {
            coche.velocidad = Integer.valueOf(velocidad);
            return coche.velocidad;
        }
        return null;
    }

    //funcion para buscar un coche en el parking por su matricula
    static Coche buscarCoche(String matricula){
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                return e;
            }
        }
        return null;
    }

    public static void repostarGasolina(String matricula2, int litros) {
        Coche c = buscarCoche(matricula2);
        c.repostar(litros);
        }

    public static void avanzarCoche(String matricula3, int metros) {
        Coche c = buscarCoche(matricula3);
        c.avanzar(metros);
        observerGsolina.update(c);
    }
}
