package slr.master.stratospherique.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import slr.master.stratospherique.domain.Input;
import slr.master.stratospherique.domain.Sector;
import slr.master.stratospherique.domain.SysType;
import slr.master.stratospherique.repository.*;

import java.util.Iterator;

/**
 * Created by ASUS on 30/07/2018.
 */

@Component
public class ConLoader implements ApplicationListener<ContextRefreshedEvent> {
    private EFormatRepository eFormatRepository;
    private ESourceRepository eSourceRepository;
    private SectorRepository sectorRepository;
    private SysTypeRepository sysTypeRepository;
    private UserTypeRepository userTypeRepository;
    private InputRepository inputRepository;


    public static Logger logger1= LoggerFactory.getLogger(ConLoader.class);
    @Autowired
    public void seteSourceRepository(ESourceRepository eSourceRepository) {
        this.eSourceRepository = eSourceRepository;
    }
    @Autowired
    public void seteFormatRepository(EFormatRepository eFormatRepository) {
        this.eFormatRepository = eFormatRepository;
    }
    @Autowired
    public void setSectorRepository(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }
    @Autowired
    public void setSysTypeRepository(SysTypeRepository sysTypeRepository) {
        this.sysTypeRepository = sysTypeRepository;
    }
    @Autowired
    public void setUserTypeRepository(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }
    @Autowired
    public void setInputRepository(InputRepository inputRepository) {
        this.inputRepository = inputRepository;
    }

    @Override
    public void onApplicationEvent (ContextRefreshedEvent event){
     /*   Iterable<Sector> inputs=sectorRepository.findAll();
        Iterator it=inputs.iterator();
        while(it.hasNext()){
            System.out.println(((Sector) it.next()).getConS1());
            logger1.info(((Sector) it.next()).getConS1());
        }
*/
    }

}
