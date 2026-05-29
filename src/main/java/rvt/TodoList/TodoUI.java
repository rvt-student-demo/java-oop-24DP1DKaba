package rvt.TodoList;

import javax.swing.JFrame;

public class TodoUI {
    private JFrame window;

    public TodoUI() {
        initialize();
    }

    private void initialize() {
        window = new JFrame("Todo App");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(1024, 768);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }

    public void show() {
        window.setVisible(true);
    }
}
