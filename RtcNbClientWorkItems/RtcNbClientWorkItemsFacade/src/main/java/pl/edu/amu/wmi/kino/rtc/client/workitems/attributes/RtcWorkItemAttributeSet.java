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
package pl.edu.amu.wmi.kino.rtc.client.workitems.attributes;

import java.util.ArrayList;
import pl.edu.amu.wmi.kino.rtc.client.workitems.attributes.RtcWorkItemAttributeSet.RtcWorkItemAttributeCategory;

/**
 *
 * @author psychollek
 */
public class RtcWorkItemAttributeSet extends ArrayList<RtcWorkItemAttributeCategory> {

	private static final long serialVersionUID = -3381198383833694279L;

	public class RtcWorkItemAttributeCategory extends ArrayList<RtcWorkItemAttributeSection> {

		private static final long serialVersionUID = -3001259288150758023L;
		private String displayName;
        private CategoryLayout layout;

        public String getDisplayName() {
            return displayName;
        }

        public CategoryLayout getLayout() {
            return layout;
        }

        //layout cannot be null
        public RtcWorkItemAttributeCategory(String displayName, CategoryLayout layout) {
            this.displayName = displayName;
            this.layout = layout;
        }
    }

    public class RtcWorkItemAttributeSection extends ArrayList<RtcWorkItemAttribute> {

		private static final long serialVersionUID = -6049507335213255100L;
		private String displayName;
        private SectionSlot slot;

        public String getDisplayName() {
            return displayName;
        }

        public SectionSlot getSlot() {
            return slot;
        }

        public RtcWorkItemAttributeSection(String displayName, SectionSlot slot) {
            this.displayName = displayName;
            this.slot = slot;
        }
    }

    public static enum SectionSlot {

        NONE_SECTION,
        DESCRIPTION,
        DETAILS,
        DISCUSSION,
        QUICKINFO,
        ATTACHMENTS,
        SUBSCRIBERS,
        LINKS,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    public static enum CategoryLayout {

        HEADER,
        OVERVIEW,
        LINKS,
        APPROVALS,
        HISTORY,
        H_TAB,
        CUSTOM
    }
}
