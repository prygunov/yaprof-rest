package net.artux.template.service;

import net.artux.template.dto.*;

import java.util.List;

public interface GroupService {

    long createGroup(GroupCreateDto dto);
    List<GroupSimpleDto> getGroups();
    GroupDto getGroup(long id);
    GroupDto editGroup(long id, GroupCreateDto dto);
    boolean deleteGroup(long id);

    long createParticipant(long groupId, ParticipantCreateDto createDto);
    boolean deleteParticipant(long groupId, long id);

    List<ParticipantDto> tossGroup(long id);
    ParticipantSimpleDto getRecipient(long groupId, long participantId);

}
