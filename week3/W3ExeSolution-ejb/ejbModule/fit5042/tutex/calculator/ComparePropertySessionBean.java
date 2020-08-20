package fit5042.tutex.calculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;

import fit5042.tutex.repository.entities.Property;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：17 Aug 2020 2:37:33 pm
 * @desc:
 */
@Stateful
public class ComparePropertySessionBean implements CompareProperty {
	private Set<Property> list;

	public ComparePropertySessionBean() {
		// TODO Auto-generated constructor stub
		list = new HashSet<Property>();
	}

	@Override
	public void addProperty(Property property) {
		// TODO Auto-generated method stub
		list.add(property);

	}

	@Override
	public void removeProperty(Property property) {
		// TODO Auto-generated method stub
		for (Property p : list) {
			if (p.getPropertyId() == property.getPropertyId()) {
				list.remove(p);
				break;
			}
		}

	}

	@Override
	public int getBestPerRoom() {
		// TODO Auto-generated method stub
		Integer bestId = 0;
		int numberOfRooms;
		double price;
		double bestPerRoom = 1000000.00;
		for (Property p : list) {
			numberOfRooms = p.getNumberOfBedrooms();
			price = p.getPrice();
			if (price / numberOfRooms < bestPerRoom) {
				bestPerRoom = price / numberOfRooms;
				bestId = p.getPropertyId();
			}
		}
		return bestId;
	}

}
