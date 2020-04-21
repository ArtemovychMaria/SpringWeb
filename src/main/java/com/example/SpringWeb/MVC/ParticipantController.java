package com.example.SpringWeb.MVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String allParticipants(HttpServletRequest request){
        request.setAttribute("participants",participantService.readAll());
        request.setAttribute("mode","PARTICIPANT_VIEW");
        return "participant";
    }

    @GetMapping("/new")
    public String newBook(HttpServletRequest req) {
        req.setAttribute("mode", "PARTICIPANT_CREATE");
        return "participant";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
        participantService.save(participant);
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "BOOK_VIEW");
        return "participant";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ParticipantRequest participantRequest, HttpServletRequest req) {
        participantService.create(participantRequest);
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "BOOK_VIEW");
        return "participant";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        Optional<Participant> participantMaybe = participantService.readById(id);

        if(participantMaybe.isPresent()) {
            req.setAttribute("participant", participantMaybe.get());
            req.setAttribute("mode", "PARTICIPANT_EDIT");
            return "participant";
        }
        return "noParticipantExist";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam(name = "id") int participantId, HttpServletRequest req) {
        participantService.deleteById(participantId);
        req.setAttribute("participants", participantService.readAll());
        req.setAttribute("mode", "PARTICIPANT_VIEW");
        // Todo Fix
        return "participant";
    }

}
