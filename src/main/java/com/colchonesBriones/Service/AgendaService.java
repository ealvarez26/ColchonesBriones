
package com.colchonesBriones.Service;

import com.colchonesBriones.Domain.Agenda;
import java.util.List;



public interface AgendaService {
    public List<Agenda> getAgendas();
    
    public Agenda getAgenda(Agenda agenda);
    
    public void save(Agenda agenda);//Para insertar o modificar (Si viene el idAgenda o no)
    
    public void delete(Agenda agenda);
}
