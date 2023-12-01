/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_student;

import java.util.Comparator;

/**
 *
 * @author hieud
 */
public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        // Viết logic so sánh dựa trên các trường của Student (ví dụ: điểm, tuổi, ...)
        // Trả về số âm nếu student1 < student2, 0 nếu student1 == student2, số dương nếu student1 > student2
        return student1.getName().compareTo(student2.getName());
    }
}