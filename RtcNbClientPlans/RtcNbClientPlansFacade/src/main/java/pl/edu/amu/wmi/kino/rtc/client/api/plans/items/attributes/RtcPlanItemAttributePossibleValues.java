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
package pl.edu.amu.wmi.kino.rtc.client.api.plans.items.attributes;

import java.util.List;
import pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.values.RtcWorkItemAttributePossibleValues;

/**
 * This class contains list of any possible values of an attribute - preferably with
 * respect to context in which attribute is presented.
 * @param <T>
 * @author Michal Wojciechowski
 */
public interface RtcPlanItemAttributePossibleValues<T> extends RtcWorkItemAttributePossibleValues<T> {

    /**
     * This can be long running operation. Do not call on event dispatch thread.
     * @return list of preffered values of the attribute.
     */
    @Override
    public List<T> getPossibleValues();
}
