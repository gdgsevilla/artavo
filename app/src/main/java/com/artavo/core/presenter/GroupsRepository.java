package com.artavo.core.presenter;

import com.artavo.core.model.meetup.MeetupGroup;

import java.util.Set;

public interface GroupsRepository {
    Set<MeetupGroup> getGroups();
}
