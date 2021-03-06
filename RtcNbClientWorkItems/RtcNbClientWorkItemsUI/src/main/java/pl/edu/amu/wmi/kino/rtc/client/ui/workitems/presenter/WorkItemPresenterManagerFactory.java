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
package pl.edu.amu.wmi.kino.rtc.client.ui.workitems.presenter;
import org.openide.util.NbBundle;
import java.util.HashMap;
import org.openide.util.lookup.ServiceProvider;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.ActiveProjectArea;
import pl.edu.amu.wmi.kino.rtc.client.facade.api.common.ProjectAreaDependentManagerFactory;
import pl.edu.amu.wmi.kino.rtc.client.ui.api.workitems.presenters.WorkItemPresenterManager;

/**
 *
 * @author Patryk Żywica
 */
@ServiceProvider(service = ProjectAreaDependentManagerFactory.class, path = "Rtc/ProjectAreaDependentManagerFactories")
public class WorkItemPresenterManagerFactory implements ProjectAreaDependentManagerFactory<WorkItemPresenterManager> {

    private HashMap<ActiveProjectArea, WorkItemPresenterManager> managers = new HashMap<ActiveProjectArea, WorkItemPresenterManager>();

    @Override
    public WorkItemPresenterManager getManager(ActiveProjectArea area) {
        assert (area != null);
        if (!managers.containsKey(area)) {
            managers.put(area, new WorkItemPresenterManagerImpl(area));
        }
        return managers.get(area);
    }

    @Override
    public Class<WorkItemPresenterManager> getManagerType() {
        return WorkItemPresenterManager.class;
    }

    @Override
    public String getManagerNamePrefix() {
        return NbBundle.getMessage(WorkItemPresenterManagerFactory.class, "WorkItemPresenterManager.name");
    }

    @Override
    public String getManagerIdPrefix() {
        return NbBundle.getMessage(WorkItemPresenterManagerFactory.class, "WorkItemPresenterManager.name");
    }
}
