package rmiClient;

import java.util.Date;

import javax.naming.InitialContext;

import metier.Compte;
import rmiService.IBanque;

public class BanqueClient {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty("java.naming.provider.url", "rmi://localhost:1099");

        InitialContext context = new InitialContext();
        IBanque banque = (IBanque) context.lookup("BanqueService");

        Compte compte = new Compte(1001, 2500.0, new Date());
        System.out.println(banque.creerCompte(compte));
        System.out.println(banque.getInfoCompte(1001));
    }
}
