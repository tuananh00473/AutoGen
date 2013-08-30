package com.qsoft.augen.ui.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Anhnt
 * Date: 8/31/13
 * Time: 1:07 AM
 */
public class FileChooserGui extends JDialog implements ActionListener
{
    private JFileChooser fileChooser;
    public FileChooserGui()
    {
        super();
        this.setSize(600,600);
        fileChooser = new JFileChooser();
        this.add(fileChooser);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        fileChooser.setCurrentDirectory(new java.io.File("."));
        fileChooser.setDialogTitle("choosertitle");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): "
                    +  fileChooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : "
                    +  fileChooser.getSelectedFile());
        }
        if (fileChooser.showSaveDialog(this) == JFileChooser.CANCEL_OPTION)
        {
            System.out.println("cancel");
        }
    }
}
