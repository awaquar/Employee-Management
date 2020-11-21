package com.hussain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.SetOptions;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hussain.model.Employee;

@Service
public class EmployeeService {

	public String saveEmployee(Employee employee) {
		if (isDocumentAvailable(employee.getEmpId()))
			return null;

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> future = dbFirestore.collection("Employee").document(employee.getEmpId()).set(employee,
				SetOptions.merge());
		return employee.getEmpId();

	}

	public String saveOrUpdateEmployee(Employee employee) {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> future = dbFirestore.collection("Employee").document(employee.getEmpId()).set(employee);
		return employee.getEmpId();

	}

	public boolean deleteEmployee(String empId) {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("Employee").document(empId).delete();
		return true;

	}

	public Employee getEmployee(String empId) {
		Employee employee = null;

		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference docRef = dbFirestore.collection("Employee").document(empId);
		ApiFuture<DocumentSnapshot> future = docRef.get();
		try {
			DocumentSnapshot document = future.get();
			employee = document.toObject(Employee.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();

		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = dbFirestore.collection("Employee").get();
		List<QueryDocumentSnapshot> documents;
		try {
			documents = future.get().getDocuments();
			for (DocumentSnapshot document : documents) {
				employees.add(document.toObject(Employee.class));
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return employees;
	}

	private boolean isDocumentAvailable(String docId) {

		Firestore dbFirestore = FirestoreClient.getFirestore();

		DocumentReference docRef = dbFirestore.collection("Employee").document(docId);
		ApiFuture<DocumentSnapshot> future = docRef.get();
		try {
			DocumentSnapshot document = future.get();
			return document.exists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
