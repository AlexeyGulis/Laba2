package rfe.bsu.var4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 320;
    private JTextField textFieldX;
    private JTextField textFieldY;
    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult;
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    // Идентификатор выбранной формулы
    private int formulaId = 1;
    public Test(){
        super("Вычисление формулы");
        setSize(WIDTH,HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Центрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        ImageIcon img = new ImageIcon ("D:\\java\\Laba2\\src\\rfe\\bsu\\var4\\ds2.jpg");

    }

    public static void main(String[] args) {
    }
    private double calculate1(double x,double y){
        return x*x + y*y;
    }
    private double calculate2(double x,double y){
        return x*x*x + 1/y;
    }
    private void addRadioButton(String buttonName,int formulaId){
        JRadioButton radioButton = new JRadioButton(buttonName);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test.this.formulaId = formulaId;
            }
        });
        radioButtons.add(radioButton);
        hboxFormulaType.add(radioButton);
    }
}

