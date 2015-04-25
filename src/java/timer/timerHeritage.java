/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import session.ejb.RecopieAnalysis;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
@LocalBean
public class timerHeritage {

    @Inject RecopieAnalysis recopieAnalysis;
    
    @Schedule(dayOfWeek = "Mon-Fri", month = "*", hour = "5-18", dayOfMonth = "*", year = "*", minute = "*", second = "0")
    
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
        recopieAnalysis.doHeritage();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
