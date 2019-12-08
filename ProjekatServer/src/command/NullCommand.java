/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Marenda
 */
public class NullCommand extends AbstractCommand{

    @Override
    protected void executeOperation() throws Exception {
        throw new Exception("Null command Exception");
    }
    
}
