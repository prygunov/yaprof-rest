package net.artux.template.model;

import net.artux.template.dto.GroupDto;
import net.artux.template.dto.GroupSimpleDto;
import net.artux.template.dto.ParticipantDto;
import net.artux.template.dto.ParticipantSimpleDto;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public interface GroupMapper {

    default GroupSimpleDto simpleDto(Group group) {
        return new GroupSimpleDto(group.getId(), group.getName(), group.getDescription());
    }

    default List<GroupSimpleDto> simpleDto(Collection<Group> groups) {
        List<GroupSimpleDto> dtos = new LinkedList<>();
        for (Group g : groups) {
            dtos.add(simpleDto(g));
        }
        return dtos;
    }

    default GroupDto dto(Group group) {
        return new GroupDto(group.getId(), group.getName(), group.getDescription(), dto(group.getParticipants()));
    }

    default List<ParticipantDto> dto(List<Participant> participants) {
        List<ParticipantDto> dtos = new LinkedList<>();
        for (Participant p : participants) {
            dtos.add(dto(p));
        }
        return dtos;
    }

    default ParticipantDto dto(Participant p) {
        return new ParticipantDto(p.getId(), p.getName(), p.getWish(), simpleDto(p.getRecipient()));
    }

    default ParticipantSimpleDto simpleDto(Participant p) {
        if (p == null)
            return null;
        return new ParticipantSimpleDto(p.getId(), p.getName(), p.getWish());
    }

}
