package fit5042.tutex.calculator;

import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Property;

/**
 * @author:Keyang Wang
 * @version:
 * @create time：17 Aug 2020 2:24:17 pm
 * @desc:
 */
@Remote
public interface CompareProperty {
	void addProperty(Property property);

	void removeProperty(Property property);

	int getBestPerRoom();
}
