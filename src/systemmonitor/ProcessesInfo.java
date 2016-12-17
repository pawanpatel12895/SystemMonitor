/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package systemmonitor;

import java.util.ArrayList;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

/**
 *
 * @author pawan
 */
public class ProcessesInfo 
{   
    Sigar sigar;
    public ProcessesInfo(Sigar sigar) 
    {   this.sigar = sigar;
    }
    String[] getProcessList() throws SigarException
    {      ArrayList<String> list = new ArrayList<>() ;
        long[] procpid  = sigar.getProcList();
        
        for(long L : procpid)
        {   String S[] = sigar.getProcArgs(L);
            if(S.length!=0)
            {   
                list.add( L+"\t"+S[0]);
            }
        }
        
        return  list.toArray(new String[list.size()]);
    }
    
}
