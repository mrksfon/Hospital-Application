/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import vrstaBolniceCommand.VrstaBolniceLoadAllCommand;
import tipDoktoraCommand.TipDoktoraLoadAllCommand;
import tipDoktoraCommand.TipDoktoraCreateCommand;
import tipDoktoraCommand.TipDoktoraDeleteCommand;
import zvanjeCommand.ZvanjeUpdateCommand;
import zvanjeCommand.ZvanjeCreateCommand;
import zvanjeCommand.ZvanjeLoadAllCommand;
import zvanjeCommand.ZvanjeDeleteCommand;
import doktorCommand.DoktorUpdateCommand;
import doktorCommand.DoktorLoadByIdCommand;
import doktorCommand.DoktorDeleteCommand;
import doktorCommand.DoktorLoadAllCommand;
import doktorCommand.DoktorCreateCommand;
import bolnicaCommand.BolnicaCreateCommand;
import bolnicaCommand.BolnicaLoadByIdCommand;
import bolnicaCommand.BolnicaLoadAllCommand;
import transfer.Operation;
import transfer.request.RequestObject;

/**
 *
 * @author Marenda
 */
public class CommandResolver {
    public static synchronized AbstractCommand resolve(Operation operation,RequestObject request){
        switch(operation){
            case ZVANJE_CREATE:
                return new ZvanjeCreateCommand(request);
            case ZVANJE_DELETE:
                return new ZvanjeDeleteCommand(request);
            case ZVANJE_LOAD_ALL:
                return new ZvanjeLoadAllCommand();
            case ZVANJE_UPDATE:
                return new ZvanjeUpdateCommand(request);
            case DOKTOR_CREATE:
                return new DoktorCreateCommand(request);
            case DOKTOR_DELETE:
                return new DoktorDeleteCommand(request);
            case DOKTOR_LOAD_ALL:
                return new DoktorLoadAllCommand();
            case DOKTOR_LOAD_BY_ID:
                return new DoktorLoadByIdCommand(request);
            case DOKTOR_UPDATE:
                return new DoktorUpdateCommand(request);
            case BOLNICA_KREIRAJ:
                return new BolnicaCreateCommand(request);
            case BOLNICA_LOAD_ALL:
                return new BolnicaLoadAllCommand();
            case BOLNICA_LOAD_BY_ID:
                return new BolnicaLoadByIdCommand(request);
            case TIP_DOKTORA_CREATE:
                return new TipDoktoraCreateCommand(request);
            case TIP_DOKTORA_DELETE:
                return new TipDoktoraDeleteCommand(request);
            case TIP_DOKTORA_LOAD_ALL:
                return new TipDoktoraLoadAllCommand();
            case VRSTA_BOLNICE_LOAD_ALL:
                return new VrstaBolniceLoadAllCommand();
        }
        return new NullCommand();
    }
}
