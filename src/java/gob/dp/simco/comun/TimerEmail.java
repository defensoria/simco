/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.dp.simco.comun;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author carlos
 */
public class TimerEmail {

    public void envioEmail() {
        
        TimerTask timerTask; 
        timerTask = new TimerTask() {
            
            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }; 
        
        Timer timer = new Timer(); 
     // Dentro de 0 milisegundos avísame cada 1000 milisegundos 
     timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }
    
}
