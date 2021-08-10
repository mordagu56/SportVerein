package a01065738;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Member implements Comparable <Member> {

	
	private String name ;
	private Map <Sports, Level> sports = new LinkedHashMap<>();

	public Member (String name) {
		if( name == null || name.isEmpty()) { throw new IllegalArgumentException("null or empty");} // throws IllegalArgumentException if name is null or empty
		this.name = name;
		//this.sports = new LinkedHashMap<>();
		}
	
	public Member (String name, Map<Sports, Level> sportsLevelMap ){
		this(name);
		if(sportsLevelMap == null) throw new IllegalArgumentException(" is null");
		if(sportsLevelMap.isEmpty() ) throw new IllegalArgumentException(" is emtpy"); 
		for (Map.Entry<Sports, Level> c : sportsLevelMap.entrySet()) {
			if(c.getValue()== null) throw new IllegalArgumentException(" map is null");
		}
		
		this.sports = new LinkedHashMap<>();
		this.sports.putAll(sportsLevelMap);
	   
	}
	

	public String getName () {
		return name;
		}
   
	public Map<Sports, Level> getSports() {
		Map <Sports, Level> sp = new LinkedHashMap<>() ;
		sp.putAll(sports);
		return sp;
	 }
	
	public Set<Sports>getBillableSports () {
      
		return sports.keySet();
	}
	
	public Level learn ( Sports newSports , Level newLevel ) {
	
	    Level currentLevel = null;
	    for (Map.Entry<Sports, Level> c : sports.entrySet()) {
	    	if(c.getKey().equals(newSports)) {
	    		currentLevel = c.getValue();
	    	}
	    	
	    }
	    
	    if(currentLevel == null) {
	    	sports.put(newSports, Level.BEGINNER);
			return Level.BEGINNER;	
    	}
	  
	    int difference = newLevel.ordinal() - currentLevel.ordinal();
	 
	    if(difference >= 1) {
	    	sports.put(newSports, currentLevel.next());
	    	return currentLevel.next();
	    }
	    
	    return currentLevel;
	    
	}
	
	
	@Override
	public String toString () {
		return String.format("name: %s, sports: %s", name, sports);
	}


	@Override
	public int compareTo(Member member) {
		int result = this.name.compareTo(member.getName());
		return result;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	/*public static Comparator<Member> compareByLevel(){
		return new Comparator<Member>() {
		
			@Override
			public int compare(Member m1, Member m2) {
				return m1.getSports().get(m1.getSports().keySet())
				
			}
			
		};
		
		
		
	}*/

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Member)) {
			  throw new IllegalArgumentException("");
			}
			else return this.name.equals(((Member) obj).getName());
	
	 }
	}


