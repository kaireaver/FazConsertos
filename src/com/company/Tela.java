package com.company;

import javax.swing.*;
import java.awt.event.*;

public abstract class Tela extends JFrame {
    protected boolean checaDispose = false;

    Tela(String str) {
        super(str);
    }

    public void checaDispose() {
        if (checaDispose) {
            TelaInicial.setBotaoTecnicos(false);
            TelaInicial.setBotaoClientes(false);
        } else {
            TelaInicial.setBotaoTecnicos(true);
            TelaInicial.setBotaoClientes(true);
        }
    }

}
