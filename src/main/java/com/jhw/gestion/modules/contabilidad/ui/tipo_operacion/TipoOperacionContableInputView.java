package com.jhw.gestion.modules.contabilidad.ui.tipo_operacion;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.*;
import com.jhw.gestion.modules.contabilidad.ui.module.ContabilidadSwingModule;
import com.jhw.gestion.modules.contabilidad.ui.tipo_cuenta.TipoCuentaICBS;
import com.jhw.swing.material.components.textarea.MaterialTextArea;
import com.jhw.swing.material.components.textarea.MaterialTextAreaFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFactory;
import com.jhw.swing.material.components.textfield.MaterialTextFieldIcon;
import com.jhw.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class TipoOperacionContableInputView extends CleanCRUDInputView<TipoOperacionContableDomain> {

    public static TipoOperacionContableInputView fromModel(TipoOperacionContableDomain model) {
        return new TipoOperacionContableInputView(model);
    }

    public static TipoOperacionContableInputView from() {
        return new TipoOperacionContableInputView(null);
    }

    private TipoOperacionContableInputView(TipoOperacionContableDomain model) {
        super(model, ContabilidadSwingModule.tipoOperacionContableUC, TipoOperacionContableDomain.class);
        initComponents();
        addListeners();
        update();
    }

    private void initComponents() {
        setHeader("Crear Tipo de Operación", "Editar Tipo de Operación");

        //tipo
        textFieldTipo = MaterialTextFactory.buildIcon();
        textFieldTipo.setLabel("Tipo de operación");
        textFieldTipo.setHint("Nombre del tipo de operación. Ej.: Gasto");
        textFieldTipo.setIcon(MaterialIcons.PRIORITY_HIGH);

        //cuenta
        cuentaDefecto = new TipoCuentaICBS();
        cuentaDefecto.setLabel("Tipo de cuenta por defecto");

        //cuadre
        cuentaDefectoCuadre = new TipoCuentaICBS();
        cuentaDefectoCuadre.setLabel("Tipo de cuenta de cuadre");

        //descripcion
        textAreaDescripcion = MaterialTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldTipo);
        vlc.add(cuentaDefecto);
        vlc.add(cuentaDefectoCuadre);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldTipo;
    private TipoCuentaICBS cuentaDefecto;
    private TipoCuentaICBS cuentaDefectoCuadre;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration                   

    @Override
    public void update() {
        super.update();
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombreOperacion", textFieldTipo);
        bindFields.put("tipoCuentaDefectoFk", cuentaDefecto);
        bindFields.put("tipoCuentaCuadreDefectoFk", cuentaDefectoCuadre);
        bindFields.put("descripcion", textAreaDescripcion);
        return bindFields;
    }

    private void addListeners() {
        cuentaDefecto.getComboBox().addActionListener((ActionEvent e) -> {
            updateCuadreICBS();
        });
    }

    private void updateCuadreICBS() {
        try {
            cuentaDefectoCuadre.updateComboBoxCuadre(cuentaDefecto.getObject());
        } catch (Exception e) {
        }
    }
}
