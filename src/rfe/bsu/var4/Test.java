package rfe.bsu.var4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Math.*;

public class Test extends JFrame{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 420;
    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;
    private Double result = 0.0;
    ImageIcon img = new ImageIcon("D:\\java\\Laba2\\src\\rfe\\bsu\\var4\\ds2.jpg");
    ImageIcon form1 = new ImageIcon("D:\\java\\Laba2\\src\\rfe\\bsu\\var4\\img.png");
    ImageIcon form2 = new ImageIcon("D:\\java\\Laba2\\src\\rfe\\bsu\\var4\\img1.png");
    private JTextField textFieldX = new JTextField("0",10);
    private JTextField textFieldY = new JTextField("0",10);
    private JTextField textFieldZ = new JTextField("0",10);
    private JTextField textFieldMem1 = new JTextField("0",10);
    private JTextField textFieldMem2 = new JTextField("0",10);
    private JTextField textFieldMem3 = new JTextField("0",10);
    private JLabel labelX = new JLabel("X : ");
    private JLabel labelY = new JLabel("Y : ");
    private JLabel labelZ = new JLabel("Z : ");
    private JLabel labelMem1 = new JLabel("Переменная 1 : ");
    private JLabel labelMem2 = new JLabel("Переменная 2 : ");
    private JLabel labelMem3 = new JLabel("Переменная 3 : ");
    private JLabel labelResult = new JLabel("Результат : ");
    private JLabel labelImg = new JLabel(form1);
    private JButton buttonCalc = new JButton("Вычислить");
    private JButton buttonRes = new JButton("Очистить поля");
    private JButton buttonMC = new JButton("MC");
    private JButton buttonMP = new JButton("M+");


