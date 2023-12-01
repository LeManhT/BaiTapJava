/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 *
 * @author hieud
 */
public class StudentController {

    private ArrayList<Student> arr;
    private StudentView frm;
    private Student st;

    public StudentController() {
        arr = new ArrayList<Student>();
        frm = new StudentView(arr);
        frm.addCreateStudentListener(new CreateStudentListener());
        frm.addDeleteStudentListener(new DeleteStudentListener());
        frm.addEditStudentListener(new EditStudentListener());
        frm.addSortGPAStudentListener(new SortStudentByGPAListener());
        frm.addSortNameStudentListener(new SortStudentByNameListener());
        frm.setVisible(true);
    }

    public void createStudent(Student st) {
        try {
            arr.add(st);
            System.out.println(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class CreateStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                st = frm.getStudent();
                createStudent(st);
                frm.updateTable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void deleteStudent(Student st) {
        try {
            for (Student student : arr) {
                if (student.getId() == st.getId()) {
                    arr.remove(student);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DeleteStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println(arr);
                st = frm.getStudentEdit();
                deleteStudent(st); 
                frm.updateTable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void editStudent(Student st) {
        try {
            for (Student student : arr) {
                if (student.getId() == st.getId()) {
                    student.setName(st.getName());
                    student.setAddress(st.getAddress());
                    student.setGpa(st.getGpa());
                    student.setAge(st.getAge());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class EditStudentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                System.out.println(arr);
                st = frm.getStudentEdit();
                editStudent(st); 
                frm.updateTable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void sortStudentByName() {
        try {
            arr.sort(new StudentNameComparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SortStudentByNameListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                sortStudentByName();
                frm.updateTable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void sortStudentByGPA() {
        try {
            arr.sort(new StudentGPAComparator());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SortStudentByGPAListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                sortStudentByGPA();
                frm.updateTable();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
