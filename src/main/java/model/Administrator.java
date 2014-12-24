package model;


import controller.logic.AdministratorJob;

import java.io.Serializable;

public class Administrator extends User implements Serializable{

    private final Role role=Role.ADMINISTRATOR;

}
