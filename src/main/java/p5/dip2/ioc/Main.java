package p5.dip2.ioc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
            PaperApplicationFactory paperApplicationFactory = context.getBean(PaperApplicationFactory.class);
            PaperApplication paperApplication = paperApplicationFactory.getPaperApplication(PaperRepositoryType.SQLServer);
            List<Paper> papers = paperApplication.getPapers();
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