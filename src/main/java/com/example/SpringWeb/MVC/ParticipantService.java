package com.example.SpringWeb.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private ParticipantRepository participantRepository;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository){
        this.participantRepository=participantRepository;
    }

    public void create(ParticipantRequest participantRequest){
        Participant participant = new Participant(participantRequest.getName(),participantRequest.getEmail(),
                participantRequest.getLevel(),participantRequest.getPrimarySkill());
        participantRepository.save(participant);
    }

    public void save(Participant participant){
        participantRepository.save(participant);
    }

    public Optional<Participant> readById(int id){
        return participantRepository.findById(id);
    }

    public List<Participant> readAll() {
        return participantRepository.findAll();
    }

    public void deleteById(int id){
        participantRepository.deleteById(id);
    }

}
