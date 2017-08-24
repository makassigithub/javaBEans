package javaBeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Test {
	public static void main(String[] args) {
		new Test();
	}

	public Test() {
		MonBean03 monBean = new MonBean03();
		monBean.addPropertyChangeListener(
				new PropertyChangeListener() {
					
					@Override
			        public void propertyChange(PropertyChangeEvent event) {
				    System.out.println("propertyChange : valeur = " + event.getNewValue());
			}
		});
		System.out.println("valeur = " + monBean.getValeur());
		monBean.setValeur(10);
		System.out.println("valeur = " + monBean.getValeur());
	}
}
