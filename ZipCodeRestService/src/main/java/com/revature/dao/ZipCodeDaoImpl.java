package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.ZipCodes;

public class ZipCodeDaoImpl {
	public static List<ZipCodes> zipList = new ArrayList<>();
	static {
		zipList.add(new ZipCodes(33579, "Riverview", "Florida"));
		zipList.add(new ZipCodes(33559, "Lutz", "Florida"));
		zipList.add(new ZipCodes(30094, "Conyers", "Georgia"));
		zipList.add(new ZipCodes(30038, "Lithonia", "Georgia"));
	}

	public static List<ZipCodes> getAllZipCodes() {
		return zipList;
	}

	public static ZipCodes getInfoByZip(int zipcode) {
		for (ZipCodes z : zipList) {
			if (z.getZipCode() == zipcode) {
				return z;
			}
		}
		return null;
	}

	public static void addZipCode(ZipCodes z) {
		zipList.add(z);
	}

	public static void removeZipCode(int zipcode) {
		for (int i = 0; i < zipList.size(); i++) {
			if (zipList.get(i).getZipCode() == zipcode) {
				zipList.remove(i);
			}
		}
	}
}