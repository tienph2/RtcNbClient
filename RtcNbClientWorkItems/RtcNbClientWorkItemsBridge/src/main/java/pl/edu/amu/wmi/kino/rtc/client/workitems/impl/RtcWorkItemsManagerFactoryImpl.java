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
package pl.edu.amu.wmi.kino.rtc.client.workitems.impl;

import java.util.HashMap;
import org.openide.util.lookup.ServiceProvider;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.ActiveProjectArea;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.ProjectAreaDependentManagerFactory;
import pl.edu.amu.wmi.kino.rtc.client.facade.impl.connections.ActiveProjectAreaImpl;
import pl.edu.amu.wmi.kino.rtc.client.workitems.RtcWorkItemsManager;

/**
 *
 * @author Patryk Żywica
 */
@Deprecated
@ServiceProvider(service=ProjectAreaDependentManagerFactory.class,path="Rtc/ProjectAreaDependentManagerFactories")
public class RtcWorkItemsManagerFactoryImpl implements ProjectAreaDependentManagerFactory<RtcWorkItemsManager> {

    private HashMap<ActiveProjectArea, RtcWorkItemsManager> managers = new HashMap<ActiveProjectArea, RtcWorkItemsManager>();

    @Override
    public RtcWorkItemsManager getManager(ActiveProjectArea area) {
        assert (area != null);
        if (managers.get(area) == null) {
            managers.put(area, new RtcWorkItemsManagerImpl((ActiveProjectAreaImpl) area));
        }
        return managers.get(area);
    }

    @Override
    public Class<RtcWorkItemsManager> getManagerType() {
        return RtcWorkItemsManager.class;
    }

    @Override
    public String getManagerNamePrefix() {
        return "OldWorkItemsManager";
    }

    @Override
    public String getManagerIdPrefix() {
        return "OldWorkItemsManager";
    }
}
