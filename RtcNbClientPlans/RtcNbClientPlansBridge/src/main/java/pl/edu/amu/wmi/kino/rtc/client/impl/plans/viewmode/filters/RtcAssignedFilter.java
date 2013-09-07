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
package pl.edu.amu.wmi.kino.rtc.client.impl.plans.viewmode.filters;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.NbBundle;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.RtcPlansManager;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.items.RtcPlanItem;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.items.RtcPlanItemAttribute;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.items.RtcPlanWorkItem;
import pl.edu.amu.wmi.kino.rtc.client.api.plans.viewmode.RtcPlanItemFilter;

/**
 *
 * @author Pawel Dolecinski
 */
public class RtcAssignedFilter extends RtcPlanItemFilter {

    private static final String assignedAttributeId = "com.ibm.team.apt.attribute.owner";

    /**
     *
     * @return
     */
    @Override
    public String getDisplayName() {
        return NbBundle.getMessage(RtcAssignedFilter.class, "filter.name.assigned");
    }

    @Override
    public boolean isFiltered(RtcPlanItem planItem) {
        if (planItem instanceof RtcPlanWorkItem) {
            RtcPlansManager plansManager = planItem.getPlan().getPlansManager();
            RtcPlanItemAttribute planItemAttribute = plansManager.getPlanItemAttribute(assignedAttributeId);
            @SuppressWarnings("unchecked")
            Object owner = planItem.getPlanAttributeValue(planItemAttribute);

            if (owner == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public RtcPlanItem[] filter(RtcPlanItem[] planItems) {
        List<RtcPlanItem> res = new ArrayList<RtcPlanItem>();
        for (RtcPlanItem rtcPlanItem : planItems) {
            if (!isFiltered(rtcPlanItem)) {
                res.add(rtcPlanItem);
            }
        }

        return res.toArray(new RtcPlanItem[]{});
    }
}
