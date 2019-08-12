package p5.dip2.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PaperApplicationFactory {
    @Autowired
    private ApplicationContext context;

    public PaperApplication getPaperApplication(PaperRepositoryType paperRepositoryType) {
        try {
            PaperApplication paperApplication = context.getBean(PaperApplication.class);
            PaperRepository paperRepository;
            switch (paperRepositoryType) {
                case MySQL: paperRepository = context.getBean(PaperMySQLRepository.class); break;
                case SQLServer: paperRepository = context.getBean(PaperSQLServerRepository.class); break;
                case CSV: paperRepository = context.getBean(PaperCSVRepository.class); break;
                case Fake: paperRepository = context.getBean(PaperFakeRepository.class); break;
                default:  paperRepository = context.getBean(PaperMySQLRepository.class); break;
            }
            paperApplication.setPaperRepository(paperRepository);
            return paperApplication;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public PaperApplicationAll getPaperApplicationAll(PaperRepositoryType paperRepositoryType) {
        try {
            PaperApplicationAll paperApplicationAll = context.getBean(PaperApplicationAll.class);
            paperApplicationAll.setPaperRepository(paperRepositoryType);
            return paperApplicationAll;
        } catch (Exception ex) {
            throw ex;
        }
    }
}