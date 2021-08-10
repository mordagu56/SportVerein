package a01065738;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;



public class SportsClub {
	private String name ;
	private BigDecimal feePerSports ;
	private Set<Member>members = new LinkedHashSet<>();
	private Map<Sports, Set<Trainer>> offeredSports = new LinkedHashMap<>() ;


	public SportsClub (String name, BigDecimal feePerSports) {
		if( name== null || name.isEmpty() ) throw new IllegalArgumentException("is null or empty");
		if(feePerSports == null) throw new IllegalArgumentException("feePerSports is null"); 
		 this.name=name;
		 this.feePerSports=feePerSports;
		}

	public String getName () {return this.name;}
	public BigDecimal getFeePerSports () {return this.feePerSports;}
	public Set<Member>getMembers() {
		Set<Member> sp= new HashSet<>();
		sp.addAll(members);
		return sp;
		}

	public Set<Sports>getSports() {
		Set<Sports>sp = new LinkedHashSet<>();
		this.offeredSports.forEach((sport,trainer)->{
			sp.add(sport);
		});
		return sp;
		}
	
	public BigDecimal calculateMembershipFee (Member member) {
		BigDecimal fb = new BigDecimal(0);
		if(!this.members.contains(member)) throw new IllegalArgumentException("doesnt contain");
		for (Sports c : member.getBillableSports()) {
			if(offeredSports.containsKey(c)) {
				fb = fb.add(c.getFee(this.feePerSports));	
			}
			
		}
		
		return fb;	
	}
	
	public boolean registerSports (Member member, Sports sports, Level level){
		if(!this.getMembers().contains(member)) throw new IllegalArgumentException("member is null");
		if (!members.contains(member)) {
            throw new IllegalArgumentException("!!!!!!");
        }
		boolean avaible=false;
		if( offeredSports.containsKey(sports)) {
			for( Trainer t : offeredSports.get(sports)) {
				if(t.getAccreditations().get(sports).ordinal() >= level.ordinal()) { avaible=true;}
			}
		if(!avaible) {return false; }
		member.learn(sports,  level);
		if(member.getSports().get(sports).ordinal() == level.ordinal()) {
			return true;
		}
		
		else { return false; }
		}
		return false;
	}
	
	public boolean addMember(Member member) {
		if(!this.members.contains(member)) {	
			if(member instanceof Trainer) {
				for (Map.Entry<Sports, Level> c : ((Trainer) member).getAccreditations().entrySet()) {
					if(!offeredSports.containsKey(c.getKey())) {
						Set<Trainer> set = new HashSet<>();
						set.add(((Trainer) member));
						offeredSports.put(c.getKey(), set);
						
					}
					else {
						offeredSports.get(c.getKey()).add((Trainer) member);
						
					}
					
				}
			}
				members.add(member);
				
				return true;
		}
			return false;
			}
	
	public boolean removeMember ( Member member ) {
	 if(member != null) {
		if(member instanceof Trainer) {
			for(Sports s: ((Trainer) member).getAccreditations().keySet()) {
				this.offeredSports.get(s).remove(((Trainer) member));
				if(this.offeredSports.get(s).size()==0) {
					this.offeredSports.remove(s);
				}
			}
		 }
		}
		return this.members.remove(member);
	  }
	
	@Override
	public String toString () {
		return String.format("SportsClub[name: %s, feePerSports: %s, offeredSports: %s]", name, feePerSports, offeredSports);
	}


}
