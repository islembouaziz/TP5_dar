package rmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import metier.Compte;

public class BanqueImpl extends UnicastRemoteObject implements IBanque {
    private static final long serialVersionUID = 1L;

    private final Map<Integer, Compte> comptes;

    public BanqueImpl() throws RemoteException {
        super();
        this.comptes = new HashMap<>();
    }

    @Override
    public String creerCompte(Compte c) throws RemoteException {
        if (c == null) {
            return "Compte invalide.";
        }

        if (comptes.containsKey(c.getCode())) {
            return "Le compte " + c.getCode() + " existe déjà.";
        }

        comptes.put(c.getCode(), c);
        return "Compte créé avec succès : " + c;
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        Compte compte = comptes.get(code);
        if (compte == null) {
            return "Aucun compte trouvé pour le code " + code;
        }
        return "Compte trouvé : " + compte;
    }
}
