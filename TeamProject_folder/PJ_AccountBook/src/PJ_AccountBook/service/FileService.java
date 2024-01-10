package PJ_AccountBook.service;

import java.util.List;

import PJ_AccountBook.IncomeExpense;

public interface FileService {

	List<IncomeExpense> load(String fileName);

	boolean save(String fileName, List<IncomeExpense> list);
	
}
