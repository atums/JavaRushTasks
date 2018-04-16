package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public boolean isHtmlTabSelected() {
        if(this.tabbedPane.getSelectedIndex() == 0) {
            return true; }
        return false;
    }

    public void selectHtmlTab() {
        this.tabbedPane.setSelectedIndex(0);
        resetUndo();
    }


    public void init() {
        initGui();
        addWindowListener(new FrameListener(this));
        this.setVisible(true);
    }

    public void exit() {
        controller.exit();
    }

    public void initMenuBar() {
        //Файл, Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.
        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(260, 220));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    @Override
    public void pack() {

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String strCommand = e.getActionCommand();
        switch(strCommand) {
            case "Новый": {
                controller.createNewDocument();
                break;
            }
            case "Открыть": {
                controller.openDocument();
                break;
            }
            case "Сохранить": {
                controller.saveDocument();
                break;
            }
            case "Сохранить как...": {
                controller.saveDocumentAs();
                break;
            }
            case "Выход": {
                controller.exit();
                break;
            }
            case "О программе": {
                showAbout();
            }
        }
    }

    public void selectedTabChanged() {
        switch(tabbedPane.getSelectedIndex()) {
            case 0: {
                controller.setPlainText(plainTextPane.getText());
            }
            case 1: {
                plainTextPane.setText(controller.getPlainText());
            }
            resetUndo();
        }
    }

    public boolean canUndo() {
        if(undoManager.canUndo()) return true;
        return false;
    }

    public boolean canRedo() {
        if(undoManager.canRedo()) return true;
        return false;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch(Exception ex) {
            ExceptionHandler.log(ex);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch(Exception ex) {
            ExceptionHandler.log(ex);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(getContentPane(), "information",
                "information", JOptionPane.INFORMATION_MESSAGE);
    }
}
