package set;

import java.util.ArrayList;
import java.util.Collections;

import data.SetData;
import tile.Tile;

@SuppressWarnings("serial")
public class Set extends ArrayList<Tile> implements SetData {
	public boolean isValid() {
		return size()>=3&&setType()!=-1;
	}

	public int setType() {
		boolean sameValues = true, isRun = true;
		sort();
		for (int i = 1;i<size();i++) {
			if (get(i).getValue()!=get(i-1).getValue()) {
				sameValues = false;//don't have same value
			}
			else {
				isRun = false;//have same value
			}
			if (get(i).getValue()-1!=get(i-1).getValue()) {
				isRun = false;//aren't in sequence
			}
			if (get(i).getColor()!=get(i-1).getColor()) {
				isRun = false;//different colors
			}
			else {
				sameValues = false;//have the same color
			}
		}
		if (size()<3) return -1;
		if (sameValues) return SAME;
		if (isRun) return RUN;
		return -1;
	}
	
	public boolean add(Tile tile, boolean enforceValid) {
		Set newSet = new Set();
		for (int i = 0;i<size();i++) {
			newSet.add(get(i));
		}
		newSet.add(tile);
		boolean valid = newSet.isValid();
		if (!enforceValid||valid) {
			add(size(), tile);
		}
		sort();
		return valid;
	}

	public void split(int secondStart, ArrayList<Set> allSets) {
		allSets.remove(this);
		Set first = new Set(), second = new Set();
		for (int i = 0;i<size();i++) {
			if (i<secondStart) {
				first.add(get(i));
			}
			else {
				second.add(get(i));
			}
		}
		first.sort();
		second.sort();
		allSets.add(first);
		allSets.add(second);
	}
	
	public void sort() {
		Collections.sort(this);
	}
}
