package p5.dip2.ioc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainAll {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(MainAll.class);
            PaperApplicationFactory paperApplicationFactory = context.getBean(PaperApplicationFactory.class);
            PaperApplicationAll paperApplicationAll = paperApplicationFactory.getPaperApplicationAll(PaperRepositoryType.Fake);
            List<Paper> papers = paperApplicationAll.getPapers();
            if (papers.size() > 0) {
                for (Paper paper : papers) {
                    System.out.println(paper.getTitle());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}