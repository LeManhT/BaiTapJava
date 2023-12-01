/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helloworld;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
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

public class StudentForm {
    private static void addComponentToLayout(JPanel panel, GridBagConstraints constraints, JComponent component,
                                             int gridx, int gridy, int ipadx, int ipady, Insets insets) {
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.ipadx = ipadx;
        constraints.ipady = ipady;
        constraints.insets = insets;
        panel.add(component, constraints);
    }

    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<Student>();
        DefaultTableModel model = new DefaultTableModel();
        //create button
        JButton btnAdd = new JButton("ADD");
        JButton btnEdit = new JButton("EDIT");
        JButton btnDelete = new JButton("DELETE");
        JButton btnClear = new JButton("CLEAR");
        JButton btnGpaSort = new JButton("SORT BY GPA");
        JButton btnNameSort = new JButton("SORT BY NAME");
        JPanel panel_btn_bot = new JPanel();
        panel_btn_bot.setLayout(new GridLayout(0, 2));

        //create field input
        JLabel lbId = new JLabel("Student ID");
        JLabel lbName = new JLabel("Student Name");
        JLabel lbAge = new JLabel("Age");
        JLabel lbAddress = new JLabel("Address");
        JLabel lbGpa = new JLabel("GPA");
        JTextField txtId = new JTextField(5);
        txtId.setEnabled(false);
        JTextField txtName = new JTextField(20);
        JTextField txtAge = new JTextField(20);
        JTextArea txtAddress = new JTextArea(2, 20);
        JTextField txtGpa = new JTextField(20);
        //jpanel for student field
        JPanel jp_student = new JPanel();
        GridBagLayout layout_jp_student = new GridBagLayout();
        GridBagConstraints constraint_layout_student = new GridBagConstraints();
        jp_student.setLayout(layout_jp_student);
        addComponentToLayout(jp_student, constraint_layout_student, lbId, 0, 0, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lbName, 0, 1, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lbAge, 0, 2, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lbAddress, 0, 3, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, lbGpa, 0, 4, 0, 0, new Insets(20, 20, 40, 40));

        addComponentToLayout(jp_student, constraint_layout_student, txtId, 1, 0, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, txtName, 1, 1, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, txtAge, 1, 2, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, txtAddress, 1, 3, 0, 0, new Insets(20, 20, 40, 40));
        addComponentToLayout(jp_student, constraint_layout_student, txtGpa, 1, 4, 0, 0, new Insets(20, 20, 40, 40));
        //bot left layout panel
        JPanel panel_button = new JPanel();
        panel_button.setLayout(new GridLayout(0, 4));
        panel_button.add(btnAdd);
        panel_button.add(btnEdit);
        panel_button.add(btnDelete);
        panel_button.add(btnClear);
        //left layout panel
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(panel_button, BorderLayout.SOUTH);
        panelLeft.add(jp_student, BorderLayout.NORTH);

        panel_button.add(btnGpaSort);
        panel_button.add(btnNameSort);

        JPanel panelRight = new JPanel();

        //create table
        JTable table = new JTable(model);
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
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(txtName.getText(), Integer.parseInt(txtAge.getText()), txtAddress.getText(), Float.parseFloat(txtGpa.getText()));
                arr.add(s);
                model.insertRow(model.getRowCount(), new Object[]{s.id, s.name, s.age, s.address, s.gpa});
                model.fireTableDataChanged();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtId.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtAddress.setText("");
                txtGpa.setText("");
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("true");
                    for (Student st : arr) {
                        System.out.println(st.getId() + "=" + txtId.getText());
                        if (st.getId() == Integer.parseInt(txtId.getText())) {
                            System.out.println(st.getId());
                            st.setId(Integer.parseInt(txtId.getText()));
                            st.setName(txtName.getText());
                            st.setAge(Integer.parseInt(txtAge.getText()));
                            st.setAddress(txtAddress.getText());
                            st.setGpa(Float.parseFloat(txtGpa.getText()));
                            model.setRowCount(0); // Xóa tất cả các hàng trong tableModel
                            for (Student student : arr) {
                                model.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getAge()});
                            }
                        }
                    }
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    System.out.println("true");
                    for (Student st : arr) {
                        System.out.println(st.getId() + "=" + txtId.getText());
                        if (st.getId() == Integer.parseInt(txtId.getText())) {
                            arr.remove(st);
                            model.setRowCount(0); // Xóa tất cả các hàng trong tableModel
                            for (Student student : arr) {
                                model.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getAge()});
                            }

                        }
                    }

                }
            }
        });
        btnGpaSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(arr);
                model.setRowCount(0); // Xóa tất cả các hàng trong tableModel
                for (Student student : arr) {
                    model.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getGpa()});
                }
            }
        });
        btnNameSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arr.sort(new StudentComparator());
                model.setRowCount(0); // Xóa tất cả các hàng trong tableModel
                for (Student student : arr) {
                    model.addRow(new Object[]{student.getId(), student.getName(), student.getAge(), student.getAddress(), student.getGpa()});
                }
            }
        });
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Sự kiện được gọi khi người dùng chọn hoặc hủy chọn một dòng
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    Integer id = (Integer) table.getValueAt(selectedRow, 0);
                    String name = (String) table.getValueAt(selectedRow, 1);
                    Integer age = (Integer) table.getValueAt(selectedRow, 2);
                    String address = (String) table.getValueAt(selectedRow, 3);
                    Float gpa = (Float) table.getValueAt(selectedRow, 4);
                    System.out.println("click on");
                    txtId.setText(id + "");
                    txtName.setText(name);
                    txtAge.setText(age + "");
                    txtAddress.setText(address);
                    txtGpa.setText(gpa + "");
                }
            }
        });
        //layout setting for frame
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout());
        f.setSize(300, 300);
        f.add(panelLeft, BorderLayout.WEST);
        f.add(new JScrollPane(table), BorderLayout.EAST);
        f.add(panel_btn_bot, BorderLayout.SOUTH);
        f.setSize(1000, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
