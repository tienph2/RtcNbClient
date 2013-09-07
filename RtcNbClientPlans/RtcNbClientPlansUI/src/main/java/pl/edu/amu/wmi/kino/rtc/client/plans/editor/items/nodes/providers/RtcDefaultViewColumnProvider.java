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
package pl.edu.amu.wmi.kino.rtc.client.plans.editor.items.nodes.providers;

import java.util.ArrayList;
import java.util.List;

import pl.edu.amu.wmi.kino.netbeans.view.customview.nodecontent.CustomViewColumnProvider;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.items.RtcPlanItemAttribute;

/**
 *
 * @author michu
 */
public class RtcDefaultViewColumnProvider extends CustomViewColumnProvider {
    private List<String> columns = new ArrayList<String>();

    public RtcDefaultViewColumnProvider(RtcPlanItemAttribute[] columns) {

        for(RtcPlanItemAttribute column : columns) {
            this.columns.add(column.getAttributeIdentifier());
        }

    }

    @Override
    public String[] getColumns() {
        return columns.toArray(new String[]{});
    }
}
