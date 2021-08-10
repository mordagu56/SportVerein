package a01065738;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Trainer extends Member {
	
	private Map<Sports, Level> accreditations ;

	
	public Trainer (String name, Map<Sports, Level> accreditations) {
		super(name,accreditations);
		this.accreditations =new LinkedHashMap<>();
		this.accreditations.putAll(accreditations);
	
		}
	
	public Map<Sports, Level>getAccreditations() {
		Map <Sports, Level> sp = new LinkedHashMap<>() ;
		sp.putAll(accreditations);
		return sp;
		}

	
	@Override
	public Set<Sports>getBillableSports() { // ==> test edilmesi gerekli!!
		Set<Sports> sp= new HashSet<>();
		Set<Sports> sport = new HashSet<>();
		sport.addAll(super.getBillableSports());
		for(Sports s: sport ) { 
			if(!accreditations.containsKey(s)) {
				sp.add(s);
			}		
		}
	
		return sp;
	}
	
	@Override
	public String toString () {
		return super.toString() + String.format(", accreditations: %s", this.accreditations);
	
	}

	
	
}
