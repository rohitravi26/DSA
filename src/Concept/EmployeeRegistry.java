package Concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface EmployeeRegistry {


        void addEmployee(int employeeId, String department);
        void updateEmployee(int employeeId, String department);
        List<Integer> reportEmployees(String department);
    }

//
//class EmployeeRegistryImpl implements EmployeeRegistry{
//    Map<String,List<Integer>> map;
//public EmployeeRegistryImpl(Map<String,Integer> map){
//    this.map = new ConcurrentHashMap<>();
//}
//
//    @Override
//    public void addEmployee(int employeeId, String department) {
////    List<>
////    if(map.get(department)==null)
////        map.put(department,employeeId);
//    }
//
//    @Override
//    public void updateEmployee(int employeeId, String department) {
//        //map.get()
//    }
//
//    @Override
//    public List<Integer> reportEmployees(String department) {
//        List<Integer> allEmp = new ArrayList<>();
////        Map.Entry<Integer,String> it = map.entrySet();
////
////        for(it:map){
////
////            if(it.getValue()==department){
////                allEmp.add(it.getKey());
////            }
////        }
//        return allEmp;
//
//
//    }
//}
//
//class Employee{
//
//    int employeeid;
//
//}
//Person | Hobby
//        ----------------
//        John         | Movies
//        John         | Baseball
//        Sameer       | Reading
//        Sameer       | Music
//
//
//
//
//
//
//
//select distinct person from hobbyList where person not in (
//select distinct person from hobbyList where hobby='Reading');