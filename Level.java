package a01065738;

public enum Level {
	BEGINNER ("Anfänger"),
	NORMAL ("Normal") ,
	ADVANCED ("Fortgeschritten") ,
	PROFESSIONAL ("Profi") ;
	
	
	String mappedName ;
	Level(String mappedName) {
		if(mappedName == null || mappedName.isEmpty() ) throw new IllegalArgumentException(" is null or empty"); // constructor ( check for valid values !) + getter
		if(mappedName.equals("Anfänger") || mappedName.equals("Normal") || mappedName.equals("Fortgeschritten") || mappedName.equals("Profi") ) {
			this.mappedName = mappedName;
			
		}
		else {
			
			throw new IllegalArgumentException("darf nicht leer");
		}
	}
	
	String getMappedName() {
		
		return mappedName;
	}
	
	public Level next() {
		return Level.values()[this.ordinal()] == Level.PROFESSIONAL ? Level.PROFESSIONAL : Level.values()[this.ordinal() + 1];
	}
	@Override
	public String toString () {
		return mappedName;}
	};
