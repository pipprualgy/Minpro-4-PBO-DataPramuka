package com.mycompany.minprodatapramuka;

import Controller.PramukaController;
import View.PramukaView;

public class MinproDataPramuka {
    public static void main (String[]args){
        PramukaController controller = new PramukaController();
        PramukaView view = new PramukaView(controller);

        view.mulai();
    }
}