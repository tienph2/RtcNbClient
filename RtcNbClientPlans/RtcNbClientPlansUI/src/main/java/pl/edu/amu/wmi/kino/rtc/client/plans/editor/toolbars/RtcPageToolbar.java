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
package pl.edu.amu.wmi.kino.rtc.client.plans.editor.toolbars;

import java.awt.ComponentOrientation;
import org.openide.util.HelpCtx;
import org.openide.util.actions.SystemAction;
import pl.edu.amu.wmi.kino.rtc.client.plans.actions.RtcAddPlanPageAction;
import pl.edu.amu.wmi.kino.rtc.client.plans.actions.RtcPageEditAction;
import pl.edu.amu.wmi.kino.rtc.client.plans.actions.RtcPageRenameAction;
import pl.edu.amu.wmi.kino.rtc.client.plans.actions.RtcRemovePlanPageAction;

/**
 *
 * @author Bartosz Zaleski <b4lzak@gmail.com>
 */
public class RtcPageToolbar extends javax.swing.JToolBar implements HelpCtx.Provider {

    private static final long serialVersionUID = 3521235235L;
    //private list RtcToolbarAction[] actions;

    /** Creates new form RtcOverviewToolbar */
    public RtcPageToolbar() {
        initComponents();
        this.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        this.setFloatable(false);
        add(SystemAction.get(RtcRemovePlanPageAction.class).getToolbarPresenter());
        add(SystemAction.get(RtcAddPlanPageAction.class).getToolbarPresenter());
        add(SystemAction.get(RtcPageRenameAction.class).getToolbarPresenter());
        add(SystemAction.get(RtcPageEditAction.class).getToolbarPresenter());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {

        setFloatable(false);
        setRollover(true);
        setMargin(new java.awt.Insets(1, 1, 1, 1));
        setMaximumSize(new java.awt.Dimension(2, 10));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
