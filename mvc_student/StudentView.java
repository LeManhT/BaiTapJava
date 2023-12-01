/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc_student;

import helloworld.StudentComparator;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Float.parseFloat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hieud
 */
public class StudentView extends JFrame implements ActionListener {

    private JTable table;
    private DefaultTableModel model;
    private JButton b_add, b_edit, b_delete, b_clear, b_gpa_sort, b_name_sort;
    private JTextField text_id, text_name, text_age, text_gpa;
    private JTextArea text_address;
    private ArrayList<Student> arr;

    private static void addComponentToLayout(JPanel panel, GridBagConstraints constraints, JComponent component,
            int gridx, int gridy, int ipadx, int ipady, Insets insets) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        constraints.insets = insets;
        panel.add(component, constraints);
    }

    public StudentView(ArrayList<Student> arrStudent) {
        arr = arrStudent;
        model = new DefaultTableModel();
        //create button
        b_add = new JButton("ADD");
        b_edit = new JButton("EDIT");
        b_delete = new JButton("DELETE");
        b_clear = new JButton("CLEAR");
        b_gpa_sort = new JButton("SORT BY GPA");
        b_name_sort = new JButton("SORT BY NAME");
        JPanel panel_btn_bot = new JPanel();
        panel_btn_bot.setLayout(new GridLayout(0, 2));
        panel_btn_bot.add(b_gpa_sort);
        panel_btn_bot.add(b_name_sort);
        //create field input
        JLabel lb_id = new JLabel("Id");
        JLabel lb_name = new JLabel("Name");
        JLabel lb_age = new JLabel("Age");
        JLabel lb_address = new JLabel("Address");
        JLabel lb_gpa = new JLabel("GPA");
        text_id = new JTextField(20);
        text_id.setEnabled(false);
        text_name = new JTextField(20);
        text_age = new JTextField(20);
        text_address = new JTextArea(2, 20);
        text_gpa = new JTextField(20);
        //jpanel for student field
        JPanel jp_student = new JPanel();
        GridBagLayout layout_jp_student = new GridBagLayout();
        GridBagConstraints constraint_layout_student = new GridBagConstraints();
        jp_student.setLayout(layout_jp_student);
        addComponentToLayout(jp_student, constraint_layout_student, lb_id, 0, 0, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lb_name, 0, 1, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lb_age, 0, 2, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lb_address, 0, 3, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lb_gpa, 0, 4, 0, 0, new Insets(20, 20, 40, 40));

        addComponentToLayout(jp_student, constraint_layout_student, text_id, 1, 0, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, text_name, 1, 1, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, text_age, 1, 2, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, text_address, 1, 3, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, text_gpa, 1, 4, 0, 0, new Insets(20, 20, 40, 40));
        //bot left layout panel
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new GridLayout(0, 4));
        panel_button.add(b_add);
        panel_button.add(b_edit);
        panel_button.add(b_delete);
        panel_button.add(b_clear);
        //left layout panel
        JPanel panel_left = new JPanel();
        panel_left.setLayout(new BorderLayout());
        panel_left.add(panel_button, BorderLayout.SOUTH);
        panel_left.add(jp_student, BorderLayout.NORTH);

        //create table
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Address");
        model.addColumn("Age");
        model.addColumn("GPA");
        for (Student st : arr) {
            model.addRow(new Object[]{st.id, st.name, st.age, st.address, st.gpa});
        }

        //action listener
        b_add.addActionListener(this);
        b_clear.addActionListener(this);
        b_edit.addActionListener(this);
        b_delete.addActionListener(this);
        b_gpa_sort.addActionListener(this);
        b_name_sort.addActionListener(this);
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectRow_ActionPerform();
            }
        });
        //layout setting for frame

        this.setLayout(new BorderLayout());
        this.setSize(300, 300);
        this.add(panel_left, BorderLayout.WEST);
        this.add(new JScrollPane(table), BorderLayout.EAST);
        this.add(panel_btn_bot, BorderLayout.SOUTH);
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.equals(b_clear)) {
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text_id.setText("");
                    text_name.setText("");
                    text_age.setText("");
                    text_address.setText("");
                    text_gpa.setText("");
                }
            });
        }

    }

    public void setArrayStudent(ArrayList<Student> arrStudent) {
        arr = arrStudent;
    }
//             b_add, b_edit, b_delete, b_clear, b_gpa_sort, b_name_sort

    public Student getStudent() {
        Student st = new Student();
        st.setName(text_name.getText());
        st.setAge(Integer.parseInt(text_age.getText()));
        st.setAddress(text_address.getText());
        st.setGpa(Float.parseFloat(text_gpa.getText()));

        System.out.println(st.getId());
        return st;
    }

    public Student getStudentEdit() {
        Student st = new Student(Integer.parseInt(text_id.getText()),text_name.getText(),Integer.parseInt(text_age.getText()),text_address.getText(),Float.parseFloat(text_gpa.getText()));
        
        
        System.out.println(st.getId());
        return st;
    }

    public void updateTable() {
        model.setRowCount(0); // Xóa tất cả các hàng trong tableModel
        for (Student student : arr) {
            model.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getGpa()});
        }
    }

    public void addCreateStudentListener(ActionListener al) {
        b_add.addActionListener(al);
    }

    public void addDeleteStudentListener(ActionListener al) {
        b_delete.addActionListener(al);

    }

    public void addEditStudentListener(ActionListener al) {
        b_edit.addActionListener(al);

    }

    public void addSortNameStudentListener(ActionListener al) {
        b_name_sort.addActionListener(al);

    }

    public void addSortGPAStudentListener(ActionListener al) {
        b_gpa_sort.addActionListener(al);

    }

    public void selectRow_ActionPerform() {
        System.out.println("hello");
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            Integer id = (Integer) table.getValueAt(selectedRow, 0);
            String name = (String) table.getValueAt(selectedRow, 1);
            Integer age = (Integer) table.getValueAt(selectedRow, 2);
            String address = (String) table.getValueAt(selectedRow, 3);
            Float gpa = (Float) table.getValueAt(selectedRow, 4);
            System.out.println("click on");
            text_id.setText(id + "");
            text_name.setText(name);
            text_age.setText(age + "");
            text_address.setText(address);
            text_gpa.setText(gpa + "");
        }
    }
}
