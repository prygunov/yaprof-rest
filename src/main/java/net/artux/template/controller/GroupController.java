package net.artux.template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import net.artux.template.dto.*;
import net.artux.template.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Группы")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @Operation(summary = "Добавление группы")
    @PostMapping("/group")
    public long createGroup(GroupCreateDto dto) {
        return groupService.createGroup(dto);
    }


    @Operation(summary = "Получение краткой информации о всех группах (без информации об участниках)")
    @GetMapping
    public List<GroupSimpleDto> getGroups() {
        return groupService.getGroups();
    }

    @Operation(summary = "Получение полной информации (с информацией об участниках) о группе по идентификатору")
    @GetMapping("/group/{id}")
    public GroupDto getGroup(@PathVariable long id) {
        return groupService.getGroup(id);
    }

    @Operation(summary = "Редактирование группы по идентификатору группы")
    @PutMapping("/group/{id}")
    public GroupDto editGroup(@PathVariable long id, GroupCreateDto dto) {
        return groupService.editGroup(id, dto);
    }

    @Operation(summary = "Удаление группы по идентификатору")
    @DeleteMapping("/group/{id}")
    public boolean deleteGroup(@PathVariable long id) {
        return groupService.deleteGroup(id);
    }

    @Operation(summary = "Добавление участника в группу по идентификатору группы")
    @PostMapping("/group/{id}/participant")
    public long createParticipant(@PathVariable long id, ParticipantCreateDto dto) {
        return groupService.createParticipant(id, dto);
    }

    @Operation(summary = "Удаление участника из группы по идентификаторам группы и участника")
    @DeleteMapping("/group/{groupId}/participant/{participantId}")
    public boolean deleteParticipant(@PathVariable long groupId, @PathVariable long participantId) {
        return groupService.deleteParticipant(groupId, participantId);
    }

    @Operation(summary = "Проведение жеребьевки в группе по идентификатору группы")
    @PostMapping("/group/{groupId}/toss")
    public List<ParticipantDto> tossGroup(@PathVariable long groupId) {
        return groupService.tossGroup(groupId);
    }

    @Operation(summary = "Получение информации для конкретного участника группы, кому он дарит подарок.")
    @GetMapping("/group/{groupId}/participant/{participantId}/recipient")
    public ParticipantSimpleDto getRecipient(@PathVariable long groupId, @PathVariable long participantId) {
        return groupService.getRecipient(groupId, participantId);
    }


}
