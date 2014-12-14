package model;


import controller.logic.AdministratorJob;

import java.io.Serializable;

public class Administrator extends User implements Serializable,AdministratorJob{

    private final Role role=Role.ADMINISTRATOR;


    @Override
    public boolean markClientBlackList(Client client) {
        if (client.getId()==null){
            return false;
        }
        client.setBlackList(1);
        return true;

    }

    @Override
    public boolean unmarkClientBlackList(Client client) {
        if (client.getId()==null){
            return false;
        }
        client.setBlackList(0);
        return true;
    }

    @Override
    public boolean removeProduct(Product oldProduct) {
        return false;
    }

    @Override
    public boolean addProduct(Product newProduct) {
        return false;
    }

    @Override
    public void printCatalog() {

    }
}
