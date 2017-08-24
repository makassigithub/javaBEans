package javaBeans;

import java.io.Serializable;
import java.beans.*;

public class MonBean03 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Targeted property
	protected int valeur;
	PropertyChangeSupport changeSupport;
	
	//Register each instance of this object to a property change support
	public MonBean03() {
		valeur = 0;
		changeSupport = new PropertyChangeSupport(this);
	}
    
	
	//make it thread safe
	public synchronized void setValeur(int val) {
		int oldValeur = valeur;
		valeur = val;
		
		//Each Time the property is set, fire change event
		// firePropertyChange("property name in String", oldValeur, new value);
		changeSupport.firePropertyChange("valeur", oldValeur, valeur);
	}
	
	//make it thread safe
	public synchronized int getValeur() {
		return valeur;
	}
	
   // make it possible to add listeners to each instance
	public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	// make it possible to remove listeners to each instance
	public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}
}