package net.artux.template.service;

import net.artux.template.dto.*;
import net.artux.template.model.Group;
import net.artux.template.model.GroupMapper;
import net.artux.template.model.Participant;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.HashMap;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupMapper groupMapper = new GroupMapper() {
    };
    private HashMap<Long, Group> groupsMap = new HashMap<>();
    private long lastGroupId = 1;


    @Override
    public long createGroup(GroupCreateDto dto) {
        long id = lastGroupId++;
        groupsMap.put(id, new Group(id, dto.getName(), dto.getDescription()));
        return id;
    }

    @Override
    public List<GroupSimpleDto> getGroups() {
        return groupMapper.simpleDto(groupsMap.values());
    }

    private Group findGroup(long id) {
        Group group = groupsMap.get(id);
        if (group == null)
            throw new NotFoundException("Group not found");
        return group;
    }

    @Override
    public GroupDto getGroup(long id) {
        return groupMapper.dto(findGroup(id));
    }

    @Override
    public GroupDto editGroup(long id, GroupCreateDto dto) {
        Group group = findGroup(id);
        group.setName(dto.getName());
        group.setDescription(dto.getDescription());
        return groupMapper.dto(group);
    }

    @Override
    public boolean deleteGroup(long id) {
        findGroup(id);
        groupsMap.remove(id);
        return true;
    }

    @Override
    public long createParticipant(long groupId, ParticipantCreateDto createDto) {
        return findGroup(groupId).addParticipant(createDto);
    }

    @Override
    public boolean deleteParticipant(long groupId, long id) {
        return findGroup(groupId).deleteParticipant(id);
    }

    @Override
    public List<ParticipantDto> tossGroup(long id) {
        return groupMapper.dto(findGroup(id).toss());
    }

    @Override
    public ParticipantSimpleDto getRecipient(long groupId, long participantId) {
        Participant p = findGroup(groupId).getParticipant(participantId).getRecipient();
        if (p == null)
            throw new NotFoundException("Not found");
        return groupMapper.simpleDto(p);
    }


}
