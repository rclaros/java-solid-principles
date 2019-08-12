package p5.dip2.ioc;

import java.util.*;

import org.springframework.stereotype.Service;

@Service()
public class PaperApplication {
    private PaperRepository paperRepository;

    public PaperApplication() {
    }

    public void setPaperRepository(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> getPapers() {
        return this.paperRepository.getPapers();
    }
}