    // как компонент, совместно используемый в различных методах
    private JTextField textFieldResult= new JTextField("0",10);
    // Группа радио-кнопок для обеспечения уникальности выделения в группе
    private ButtonGroup radioButtons = new ButtonGroup();
    private ButtonGroup radioButtons1 = new ButtonGroup();
    // Контейнер для отображения радио-кнопок
    private Box hboxFormulaType = Box.createHorizontalBox();
    private Box hboxFormulaImg = Box.createHorizontalBox();
    private Box hboxLabelMemType = Box.createHorizontalBox();
    private Box hboxValues = Box.createHorizontalBox();
    private Box hboxResult = Box.createHorizontalBox();
    private Box hboxButton = Box.createHorizontalBox();
    private Box hboxValuesMem = Box.createHorizontalBox();
    private Box containerBox = Box.createVerticalBox();
    // Идентификатор выбранной формулы
    private int formulaId = 1;
    private int labelMemId = 1;
    public Test() {
        super("Вычисление формулы");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Центрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH) / 2,
                (kit.getScreenSize().height - HEIGHT) / 2);
        // Иконка
        setIconImage(img.getImage());
        // размер всех полей
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldMem1.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldMem2.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldMem3.setMaximumSize(textFieldResult.getPreferredSize());
        // Гориз.коробка радиокнопок на формулы
        hboxFormulaType.add(Box.createHorizontalGlue());
        addRadioButton("Формула 1",1);
        addRadioButton("Формула 2",2);
        hboxFormulaType.add(Box.createHorizontalGlue());
        hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
        // Гориз.коробка вывода изображения формулы
        hboxFormulaImg.add(Box.createHorizontalGlue());
        hboxFormulaImg.add(labelImg);
        hboxFormulaImg.add(Box.createHorizontalGlue());
        hboxFormulaImg.setBorder(BorderFactory.createLineBorder(Color.PINK));
        // Гориз.коробка ввода переменных
        hboxValues.add(Box.createHorizontalGlue());
        hboxValues.add(labelX);
        hboxValues.add(Box.createHorizontalStrut(10));
        hboxValues.add(textFieldX);
        hboxValues.add(Box.createHorizontalStrut(30));
        hboxValues.add(labelY);
        hboxValues.add(Box.createHorizontalStrut(10));
        hboxValues.add(textFieldY);
        hboxValues.add(Box.createHorizontalStrut(30));
        hboxValues.add(labelZ);
        hboxValues.add(Box.createHorizontalStrut(10));
        hboxValues.add(textFieldZ);
        hboxValues.add(Box.createHorizontalGlue());
        hboxValues.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        // Гориз.коробка вывода результата
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        // Гориз.коробка радиокнопки внутренних переменных
        hboxLabelMemType.add(Box.createHorizontalGlue());
        addRadioButton1("Переменная 1",1);
        addRadioButton1("Переменная 2",2);
        addRadioButton1("Переменная 3",3);
        hboxLabelMemType.add(Box.createHorizontalGlue());
        hboxLabelMemType.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        radioButtons1.setSelected(radioButtons1.getElements().nextElement().getModel(), true);
        // Гориз.коробка вывода значений внутренних переменных
        hboxValuesMem.add(Box.createHorizontalGlue());
        hboxValuesMem.add(labelMem1);
        hboxValuesMem.add(Box.createHorizontalStrut(10));
        hboxValuesMem.add(textFieldMem1);
        hboxValuesMem.add(Box.createHorizontalStrut(30));
        hboxValuesMem.add(labelMem2);
        hboxValuesMem.add(Box.createHorizontalStrut(10));
        hboxValuesMem.add(textFieldMem2);
        hboxValuesMem.add(Box.createHorizontalStrut(30));
        hboxValuesMem.add(labelMem3);
        hboxValuesMem.add(Box.createHorizontalStrut(10));
        hboxValuesMem.add(textFieldMem3);
        hboxValuesMem.add(Box.createHorizontalGlue());
        hboxValuesMem.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        // Гориз.коробка кнопок
        hboxButton.add(Box.createHorizontalGlue());
        hboxButton.add(buttonCalc);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(buttonRes);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(buttonMC);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(buttonMP);
        hboxButton.add(Box.createHorizontalGlue());
        hboxButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Создаем вертикальный контейнер в котором укладываем все горизонтальные коробки
        containerBox.add(Box.createVerticalGlue());
        containerBox.add(hboxFormulaType);
        containerBox.add(hboxFormulaImg);
        containerBox.add(hboxValues);
        containerBox.add(hboxResult);
        containerBox.add(hboxLabelMemType);
        containerBox.add(hboxValuesMem);
        containerBox.add(hboxButton);
        containerBox.add(Box.createVerticalGlue());
        add(containerBox,BorderLayout.CENTER);


        //Действие на кнопки
        //Действие кнопки вычисления
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try{
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    if(formulaId==1){
                        result = calculate1(x,y,z);
                    }
                    if(formulaId==2){
                        result = calculate2(x,y,z);
                    }
                    textFieldResult.setText(result.toString());

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(Test.this,
                            "Ошибка в формате числа с плавающей точкой",
                            "Ошибочный формат переменных",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        //Действие кнопки сброс значений
        buttonRes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
                textFieldMem1.setText("0");
                textFieldMem2.setText("0");
                textFieldMem3.setText("0");
                mem1=0.0;
                mem2=0.0;
                mem3=0.0;
            }
        });
        //Действие кнопки сброс внутренней выбранной переменной
        buttonMC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if(labelMemId==1){
                    mem1=0.0;
                    textFieldMem1.setText(mem1.toString());
                }
                if(labelMemId==2){
                    mem2=0.0;
                    textFieldMem2.setText(mem2.toString());
                }
                if(labelMemId==3){
                    mem3=0.0;
                    textFieldMem3.setText(mem3.toString());
                }
            }
        });

        //Действие кнопки добавления в память результатов
        buttonMP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try{
                    Double x = Double.parseDouble(textFieldResult.getText());
                    if(labelMemId==1){
                        mem1+=x;
                        textFieldMem1.setText(mem1.toString());
                        textFieldResult.setText(mem1.toString());
                    }
                    if(labelMemId==2){
                        mem2+=x;
                        textFieldMem2.setText(mem2.toString());
                        textFieldResult.setText(mem2.toString());
                    }
                    if(labelMemId==3){
                        mem3+=x;
                        textFieldMem3.setText(mem3.toString());
                        textFieldResult.setText(mem3.toString());
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(Test.this,
                            "Ошибка в формате числа с плавающей точкой",
                            "Ошибочный формат переменных",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });


    }

    public static void main(String[] args) {
        Test progr = new Test();
        progr.setVisible(true);
        progr.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private double calculate1(double x,double y,double z){
        double result = 0.0;
        try{
            result = sin(log(y)+sin(PI*y*y))*pow((x*x+sin(z)+exp(cos(z))),1/4);
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(Test.this,
                    "Ошибка в вычислении",
                    "С данными переменными, вычисление по формуле не подлежит",
                    JOptionPane.ERROR_MESSAGE);
        }
       return result;
    }
    private double calculate2(double x,double y,double z){
        double result = 0.0;
        try{
            result = pow(cos(exp(x))+log(pow((1+y),2))+pow(exp(cos(x))+pow(sin(PI*z),2),1/2)+pow(1/x,1/2)+cos(y*y),sin(z));
        }catch(ArithmeticException e){
            JOptionPane.showMessageDialog(Test.this,
                    "Ошибка в вычислении",
                    "С данными переменными, вычисление по формуле не подлежит",
                    JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
    private void addRadioButton(String buttonName,int formulaId){
        JRadioButton radioButton = new JRadioButton(buttonName);
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test.this.formulaId = formulaId;
                if(formulaId==1){
                    labelImg.setIcon(form1);
                }else if(formulaId==2){
                    labelImg.setIcon(form2);
                }
            }
        });
        radioButtons.add(radioButton);

        hboxFormulaType.add(radioButton);
    }
    private void addRadioButton1(String labelMemName,int labelMemId){
        JRadioButton radioButton1 = new JRadioButton(labelMemName);
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Test.this.labelMemId = labelMemId;
            }
        });
        radioButtons1.add(radioButton1);
        hboxLabelMemType.add(radioButton1);
    }
}

