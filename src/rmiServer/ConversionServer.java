package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.ConversionImpl;
import rmiService.IConversion;

public class ConversionServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "localhost");

        Registry registry = LocateRegistry.createRegistry(1099);
        IConversion conversion = new ConversionImpl();
        registry.rebind("IConversion", conversion);

        System.out.println("Serveur RMI de conversion démarré sur le port 1099");
        System.out.println("Objet distant : IConversion");
    }
}
