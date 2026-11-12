package rmiServer;

import java.rmi.registry.LocateRegistry;

import javax.naming.Context;
import javax.naming.InitialContext;

import rmiService.BanqueImpl;
import rmiService.IBanque;

public class BanqueServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.rmi.server.hostname", "localhost");
        System.setProperty("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty("java.naming.provider.url", "rmi://localhost:1099");

        LocateRegistry.createRegistry(1099);
        System.out.println("RMI registry démarré sur le port 1099");

        IBanque banque = new BanqueImpl();
        Context context = new InitialContext();
        context.bind("BanqueService", banque);

        System.out.println("Service bancaire enregistré via JNDI.");
    }
}
