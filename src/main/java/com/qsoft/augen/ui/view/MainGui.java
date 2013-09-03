package com.qsoft.augen.ui.view;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.qsoft.augen.ui.control.MainController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Anhnt
 * Date: 8/29/13
 * Time: 12:12 AM
 */
public class MainGui extends JFrame
{
    public static String COLUMN_NAME = "Column Name";
    public static String DATA_TYPE = "Data Type";

    private JPanel mainPanel;
    private JTable tableColumn;
    private JList listTable;
    private JButton btnGeneric;
    private JButton btnQuit;
    private JTextField txtDBName;
    private JTextField txtUserName;
    private JPasswordField txtPassWord;
    private JButton btnConnect;
    private JButton btnDisConnect;
    private JScrollPane panelListTable;
    private JScrollPane panelTableColumn;
    private JTextField txtOutput;
    private JButton btnOutput;

    public MainGui(final MainController mainController)
    {
        super();
        setContentPane(mainPanel);
        setSize(600, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        btnConnect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.doConnect();
            }
        });

        btnDisConnect.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.doDisConnect();
            }
        });

        btnGeneric.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.doGenerate();
            }
        });

        btnQuit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.doQuit();
            }
        });

        btnOutput.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainController.setOutput();
            }
        });

        listTable.addListSelectionListener(new ListSelectionListener()
        {
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                mainController.changeTableListener();
            }
        });
    }

//    ================== get/set =================

    public JTable getTableColumn()
    {
        return tableColumn;
    }

    public void setTableColumn(JTable tableColumn)
    {
        this.tableColumn = tableColumn;
    }

    public JList getListTable()
    {
        return listTable;
    }

    public void setListTable(JList listTable)
    {
        this.listTable = listTable;
    }

    public JTextField getTxtDBName()
    {
        return txtDBName;
    }

    public void setTxtDBName(JTextField txtDBName)
    {
        this.txtDBName = txtDBName;
    }

    public JTextField getTxtUserName()
    {
        return txtUserName;
    }

    public void setTxtUserName(JTextField txtUserName)
    {
        this.txtUserName = txtUserName;
    }

    public JPasswordField getTxtPassWord()
    {
        return txtPassWord;
    }

    public void setTxtPassWord(JPasswordField txtPassWord)
    {
        this.txtPassWord = txtPassWord;
    }

    public JScrollPane getPanelListTable()
    {
        return panelListTable;
    }

    public void setPanelListTable(JScrollPane panelListTable)
    {
        this.panelListTable = panelListTable;
    }

    public JScrollPane getPanelTableColumn()
    {
        return panelTableColumn;
    }

    public void setPanelTableColumn(JScrollPane panelTableColumn)
    {
        this.panelTableColumn = panelTableColumn;
    }

    public JTextField getTxtOutput()
    {
        return txtOutput;
    }

    public void setTxtOutput(JTextField txtOutput)
    {
        this.txtOutput = txtOutput;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(7, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel1, BorderLayout.NORTH);
        final JSeparator separator1 = new JSeparator();
        panel1.add(separator1, new GridConstraints(4, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator2 = new JSeparator();
        panel1.add(separator2, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator3 = new JSeparator();
        panel1.add(separator3, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator4 = new JSeparator();
        panel1.add(separator4, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator5 = new JSeparator();
        panel1.add(separator5, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator6 = new JSeparator();
        panel1.add(separator6, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        label1.setText("Auto generic admin web page application");
        label1.setVerticalAlignment(0);
        panel1.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(509, 14), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("                   ");
        panel1.add(label2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(61, 0), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel2, BorderLayout.CENTER);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new BorderLayout(0, 0));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(430, 186), null, 0, false));
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), null));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FormLayout("fill:17px:grow,left:4dlu:noGrow,fill:d:grow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        panel3.add(panel4, BorderLayout.NORTH);
        final JLabel label3 = new JLabel();
        label3.setFont(new Font("Tahoma", Font.BOLD, 12));
        label3.setText("DB NAME");
        CellConstraints cc = new CellConstraints();
        panel4.add(label3, cc.xy(1, 1, CellConstraints.RIGHT, CellConstraints.FILL));
        txtDBName = new JTextField();
        txtDBName.setText("autogen");
        panel4.add(txtDBName, cc.xy(3, 1, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label4 = new JLabel();
        label4.setFont(new Font("Tahoma", Font.BOLD, 12));
        label4.setText("USER NAME");
        panel4.add(label4, cc.xy(1, 3, CellConstraints.RIGHT, CellConstraints.FILL));
        txtUserName = new JTextField();
        txtUserName.setText("admin");
        panel4.add(txtUserName, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        final JLabel label5 = new JLabel();
        label5.setFont(new Font("Tahoma", Font.BOLD, 12));
        label5.setText("PASS WORD");
        panel4.add(label5, cc.xy(1, 5, CellConstraints.RIGHT, CellConstraints.FILL));
        txtPassWord = new JPasswordField();
        txtPassWord.setText("123456");
        panel4.add(txtPassWord, cc.xy(3, 5, CellConstraints.FILL, CellConstraints.DEFAULT));
        btnConnect = new JButton();
        btnConnect.setText("CONNECT");
        panel4.add(btnConnect, cc.xy(1, 7));
        btnDisConnect = new JButton();
        btnDisConnect.setText("DISCONNECT");
        panel4.add(btnDisConnect, cc.xy(3, 7));
        panelListTable = new JScrollPane();
        panel3.add(panelListTable, BorderLayout.CENTER);
        listTable = new JList();
        panelListTable.setViewportView(listTable);
        panelTableColumn = new JScrollPane();
        panel2.add(panelTableColumn, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableColumn = new JTable();
        panelTableColumn.setViewportView(tableColumn);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(11, 5, new Insets(0, 0, 0, 0), -1, -1));
        mainPanel.add(panel5, BorderLayout.SOUTH);
        btnGeneric = new JButton();
        btnGeneric.setText("GENERATE");
        panel5.add(btnGeneric, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(91, 25), null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel5.add(spacer1, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(290, 11), null, 0, false));
        btnQuit = new JButton();
        btnQuit.setText("QUIT");
        panel5.add(btnQuit, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(213, 25), null, 0, false));
        final JSeparator separator7 = new JSeparator();
        panel5.add(separator7, new GridConstraints(8, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator8 = new JSeparator();
        panel5.add(separator8, new GridConstraints(9, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator9 = new JSeparator();
        panel5.add(separator9, new GridConstraints(10, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator10 = new JSeparator();
        panel5.add(separator10, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator11 = new JSeparator();
        panel5.add(separator11, new GridConstraints(2, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator12 = new JSeparator();
        panel5.add(separator12, new GridConstraints(1, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("        ");
        panel5.add(label6, new GridConstraints(7, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtOutput = new JTextField();
        panel5.add(txtOutput, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnOutput = new JButton();
        btnOutput.setText("OUTPUT");
        panel5.add(btnOutput, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("        ");
        panel5.add(label7, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JSeparator separator13 = new JSeparator();
        panel5.add(separator13, new GridConstraints(4, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator14 = new JSeparator();
        panel5.add(separator14, new GridConstraints(5, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JSeparator separator15 = new JSeparator();
        panel5.add(separator15, new GridConstraints(6, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return mainPanel;
    }
}
