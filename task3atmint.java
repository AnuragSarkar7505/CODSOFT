package codsoft_projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task3atmint 
{
    private JFrame frame;
    private BankAccount account;

    private JTextField amountField;
    private JTextArea outputArea;

    public task3atmint(BankAccount account) 
    {
        this.account = account;
        initialize();
    }

    private void initialize() 
    {
        frame = new JFrame("TASK - 3 = *ATM INTERFACE*");
        frame.setBounds(100, 100, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblAmount = new JLabel("Enter Amount:");
        panel.add(lblAmount);

        amountField = new JTextField();
        panel.add(amountField);
        amountField.setColumns(10);

        JButton btnDeposit = new JButton("Deposit");
        panel.add(btnDeposit);
        btnDeposit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                double amount = Double.parseDouble(amountField.getText());
                if (account.deposit(amount)) 
                {
                    outputArea.append("Deposit of $" + amount + " successful.\n");
                } 
                else 
                {
                    outputArea.append("Invalid deposit amount.\n");
                }
            }
        });

        JButton btnWithdraw = new JButton("Withdraw");
        panel.add(btnWithdraw);
        btnWithdraw.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                double amount = Double.parseDouble(amountField.getText());
                if (account.withdraw(amount)) 
                {
                    outputArea.append("Withdrawal of $" + amount + " successful.\n");
                } 
                else 
                {
                    outputArea.append("Invalid withdrawal amount or insufficient balance.\n");
                }
            }
        });

        JButton btnCheckBalance = new JButton("Check Balance");
        panel.add(btnCheckBalance);
        btnCheckBalance.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                double balance = account.checkBalance();
                outputArea.append("Your account balance is: $" + balance + "\n");
            }
        });

        outputArea = new JTextArea();
        frame.getContentPane().add(outputArea, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) 
    {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    double initialBalance = Double.parseDouble(JOptionPane.showInputDialog("Enter initial balance:"));
                    BankAccount account = new BankAccount(initialBalance);
                    new task3atmint(account);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });
    }
}

class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() 
    {
        return balance;
    }
}
