package PJ_AccountBook.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import PJ_AccountBook.IncomeExpense;
//권기은 개발
public class FileServiceImp implements FileService{
	

	@Override
	public List<IncomeExpense> load(String fileName) {
		try (ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream(fileName))){
			return (List<IncomeExpense>) ois.readObject();
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public boolean save(String fileName, List<IncomeExpense> list) {
		try(ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(list);
			return true;
		} catch (Exception e) {

		}
		return false;
		
	}
	
}
