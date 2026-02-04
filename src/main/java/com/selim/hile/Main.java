package com.selim.hile;

import javax.swing.JOptionPane;
import java.awt.Toolkit;

public class Main {
    public static void main(String[] args) {
        // Bu kısım jar dosyasını tıkladığında çalışır
        System.out.println("Selim Hile Altyapisi Calisiyor!");
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Hile Altyapisi Basariyla Kuruldu!\nKillaura Modulu Beklemede.", "SelimHile", 1);
    }

    // Bu fonksiyonu daha sonra Minecraft'a bağlayacağız
    public static void onUpdate() {
        System.out.println("Killaura Tarama yapiyor...");
    }
}
