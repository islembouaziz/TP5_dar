package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.IConversion;

public class ConversionClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        IConversion conversion = (IConversion) registry.lookup("IConversion");

        double montant = 500.0;
        double resultat = conversion.convertirMontant(montant);

        System.out.println("Conversion de " + montant + " EUR vers DZD");
        System.out.println("Résultat : " + resultat + " DZD");
    }
}
