package com.jhw.gestion.modules.contabilidad.ui.cuadre.pedazos;

import com.jhw.swing.material.components.container.layout.VerticalLayoutContainer;
import com.jhw.swing.models.clean.CleanCRUDInputView;
import com.jhw.gestion.modules.contabilidad.core.domain.facade.DocNombreUI;
import com.jhw.swing.material.standards.MaterialIcons;
import java.util.Map;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class DocNombreInputView extends CleanCRUDInputView<DocNombreUI> {

    public static DocNombreInputView from() {
        return new DocNombreInputView(null);
    }

    private DocNombreInputView(DocNombreUI model) {
        super(model, null, DocNombreUI.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("", "");

        //compra
        textFieldNombre = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldNombre.setHint("Nombre");
        textFieldNombre.setLabel("Nombre de la Operación");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        //doc
        textFieldDocumento = new com.jhw.swing.material.components.textfield._MaterialTextFieldIcon();
        textFieldDocumento.setLabel("Documento");
        textFieldDocumento.setHint("Factura o Transacción asociada");
        textFieldDocumento.setIcon(MaterialIcons.DRAFTS);

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();
        vlc.add(textFieldNombre);
        vlc.add(textFieldDocumento);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldNombre;
    private com.jhw.swing.material.components.textfield._MaterialTextFieldIcon textFieldDocumento;
    // End of variables declaration                   

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> bindFields = super.bindFields();
        bindFields.put("nombre", textFieldNombre);
        bindFields.put("documento", textFieldDocumento);
        return bindFields;
    }
}
