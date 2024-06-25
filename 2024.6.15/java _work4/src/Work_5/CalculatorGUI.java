package Work_5;

/**
 * program: java _work4
 * <p>
 * description: Java图形化设计一个计算器
 * <p>
 * author: xiaoxie
 * <p>
 * create: 2024-06-15 23:04
 **/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {
    private JTextField input1, input2, result;
    private JButton[] operatorButtons = new JButton[4]; // 假设有4个运算符：+, -, *, /
    private JButton okButton;
    private String operator = "";

    public CalculatorGUI() {
        setTitle("Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3, 5, 5)); // 3行3列的网格布局

        // 创建文本框
        input1 = new JTextField(5);
        input2 = new JTextField(5);
        result = new JTextField(5);
        result.setEditable(false); // 结果文本框不可编辑

        // 添加文本框到界面
        add(input1);
        add(input2);
        add(result);

        // 创建按钮并添加到界面
        for (int i = 0; i < 4; i++) {
            operatorButtons[i] = new JButton(String.valueOf("+-*/".charAt(i)));
            add(operatorButtons[i]);
            operatorButtons[i].addActionListener(new OperatorButtonListener());
        }

        // 创建OK按钮并添加到界面
        okButton = new JButton("OK");
        add(okButton);
        okButton.addActionListener(new OkButtonListener());
    }

    // 运算符按钮的事件监听器
    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            operator = clickedButton.getText();
            // 假设第一行第1个按钮是运算符按钮，这里可以修改为实际的逻辑
            operatorButtons[0].setText(operator);
        }
    }

    // OK按钮的事件监听器
    private class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(input1.getText());
                double num2 = Double.parseDouble(input2.getText());
                double res = 0;

                switch (operator) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            res = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(CalculatorGUI.this, "除数不能为0!");
                            return;
                        }
                        break;
                }

                result.setText(String.valueOf(res));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(CalculatorGUI.this, "请输入有效的数字!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
    }
}
