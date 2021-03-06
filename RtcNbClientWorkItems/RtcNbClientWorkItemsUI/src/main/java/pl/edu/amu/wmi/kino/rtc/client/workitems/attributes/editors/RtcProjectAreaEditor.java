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
package pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.editors;

import java.beans.PropertyEditorSupport;
import org.openide.util.Lookup;
import pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.values.RtcWorkItemAttributePossibleValues;

/**
 *
 * @author Pawel Dolecinski
 */
public class RtcProjectAreaEditor extends PropertyEditorSupport {

   // IWorkItem wi;

    public RtcProjectAreaEditor(Lookup context) {
        context.lookup(RtcWorkItemAttributePossibleValues.class);
     //   wi = context.lookup(IWorkItem.class);
    }

    @Override
    public String getAsText() {

//        IItemManager itemManager = ((ITeamRepository) wi.getOrigin()).itemManager();
//        try {
//            IProjectArea pa;
//            if (getValue() != null) {
//                pa = (IProjectArea) itemManager.fetchCompleteItem((IProjectAreaHandle) getValue(), IItemManager.DEFAULT, null);
//                return pa.getName();
//            }
//        } catch (TeamRepositoryException ex) {
//            RtcLogger.getLogger().log(Level.SEVERE, ex.getLocalizedMessage());
//        }
        return "";
    }

//    public static ToStringProvider getStringProvider() {
//        return new ToStringProviderImpl();
//    }

//    public static class ToStringProviderImpl implements ToStringProvider<IProjectAreaHandle> {
//
//        @Override
//        public String toString(IProjectAreaHandle value) {
//            if (value.hasFullState()) {
//                return ((IProjectArea) value.getFullState()).getName();
//            }
//            return value.getStateId().toString();
//        }
//    }
}
