/*
 * Copyright (C) 2009-2011 RtcNbClient Team (http://rtcnbclient.wmi.amu.edu.pl/)
 *
 * This file is part of RtcNbClient.
 *
 * RtcNbClient is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RtcNbClient is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with RtcNbClient. If not, see <http://www.gnu.org/licenses/>.
 */
package pl.edu.amu.wmi.kino.rtc.client.queries.editor;
import org.openide.util.NbBundle;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;
import pl.edu.amu.wmi.kino.rtc.client.RtcLogger;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.utils.EventListener;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.query.RtcQuery;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.query.RtcQuery.RtcQueryEvent;
import pl.edu.amu.wmi.kino.rtc.client.queries.model.query.editable.RtcEditableQuery;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.exceptions.RtcSaveException;
import pl.edu.amu.wmi.kino.rtc.client.queries.querylist.nodes.RtcQueryNode;
import pl.edu.amu.wmi.kino.rtc.client.queries.result.ResultsTopComponent;

/**
 *
 * @author Patryk Żywica
 */
public class RtcHeaderPanel extends javax.swing.JPanel implements EventListener<RtcQueryEvent>, DocumentListener {
    private static final long serialVersionUID = -51651L;

    private RtcQuery query;
    private RtcEditableQuery eQuery;
    private boolean synchronizeUpdate = false;

    /** Creates new form RtcHeaderPanel */
    public RtcHeaderPanel(RtcQuery query) {
        this.query = query;
        if (query instanceof RtcEditableQuery) {
            eQuery = (RtcEditableQuery) query;
        } else {
            this.query = query;
        }
        initComponents();
        if (eQuery != null) {
            nameField.setEditable(true);
            nameField.getDocument().addDocumentListener(this);
        }

        if (eQuery != null && eQuery.isModified()) {
            saveButton.setEnabled(true);
        }

        query.addListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        int panelHeight = getHeight();
        int panelWidth = getWidth();
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradient = new GradientPaint(250, 0, Color.white, 250, 600, Color.decode("#194C7F"));
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, panelWidth, panelHeight);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        copyButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        nameLabel.setForeground(Color.decode("#194C7F"));
        nameLabel.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.queryName.text")); // NOI18N

        nameField.setEditable(false);
        nameField.setText(query.getEditableName());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        titleLabel.setForeground(Color.decode("#194C7F"));
        titleLabel.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.title.text")); // NOI18N

        copyButton.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.copyButton.text")); // NOI18N
        copyButton.setPreferredSize(new java.awt.Dimension(85, 20));
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        saveButton.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.saveButton.text")); // NOI18N
        saveButton.setEnabled(false);
        saveButton.setMaximumSize(new java.awt.Dimension(85, 20));
        saveButton.setMinimumSize(new java.awt.Dimension(85, 20));
        saveButton.setPreferredSize(new java.awt.Dimension(85, 20));
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        runButton.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.runButton.text")); // NOI18N
        runButton.setMaximumSize(new java.awt.Dimension(85, 20));
        runButton.setMinimumSize(new java.awt.Dimension(85, 20));
        runButton.setPreferredSize(new java.awt.Dimension(85, 20));
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pl/edu/amu/wmi/kino/rtc/client/queries/resources/workitem.gif"))); // NOI18N
        jLabel1.setText(NbBundle.getMessage(RtcHeaderPanel.class, "RtcHeaderPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(copyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(copyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(titleLabel))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>                        

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (eQuery != null) {
            RequestProcessor.getDefault().post(new Runnable() {

                @Override
                public void run() {
                    //TODO : I18N
                    ProgressHandle ph = ProgressHandleFactory.createHandle("Saving query"); //TODO (NbBundle.getMessage(RtcHeaderPanel.class, "SavingQuery.text")
                   	
                    try {
                        ph.start();
                        eQuery.save();
                    } catch (RtcSaveException ex) {
                        RtcLogger.getLogger().log(Level.SEVERE, ex.getLocalizedMessage());
                    }finally{
                        ph.finish();
                    }
                }
            });
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        pl.edu.amu.wmi.kino.rtc.client.ui.queries.result.ResultsTopComponent tc = pl.edu.amu.wmi.kino.rtc.client.queries.result.ResultsTopComponent.findInstanceFor(query);
        tc.refreshResults();
        tc.open();
        tc.requestActive();
    }//GEN-LAST:event_runButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        final javax.swing.JTextField text = new javax.swing.JTextField();
        text.setText(query.getEditableName());
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.JLabel label = new javax.swing.JLabel();
        DialogDescriptor dd = new DialogDescriptor(panel, NbBundle.getMessage(RtcQueryNode.class, "RenamePanel.name"), true, null); //FIXME czy nie powinna byc w bundlu nazwa obecnej klasy?


        label.setText(NbBundle.getMessage(RtcQueryNode.class, "NewName.name")); //FIXME to samo co wyżej?
        text.setColumns(20);
        text.setText(query.getEditableName());
        text.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if ((text.getBackground().equals(Color.pink)) && !(text.getText().equals(""))) {
                    text.setBackground(Color.white);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (text.getText().equals("")) {
                    text.setBackground(Color.pink);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        panel.add(label);
        panel.add(text);
        Dialog dialog = DialogDisplayer.getDefault().createDialog(dd);
        dialog.setVisible(true);

        if (dd.getValue().equals(DialogDescriptor.OK_OPTION)) {
            RequestProcessor.getDefault().post(new Runnable() {

                @Override
                public void run() {
                    try {
                        query.saveAs(text.getText());
                    } catch (RtcSaveException ex) {
                        RtcLogger.getLogger().log(Level.SEVERE, ex.getLocalizedMessage());
                    }
                }
            });
        }
    }//GEN-LAST:event_copyButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton runButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void eventFired(RtcQueryEvent event) {
        if (!event.equals(RtcQueryEvent.QUERY_SAVED) && eQuery != null && eQuery.isModified()) {
            saveButton.setEnabled(true);
        }
        switch (event) {
            case EDITABLE_NAME_CHANGED:
                if (!nameField.getText().equals(query.getEditableName())) {
                    nameField.setText(query.getEditableName());
                }
                break;
            case QUERY_SAVED:
                saveButton.setEnabled(false);
                break;
            case NAME_CHANGED:
                break;
            case STATEMENT_CHANGED:
                break;
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (synchronizeUpdate == false) {
            changedUpdateImpl(e);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (synchronizeUpdate == false) {
            changedUpdateImpl(e);
        }
    }

    private void changedUpdateImpl(DocumentEvent e) {
        String newName;
        try {
            newName = e.getDocument().getText(0, e.getDocument().getLength());
            if (!newName.equals(eQuery.getEditableName())) {
                eQuery.setEditableName(newName);
            }
            if (newName.equals("")) {
                nameField.setBackground(Color.pink);
            } else {
                nameField.setBackground(Color.white);
            }
        } catch (BadLocationException ex) {
            RtcLogger.getLogger().log(Level.WARNING, ex.getLocalizedMessage());

        }

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //
    }
}
