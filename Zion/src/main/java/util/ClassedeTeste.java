package util;

import java.text.NumberFormat;

import org.junit.Test;

public class ClassedeTeste {
	
	@Test 
	public void testando() {
				
		
		NumberFormat formatador = NumberFormat.getPercentInstance();
					
		
		
		formatador.setMinimumFractionDigits(2);
		formatador.setMaximumFractionDigits(4);		
		formatador.setGroupingUsed(true);
		
		

		
	}

}
