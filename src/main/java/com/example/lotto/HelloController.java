package com.example.lotto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class HelloController {

    @FXML
    private Button btnSorsolas;
    @FXML
    private Label lblSorsoltSzam;
    @FXML
    private Label lblSorsoltSzamok;
    @FXML
    private ArrayList<Integer> sorsoltSzamok;
    @FXML
    private Random random;


    @FXML
    public void initialize(){
        this.sorsoltSzamok = new ArrayList<>();
        this.random = new Random();
    }

    private String feltolt(){
        String sorsoltakString = "";
        int szam;
        for(Iterator var2 = this.sorsoltSzamok.iterator(); var2.hasNext(); sorsoltakString = sorsoltakString + String.valueOf(szam) + " ") {
            szam = (Integer)var2.next();
        }
        return sorsoltakString;
    }

    private void rendez(){
        boolean rendezve = false;
        while(!rendezve) {
            rendezve = true;

            for(int i = 0; i < this.sorsoltSzamok.size() - 1; ++i) {
                if ((Integer)this.sorsoltSzamok.get(i) > (Integer)this.sorsoltSzamok.get(i + 1)) {
                    int temp = (Integer)this.sorsoltSzamok.get(i);
                    this.sorsoltSzamok.set(i, (Integer)this.sorsoltSzamok.get(i + 1));
                    this.sorsoltSzamok.set(i + 1, temp);
                    rendezve = false;
                }
            }
        }
    }



    public void sorsolas(ActionEvent actionEvent) {
        boolean sorsolasKesz = this.sorsoltSzamok.size() < 5;
        if (sorsolasKesz) {
            int szam = this.random.nextInt(1,91);
            this.lblSorsoltSzam.setText(String.valueOf(szam));
            this.sorsoltSzamok.add(szam);
            this.lblSorsoltSzamok.setText(this.feltolt());
            if (this.sorsoltSzamok.size() == 5) {
                this.btnSorsolas.setText("Rendez");
            }
        } else {
            this.rendez();
            this.lblSorsoltSzamok.setText(this.feltolt());
            this.btnSorsolas.setText("Sorsol");
            this.sorsoltSzamok.clear();
        }
    }
}