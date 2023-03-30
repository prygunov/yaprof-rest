package net.artux.template.model;

import lombok.Data;
import net.artux.template.dto.ParticipantCreateDto;
import net.artux.template.dto.ParticipantDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Data
public class Group {

    private final long id;
    private String name;
    private String description;
    private List<Participant> participants;

    private long lastParticipantId;
    private Random random;

    public Group(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

        lastParticipantId = 0;
        random = new Random();
        this.participants = new LinkedList<>();
    }

    public long addParticipant(ParticipantCreateDto dto) {
        long id = lastParticipantId++;
        participants.add(new Participant(id, dto.getName(), dto.getWish()));
        return id;
    }

    public Participant getParticipant(long id) {
        for (Participant p : getParticipants()) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    public List<Participant> toss() {
        if (participants.size() < 3)
            throw new HttpClientErrorException(HttpStatusCode.valueOf(409));
        List<Participant> list = new ArrayList<>(participants);
        for (int i = 0; i < participants.size(); i++) {
            if (list.size() == 0)
                break;
            Participant randomP = list.get((int) (random.nextFloat()  * list.size()));
            list.remove(randomP);
            Participant p = participants.get(i);
            if (p != randomP)
                p.setRecipient(randomP);
        }

        return participants;
    }

    public boolean deleteParticipant(long id) {
        return getParticipants().removeIf(participant -> participant.getId() == id);
    }
}
