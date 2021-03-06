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
package pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.impl;

import java.awt.Image;

import org.openide.util.Lookup;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;

import pl.edu.amu.wmi.kino.rtc.client.workitems.RtcWorkItem;
import pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.RtcWorkItemAttribute;
import pl.edu.amu.wmi.kino.rtc.client.workitems.types.impl.RtcWorkFlowActionImpl;
import pl.edu.amu.wmi.kino.rtc.client.workitems.types.impl.RtcWorkItemImpl;
import pl.edu.amu.wmi.kino.rtc.client.workitems.workflow.RtcWorkFlow;
import pl.edu.amu.wmi.kino.rtc.client.workitems.workflow.RtcWorkFlowState;

import com.ibm.team.workitem.client.IWorkingCopyListener;
import com.ibm.team.workitem.client.WorkingCopyEvent;

/**
 *
 * @param <T>
 * @author Pawel Dolecinski
 */
public class RtcWorkItemWorkFlowStateAttribute extends RtcWorkItemAttribute<RtcWorkFlow> {

    private final InstanceContent ic;
    //this ensures, that I'll have ic instantinated on any jvm.
    //and it's pretty neat ;]
    private Lookup lookup = new AbstractLookup((ic = new InstanceContent()));

    public RtcWorkItemWorkFlowStateAttribute(Class valueType, ToStringProvider stringProvider, RtcWorkFlowState state, RtcWorkItem workItem) {
        super((state), valueType);
        ic.add(stringProvider);
        ic.add(state);
        if (workItem != null) {
            ic.add(workItem);
        }
        //HACK
        ic.add(this);
        //end of hack
    }

    /**
     * this constructor can accept additional content to it's context - then
     * available in getLookup() of resulting object.
     * @param valueType class of value that will be available through this attribute
     * @param stringProvider stringProvider for the value type
     * @param workItem workItem that is associated with this attribute - can be null
     * @param aditionalContextContent any other context that should be available in lookup
     */
    public RtcWorkItemWorkFlowStateAttribute(Class valueType, ToStringProvider stringProvider, RtcWorkFlowState state, RtcWorkItem workItem, Object... aditionalContextContent) {
        this(valueType, stringProvider, state, workItem);
        for (int i = 0; i < aditionalContextContent.length; i++) {
            ic.add(aditionalContextContent[i]);
        }
    }

    @Override
    public String toString() {
        return lookup.lookup(ToStringProvider.class).toString((RtcWorkFlow)value);
    }

    @Override
    public String getAttributeId() {
        return "internalState";
    }

    @Override
    public String getAttributeDisplayName() {
        return "State";
    }

    @Override
    public Image getIcon() {
        return ((RtcWorkFlow) value).getIcon();
    }

    @Override
    public String getShortDesc() {
        return "";
    }

    @Override
    public Lookup getLookup() {
        return lookup;
    }

    @Override
    protected void getValueInvoked() {
        if (!(value != null && value instanceof RtcWorkFlow)) {
            RtcWorkItemImpl wi = lookup.lookup(RtcWorkItemImpl.class);
            value = wi.getWorkFlowAction();
            //value = (RtcWorkFlow) new RtcWorkFlowStateImpl(new RtcWorkFlowInfoImpl(wi.getWorkItem()), wi.getWorkItem().getState2());
        }
    }

    @Override
    protected void setValueInvoked(RtcWorkFlow value) {
        if (value instanceof RtcWorkFlowActionImpl) {
            RtcWorkFlowActionImpl action = (RtcWorkFlowActionImpl) value;
            RtcWorkItemImpl wi = lookup.lookup(RtcWorkItemImpl.class);
            wi.setWorkFlowAction(action);
            //wc.setWorkflowAction(action.getIdentifier().getStringIdentifier());
        }
    }

    @Override
    public boolean isWritable() {
        return true;
    }

    @Override
    public Type getAttributeType() {
        return Type.FLOW_STATE;
    }

    public static ToStringProvider getStringProvider() {
        return new ToStringProvider();
    }


    public static class ToStringProvider {

        public String toString(RtcWorkFlow value) {
            return value.getName();
        }
    }

    public class WorkingCopyStateListener implements IWorkingCopyListener {

        @Override
        public void workingCopyEvent(WorkingCopyEvent wce) {
            if (wce.hasType(WorkingCopyEvent.SAVED) || wce.hasType(WorkingCopyEvent.SAVE_CANCELED) || wce.hasType(WorkingCopyEvent.REVERTED)) {
//                IWorkItem wi = lookup.lookup(IWorkItem.class);
//                value = (T) new RtcWorkFlowStateImpl(new RtcWorkFlowInfoImpl(wi), wi.getState2());
//                getLookup().lookup(RtcWorkFlowActionPrefferedValues.class).setState(null);
                getValueInvoked();
            }
        }
    }
}
