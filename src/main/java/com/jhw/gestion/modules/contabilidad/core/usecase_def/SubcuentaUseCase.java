package com.jhw.gestion.modules.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.gestion.modules.contabilidad.core.domain.old.CuentaDomain;
import com.jhw.gestion.modules.contabilidad.core.domain.old.SubcuentaDomain;
import java.util.List;

public interface SubcuentaUseCase extends CRUDUseCase<SubcuentaDomain> {

    public List<SubcuentaDomain> findSubcuentasDondeSeaHijo(CuentaDomain hijo);

    public List<SubcuentaDomain> findSubcuentasDondeSeaPadre(CuentaDomain padre);

}