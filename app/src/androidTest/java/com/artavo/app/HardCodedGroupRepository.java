package com.artavo.app;

import com.artavo.core.model.meetup.MeetupGroup;
import com.artavo.core.presenter.GroupsRepository;

import java.util.Collections;
import java.util.Set;

public class HardCodedGroupRepository implements GroupsRepository {
    @Override
    public Set<MeetupGroup> getGroups() {
        return Collections.singleton(new MeetupGroup("open", 1444057312000L, "GDGSevilla", -5.980000019073486, 18997976, "GDGSevilla", 37.400001525878906, "Members"));
    }
}
