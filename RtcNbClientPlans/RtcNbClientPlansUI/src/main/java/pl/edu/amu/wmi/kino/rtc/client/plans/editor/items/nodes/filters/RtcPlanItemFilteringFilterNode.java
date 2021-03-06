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
package pl.edu.amu.wmi.kino.rtc.client.plans.editor.items.nodes.filters;

import java.util.Arrays;
import java.util.HashMap;
import org.openide.nodes.FilterNode;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.items.RtcPlanItem;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.viewmode.RtcPlanItemFilter;
import pl.edu.amu.wmi.kino.rtc.client.plans.editor.items.nodes.utilities.RtcFilterNodeUtilities;

/**
 *
 * @author Michal Wojciechowski
 */
public class RtcPlanItemFilteringFilterNode extends FilterNode {

    public RtcPlanItemFilteringFilterNode(Node original, RtcPlanItemFilter filter) {
        super(original);

        HashMap<RtcPlanItem, Node> map = RtcFilterNodeUtilities.getPlanItemsMap(original);
        RtcPlanItem[] planItems = filter.filter(map.keySet().toArray(new RtcPlanItem[]{}));

        setChildren(Children.create(new RtcPlanItemFilteringChildren(
                original, map, Arrays.asList(planItems)), false));

        setDisplayName(filter.getDisplayName());
    }

    /**
     * Gets  help context for this action.
     * @return the help context for this action
     */
    @Override
    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }
}
