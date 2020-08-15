/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.gestion.modules.contabilidad.ui.cuenta_contable;

import com.jhw.gestion.modules.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.gestion.modules.contabilidad.ui.main_section.CuentaSinglePanel;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class CuentaContableSinglePanel extends CuentaSinglePanel {

    private final CuentaContableDomain cuenta;

    public CuentaContableSinglePanel(CuentaContableDomain cuenta) {
        super(cuenta);
        this.cuenta = cuenta;
    }

    @Override
    protected void viewAction() {
        //new DialogDetail(this, "Operaciones", new LiquidacionDetailView(cuenta));
    }

    @Override
    protected void editAction() {
        new DialogModelInput(this, new CuentaContableInputView(cuenta));
    }

}