package fit5042.tutex.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

import fit5042.tutex.repository.constants.CommonInstance;
import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
//this class is connect to the DB
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {
	private ArrayList<Property> propertyList;
	
	public JPAPropertyRepositoryImpl() {
    	propertyList = new ArrayList<Property>();
    	this.initialisePropertyList();
    }
	
	public void initialisePropertyList() {
    	propertyList.clear();
    	
    	propertyList.add(CommonInstance.PROPERTY_FIRST);
    	propertyList.add(CommonInstance.PROPERTY_SECOND);
    	propertyList.add(CommonInstance.PROPERTY_THIRD);
    	propertyList.add(CommonInstance.PROPERTY_FOURTH);
    }

	public ArrayList<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(ArrayList<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	public void removeProperty(int propertyId) {
    	for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			propertyList.remove(p);
    			break;
    		}
    	}
    	
    }
    
    public void addProperty(Property property) {
    	propertyList.add(property);
    }
    
    public void editProperty(Property property) {
    	for (Property p : propertyList) {
    		int id = property.getPropertyId();
    		if (p.getPropertyId() == id) {
    			propertyList.set(id, property);
    			break;
    		}
    	}
    }

	public int getPropertyId() {
		return propertyList.get(propertyList.size() - 1).getPropertyId();
	}
	
	public Property searchPropertyById(int propertyId) {
		for (Property p : propertyList) {
    		if (p.getPropertyId() == propertyId) {
    			return p;
    		}
    	}
		return null;
	}
	
	public List<ContactPerson> getAllContactPeople() {
		Set<ContactPerson> contactPersonSet = new HashSet<>();
		
		//This method will returns all the contact person in a list without duplication
        //Please write your code here		
		for (int i = 0; i < propertyList.size(); i++) {
			contactPersonSet.add(propertyList.get(i).getContactPerson());
		}	
//		change the set to list and find a no duplicate list
		ArrayList<ContactPerson> contactPersonList = new ArrayList<ContactPerson>(contactPersonSet);		
		return contactPersonList;
	}
	
	public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) {
		Set<Property> propertySet = new HashSet<>();
		
        //This method will find all the properties which belong to the particular contact person
		//Please write your code here
		for (int i = 0; i < propertyList.size(); i++) {
			if (propertyList.get(i).getContactPerson().equals(contactPerson)) {
				propertySet.add(propertyList.get(i));
			}
		}
		
		return propertySet;
	}
	
	public List<Property> searchPropertyByBudget(double budget) {
		List<Property> properties = new ArrayList<>();
		
        //This method will return a list of properties that satisfy the criteria of bellowing a specific budget
		//Please write your code here
		for (int i = 0; i < propertyList.size(); i++) {
			if(propertyList.get(i).getPrice() == budget)
				properties.add(propertyList.get(i));
		}
		
		return properties;
    }

}
