package es.hol.piotrkrzyminski.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Model {
	private int[] pesel = new int[11]; //tablica liczb calkowitych przechowujaca cyfry ciagu peselString
	private String peselString; //ciag liczb pobrany z pola tekstowego
	
	
	/**
	 * przypisz wartosc polu peselString pobranej z pola tekstowego
	 * je¿eli pobrany ciag jest zgodny z wyrazeniem regularnym to rozbij ten ciag na tablice liczb calkowitych
	 * oblicz czy cyfra kontolna jest poprawna i zwroc prawde albo falsz
	 * @param peselString
	 * @return
	 */
	public boolean checkPESEL(String peselString) {
		this.peselString = peselString;
		if(isPeselFormatValid())
			convertStringToArray();
		else
			return false;
		
		if(isValid())
			return true;
		return false;
	}
	
	/**
	 * przypisz cyfry z ciagu peselString do tablicy liczb calkowitych
	 */
	private void convertStringToArray() {
		for(int i=0; i<peselString.length(); i++) {
			pesel[i] = Integer.parseInt(String.valueOf(peselString.charAt(i)));
		}
	}
	
	/**
	 * za pomoca wyrazenia regularnego sprawdz czy podany ciag spelnia warunki i zwroc wynik logiczny
	 * @return
	 */
	public boolean isPeselFormatValid() {
		Pattern pattern = Pattern.compile("[0-9]{11}");
		Matcher matcher = pattern.matcher(peselString);
		
		if(matcher.find() && peselString.length()==11)
			return true;
		return false;
	}
	
	/**
	 * oblicz czy liczba kontrolna jest poprawna i zwroc wynik
	 * @return
	 */
	private boolean isValid() {
		
		int suma = 0;
		for(int i=0; i<10; i++) {
			int mnoznik;
			
			switch((i+1)%4) {
				case 1:
					mnoznik=9;
					break;
				case 2:
					mnoznik=7;
					break;
				case 3:
					mnoznik=3;
					break;
				default:
					mnoznik=1;
			}
			suma+=mnoznik*pesel[i];
		}
		
		if(suma%10==pesel[pesel.length-1])
			return true;
		
		return false;
	}
}
