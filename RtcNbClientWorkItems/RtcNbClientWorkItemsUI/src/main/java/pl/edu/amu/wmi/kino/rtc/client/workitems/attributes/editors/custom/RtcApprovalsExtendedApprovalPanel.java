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
package pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.editors.custom;

import java.awt.Component;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import org.openide.util.Exceptions;
import pl.edu.amu.wmi.kino.rtc.client.workitems.approvals.RtcApprovalType;

/**
 *
 * @author Dawid Holewa
 */
public class RtcApprovalsExtendedApprovalPanel extends javax.swing.JPanel {

	private static final long serialVersionUID = 3390032744295040199L;
	RtcApprovalsExtendedPanel editor;

    /** Creates new form RtcApprovalsExtendedApprovalPanel */
    public RtcApprovalsExtendedApprovalPanel(RtcApprovalsExtendedPanel e, List<RtcApprovalType> types) {
        editor = e;

        initComponents();
        jComboBox1.removeAllItems();
        for (RtcApprovalType rtcApprovalType : types) {
            jComboBox1.addItem(rtcApprovalType);
        }

        jDataPicker.setFormats("yyyy-MM-dd");
        // Uncomments jComboCox1.setRend.... when getIcon() method will be implemented
        // in RtcApprovalTypeImpl class.
        // jComboBox1.setRenderer(new Render());
    }

    private class Render extends DefaultListCellRenderer {
		private static final long serialVersionUID = -7311511828693366439L;

		@Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Icon icon = ((RtcApprovalType) value).getIcon();
            label.setIcon(icon);

            return label;
        }
    }

    public void setType(RtcApprovalType approvalType) {
        jComboBox1.setSelectedItem(approvalType);
    }

    public RtcApprovalType getType() {
        return (RtcApprovalType) jComboBox1.getSelectedItem();
    }

    public String getSubject() {
        return jTextField1.getText();
    }

    public void setSubject(String subject) {
        jTextField1.setText(subject);
    }

    public void setDue(String due) {
        try {
            jDataPicker.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(due));
        } catch (ParseException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public Timestamp getDue() {
        Date d = jDataPicker.getDate();
        if (d != null) {
            return new Timestamp(d.getTime());
        }
        return null;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDataPicker = new org.jdesktop.swingx.JXDatePicker();

        jLabel1.setText(org.openide.util.NbBundle.getMessage(RtcApprovalsExtendedApprovalPanel.class, "RtcApprovalsExtendedApprovalPanel.jLabel1.text")); // NOI18N

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField1.setText(org.openide.util.NbBundle.getMessage(RtcApprovalsExtendedApprovalPanel.class, "RtcApprovalsExtendedApprovalPanel.jTextField1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(RtcApprovalsExtendedApprovalPanel.class, "RtcApprovalsExtendedApprovalPanel.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(RtcApprovalsExtendedApprovalPanel.class, "RtcApprovalsExtendedApprovalPanel.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDataPicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jDataPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
	}//GEN-LAST:event_jComboBox1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private org.jdesktop.swingx.JXDatePicker jDataPicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}