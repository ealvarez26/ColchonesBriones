package com.colchonesBriones.Service;

import com.colchonesBriones.Dao.AgendaDao;
import com.colchonesBriones.Dao.ClienteDao;
import com.colchonesBriones.Domain.Agenda;
import com.colchonesBriones.Domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    AgendaDao agendaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Agenda> getAgendas() {
        return (List<Agenda>) agendaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Agenda getAgenda(Agenda agenda) {
        return agendaDao.findById(agenda.getIdCita()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Agenda agenda) {

        agendaDao.save(agenda);
    }

    @Override
    @Transactional
    public void delete(Agenda agenda) {
        agendaDao.deleteById(agenda.getIdCita());
    }

    

}
