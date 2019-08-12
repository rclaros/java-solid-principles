package p2.ocp;

import java.util.ArrayList;
import java.util.List;

public class PricingCalculator implements IPricingCalculator {

	private List<IPriceRule> pricingRules;

	public PricingCalculator() {
		pricingRules = new ArrayList<IPriceRule>();
		pricingRules.add(new EachPriceRule());
		pricingRules.add(new PerGramPriceRule());
		pricingRules.add(new SpecialPriceRule());
		pricingRules.add(new Buy4GetOneFree());
	}

	public double calculatePrice(OrderItem item) {
		return pricingRules.stream().filter(i -> i.isMatch(item)).findFirst().get().calculatePrice(item);
		// C#
		// pricingRules.First(i => i.IsMatch(item)).CalculatePrice(item);
	}
}