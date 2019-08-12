package p5.dip2.ioc;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class PaperApplicationAll {
    @Autowired
    private Map<String, PaperRepository> paperRepositories;

    private PaperRepository paperRepository;

    public PaperApplicationAll(Map<String, PaperRepository> paperRepositories) {
        this.paperRepositories = paperRepositories;
    }

    public void setPaperRepository(PaperRepositoryType paperRepositoryType) {
        this.paperRepository = this.paperRepositories.get(paperRepositoryType.name());
    }

    public List<Paper> getPapers() {
        return this.paperRepository.getPapers();
    }
}
