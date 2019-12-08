/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doktorController;

import java.util.ArrayList;
import java.util.List;
import model.Bolnica;
import model.Doktor;
import model.TipDoktora;
import model.Zvanje;
import session.Session;
import transfer.Operation;
import transfer.Status;
import transfer.request.RequestObject;
import transfer.request.ResponseObject;

/**
 *
 * @author Marenda
 */
public class DoktorController {

    private List<Doktor> doktoriIzBaze;
    private List<Bolnica> bolniceIzBaze;
    private List<Zvanje> zvanjaIzBaze;
    private List<TipDoktora> tipoviDoktoraIzBaze;

    public DoktorController() {
        doktoriIzBaze = new ArrayList<>();
        bolniceIzBaze = new ArrayList<>();
        zvanjaIzBaze = new ArrayList<>();
        tipoviDoktoraIzBaze = new ArrayList<>();
    }

    public Doktor create(String ime, String prezime, Bolnica bolnica, TipDoktora tip, Zvanje zvanje) throws Exception {
        Doktor d = new Doktor(ime, prezime);
        d.setZvanje(zvanje);
        d.setBolnica(bolnica);
        d.setTipDoktora(tip);

        RequestObject request = new RequestObject(d, Operation.DOKTOR_CREATE);

        ResponseObject response = session.Session.getInstance().sendRequest(request);

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }
        return (Doktor) response.getData();
    }

    public List<Doktor> loadAll() throws Exception {
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(null, Operation.DOKTOR_LOAD_ALL));

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }

        doktoriIzBaze = (List<Doktor>) response.getData();

        return doktoriIzBaze;
    }

    public Doktor delete(Doktor doktor) throws Exception {
        ResponseObject response = Session.getInstance().sendRequest(new RequestObject(doktor, Operation.DOKTOR_DELETE));

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }

        return (Doktor) response.getData();
    }

    public void setBolniceIzBaze(List<Bolnica> bolniceIzBaze) {
        this.bolniceIzBaze = bolniceIzBaze;
    }

    public void setZvanjaIzBaze(List<Zvanje> zvanjaIzBaze) {
        this.zvanjaIzBaze = zvanjaIzBaze;
    }

    public void setTipoviDoktoraIzBaze(List<TipDoktora> tipoviDoktoraIzBaze) {
        this.tipoviDoktoraIzBaze = tipoviDoktoraIzBaze;
    }

    public List<Bolnica> pronadjiBolnice(String filter) {
        if (filter.isEmpty()) {
            return bolniceIzBaze;
        }
        List<Bolnica> bolnice = new ArrayList<>();

        for (Bolnica b : bolniceIzBaze) {
            if (b.getNaziv().toLowerCase().contains(filter.toLowerCase()) || b.getMaticniBroj().contains(filter.toLowerCase())) {
                bolnice.add(b);
            }
        }
        return bolnice;
    }

    public List<TipDoktora> pronadjiTipoveDoktora(String filter) {
        if (filter.isEmpty()) {
            return tipoviDoktoraIzBaze;
        }

        List<TipDoktora> tipoviDoktora = new ArrayList<>();

        for (TipDoktora td : tipoviDoktoraIzBaze) {
            if (td.getNaziv().toLowerCase().contains(filter.toLowerCase())) {
                tipoviDoktora.add(td);
            }
        }
        return tipoviDoktora;
    }

    public List<Zvanje> pronadjIZvanja(String filter) {
        if (filter.isEmpty()) {
            return zvanjaIzBaze;
        }

        List<Zvanje> zvanja = new ArrayList<>();

        for (Zvanje z : zvanjaIzBaze) {
            if (z.getNaziv().contains(filter)) {
                zvanja.add(z);
            }
        }
        return zvanja;
    }

    public Doktor loadById(Integer id) throws Exception {
        RequestObject request = new RequestObject(id, Operation.DOKTOR_LOAD_BY_ID);

        ResponseObject response = Session.getInstance().sendRequest(request);

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }
        return (Doktor) response.getData();
    }

    public void update(Integer ID, String ime, String prezime, Bolnica bolnica, TipDoktora tip, Zvanje zvanje) throws Exception {
        Doktor doktor = new Doktor(ime, prezime);
        doktor.setZvanje(zvanje);
        doktor.setBolnica(bolnica);
        doktor.setTipDoktora(tip);
        doktor.setId(ID);

        RequestObject request = new RequestObject(doktor, Operation.DOKTOR_UPDATE);

        ResponseObject response = Session.getInstance().sendRequest(request);

        if (response.getStatus() == Status.ERROR) {
            throw response.getErrorData();
        }
    }

    public List<Doktor> pretraga(String filter) {
        if (filter.isEmpty()) {
            return doktoriIzBaze;
        }

        List<Doktor> doktori = new ArrayList<>();

        filter = filter.toLowerCase();

        for (Doktor d : doktoriIzBaze) {
            if (d.getIme().toLowerCase().contains(filter)
                    || d.getPrezime().toLowerCase().contains(filter)
                    || d.getBolnica().getNaziv().toLowerCase().contains(filter)
                    || d.getZvanje().getNaziv().toLowerCase().contains(filter)
                    || d.getTipDoktora().getNaziv().toLowerCase().contains(filter)) {
                doktori.add(d);
            }
        }
        return doktori;
    }
}
