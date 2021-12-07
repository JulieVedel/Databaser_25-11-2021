package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	DbSql sql = new DbSql();

//	sql.createStuderende();
//	sql.createFag();
//	sql.createStudFag();

	Studerende stud1 = new Studerende(11111, "Kristoffer", "Hansen", "Næstvedvej 35", "4700", "42344106", "DAT1");
	Studerende stud2 = new Studerende(11112, "Jens", "Jensen", "Næstvedvej 32", "4400", "41235466", "DAT2");
	Studerende stud3 = new Studerende(11113, "Peter", "Hansi", "Fensmarkvej 12", "4670", "42341233", "FØN1");
	Studerende stud4 = new Studerende(11114, "Kristine", "Gert", "Lærkevej 5", "4684", "88888888", "FØN2");
	Studerende stud5 = new Studerende(11115, "Kartofel", "Petersen", "Knudvej 1", "4100", "33444106", "DAT1");
	Studerende stud6 = new Studerende(11116, "Per", "Olsen", "Pedersensvej 69", "4200", "44441106", "BYG1");
	Studerende stud7 = new Studerende(11117, "Olemor", "Hansen", "Sejerejevej 420", "4402", "09876543", "BYG1");
	Studerende stud8 = new Studerende(11118, "karin", "Thomsen", "Cedervej 188", "4320", "12345678", "BYG2");
	Studerende stud9 = new Studerende(11119, "Kaj", "Kajsen", "Pilevej 22", "5211", "12458291", "BYG1");
	Studerende stud10 = new Studerende(11120, "Kris", "Kristoffersen", "Tjørnevej 83", "9100", "32229877", "DAT1");

	Studerende[] array = new Studerende[] {stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9, stud10};

//	for (int i = 0; i < 10; i++) {
//		sql.indsaetstud(array[i]);
//	}


		Fag fag1 = new Fag(1, "Virksomheden");
		Fag fag2 = new Fag(2, "Systemudvikling");
		Fag fag3 = new Fag(3, "Programmering");

		Fag[] fagArray = new Fag[] {fag1, fag2, fag3};

//		for (int i = 0; i < 3; i++) {
//			sql.indsaetfag(fagArray[i]);
//		}

//		sql.updatestudklasse(stud1.getStdnr(), fag2.getFagnavn());

		sql.soegstud(11112);

    }
}
