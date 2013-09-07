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
package pl.edu.amu.wmi.kino.rtc.client.plans.editor.items.nodes.providers.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.openide.util.HelpCtx;

import pl.edu.amu.wmi.kino.netbeans.view.customview.CustomViewCallback;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.load.RtcLoadInfo;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.progress.RtcComplexityComputator;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.progress.RtcProgressInfo;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.viewmode.RtcPlanItemGrouping.RtcPlanItemGroup;
import pl.edu.amu.wmi.kino.rtc.client.plans.editor.bars.RtcBar;
import pl.edu.amu.wmi.kino.rtc.client.plans.editor.bars.RtcLoadBar;
import pl.edu.amu.wmi.kino.rtc.client.plans.editor.bars.RtcProgressBar;

/**
 *
 * @author michu
 */
public class RtcGroupPanel extends javax.swing.JPanel implements HelpCtx.Provider {

	private static final long serialVersionUID = -5030367082126489502L;
	private CustomViewCallback callback;

    /** Creates new form RtcGroupPanel */
    public RtcGroupPanel(CustomViewCallback callback, RtcPlanItemGroup group) {
        this.callback = callback;
        initComponents();

        groupName.setText(group.getGroupLabel());

        RtcBar bar = null;

        RtcProgressInfo i = group.getLookup().lookup(RtcProgressInfo.class);
        if (i != null) {
            RtcComplexityComputator c = group.getLookup().lookup(RtcComplexityComputator.class);
            bar = new RtcProgressBar(i, c, RtcBar.Layout.VERITICAL);
        }

        RtcLoadInfo l = group.getLookup().lookup(RtcLoadInfo.class);
        if (l != null && bar == null) {
            bar = new RtcLoadBar(l, RtcBar.Layout.VERITICAL);
        }

        if (bar != null) {
            progressBarPanel.add(bar);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        progressBarPanel = new javax.swing.JPanel();
        groupName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setMaximumSize(new java.awt.Dimension(32767, 38));
        setMinimumSize(new java.awt.Dimension(0, 38));
        setPreferredSize(new java.awt.Dimension(498, 38));

        progressBarPanel.setMaximumSize(new java.awt.Dimension(2147483647, 32));
        progressBarPanel.setOpaque(false);
        progressBarPanel.setLayout(new java.awt.BorderLayout());

        groupName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        groupName.setForeground(new java.awt.Color(25, 76, 127));
        groupName.setText(org.openide.util.NbBundle.getMessage(RtcGroupPanel.class, "RtcGroupPanel.groupName.text")); // NOI18N

        jLabel3.setForeground(new java.awt.Color(25, 76, 127));
        jLabel3.setText(org.openide.util.NbBundle.getMessage(RtcGroupPanel.class, "RtcGroupPanel.jLabel3.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupName)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(progressBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(progressBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel groupName;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel progressBarPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets  help context for this action.
     * @return the help context for this action
     */
    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
}

class ExpandActionListener implements ActionListener {

    private CustomViewCallback callback;

    public ExpandActionListener(CustomViewCallback callback) {
        this.callback = callback;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        callback.expand();
    }
}

class CollapseActionListener implements ActionListener {

    private CustomViewCallback callback;

    public CollapseActionListener(CustomViewCallback callback) {
        this.callback = callback;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        callback.collapse();
    }
}
