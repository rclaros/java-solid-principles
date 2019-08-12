package p5.dip2.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("CSV")
public class PaperCSVRepository implements PaperRepository {
	public List<Paper> getPapers() {
		List<Paper> papers = new ArrayList<Paper>();
		papers.add(new Paper("Paper1 from CSV"));
		papers.add(new Paper("Paper2 from CSV"));
		papers.add(new Paper("Paper3 from CSV"));
		return papers;
	}
}