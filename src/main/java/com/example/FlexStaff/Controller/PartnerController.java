package com.example.FlexStaff.Controller;

import com.example.FlexStaff.DAO.JobRepo;
import com.example.FlexStaff.DAO.PartnerRepo;
import com.example.FlexStaff.DTO.CandidatDto;
import com.example.FlexStaff.Entities.*;
import com.example.FlexStaff.Entities.Enum.Status;
import com.example.FlexStaff.Service.PartnerService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*",exposedHeaders = "*")
@RestController
@RequestMapping(value = "api/v1/partners")
public class PartnerController {

    @Autowired
    private PartnerRepo PR;
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping()
    public List<Partner> getPartnerss(){
        return partnerService.getAllPartners();
    }

    @GetMapping(value = "/{partnerId}")
    public Partner getPartnerById(@PathVariable int partnerId){
        return partnerService.getById(partnerId);
    }

    @PostMapping()
    public int addPartner(@RequestBody Partner p){
        return partnerService.savePartner(p);
    }

    @DeleteMapping(value = "/{partnerId}")
    public String deletePartner(@PathVariable int partnerId){
        return partnerService.removePartner(partnerId);
    }
    /*@PutMapping("/{partnerId}")
    public String updatePartner(@PathVariable int partnerId, @RequestBody Partner postPartner){
        Optional<Partner> partner = PR.findById(partnerId);
        if (partner == null) {
            return ("Partner not found for this id");
        } else {

            Partner existingPartner = partner.get();
            existingPartner.setFirstName(postPartner.getFirstName());
            existingPartner.setLastName(postPartner.getLastName());
            existingPartner.setDescription(postPartner.getDescription());
            existingPartner.setBusinessLocation(postPartner.getBusinessLocation());
            existingPartner.setBusinessName(postPartner.getBusinessName());
            existingPartner.setSector(postPartner.getSector());
            existingPartner.setEmail(postPartner.getEmail());
            existingPartner.setPassword(postPartner.getPassword());
            existingPartner.setRegion(postPartner.getRegion());
            existingPartner.setJobs(postPartner.getJobs());
            existingPartner.setRatings(postPartner.getRatings());
            existingPartner.setFavoredBy(postPartner.getFavoredBy());


            // set other fields as needed

            final Partner updatedEmployee = PR.save(existingPartner);
            return("done");
        }
    }*/
    @PutMapping(value = "/candidats/client/{clientId}/job/{jobId}/{code}")
    Candidat manageCandidat(
            @PathVariable int clientId,
            @PathVariable int jobId,
            @PathVariable String code
            )
    {
       return partnerService.manageCandidat(clientId, jobId, code);
    }
    /* @PutMapping(value = "/partners/{partnerId}/jobs/{jobId}")
    Partner addJob(@PathVariable int partnerId, @PathVariable int jobId){
        Partner p = partnerRepo.findById(partnerId).get();
        Job j = jobRepo.findById(jobId).get();
        p.addJob(j);
        return partnerRepo.save(p);

    }*/
}
