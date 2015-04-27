/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import entite.Casefile;
import entite.Samples;
import error.SampleWithoutCasefileError;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author S.ANDRIANAVONY
 */
@Stateless
public class SamplesUtility {
    
    @Inject SamplesFind samplesFind;

    public Samples createOrRetreiveSampleCurrent(Casefile casefileCurrent) throws SampleWithoutCasefileError  {
        //System.out.println("Dans SampleUtility createOrRetreiveSampleCurrent casefileCurrent.getIdBatch "+casefileCurrent.getIdbatch());
        if(null == casefileCurrent){
            //System.out.println(" caseffileCurrente vaut null ====================================<<<<<<<<<<<<<<<<<<");
            throw new SampleWithoutCasefileError("Case File must be provided before creating samples");
        }
        List<Samples>  sampelsList= samplesFind.findSamplesCurrent(casefileCurrent);
        if(sampelsList.isEmpty()){
            return createSample(casefileCurrent);
        }
        return sampelsList.get(0);
        
    }

    public Samples createSample(Casefile casefile) throws SampleWithoutCasefileError {
        if(null == casefile){
            throw new SampleWithoutCasefileError("Case File must be provided before creating samples");
        }
         
        Samples samples = new Samples();
        samples.setIscurrent(Boolean.TRUE);
        samples.setIdarticle(casefile.getIdarticle());
        samples.setBatchname(casefile.getBatchname());
        samples.setCreationdate(utilities.DateManager.getNow());
        samples.setStatuslabel("logged");
        samples.setIdbatch(casefile.getIdbatch());
        //System.out.println(casefile.getIdbatch() + " => dans creation samples.setIdbatch ******************************"+samples.getIdbatch());
        samples.setIdcasefile(casefile);
        samples.setIdspecie(casefile.getIdspecie());
        samples.setIdstage(casefile.getIdstage());
        //samplesCurrent.setLimssampleid(limssampleid);
        samples.setLimsfolderno(casefile.getLimsfolderno());
        //System.out.println("Dans create sample ******************************"+samples);
                
        return samples;
    }
    
}
