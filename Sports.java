package a01065738;

import java.math.BigDecimal;

public enum Sports {
	ARCHERY ,
	BASKETBALL ,
	CLIMBING {
		@Override
		public BigDecimal getFeeFactor() {
			return BigDecimal.valueOf(1.2);
		}
	} ,
	DIVING {
		@Override
		public BigDecimal getFeeFactor() {
			return BigDecimal.valueOf(1.8);
		}
	} ,
	FOOTBALL ,
	GOLF {
		@Override
		public BigDecimal getFeeFactor() {
			return BigDecimal.valueOf(2.1);
		}
	},
	HANDBALL ,
	HOCKEY ,
	MOUNTAINBIKING ,
	PARKOUR ;
	public BigDecimal getFeeFactor () {
		return BigDecimal.valueOf(1.0);
		}
	
	public BigDecimal getFee ( BigDecimal feePerSports ) {
		
		return feePerSports.multiply(getFeeFactor()) ;
	}
	};

