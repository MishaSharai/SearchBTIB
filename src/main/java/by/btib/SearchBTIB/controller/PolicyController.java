package by.btib.SearchBTIB.controller;

import by.btib.SearchBTIB.model.Policy;
import by.btib.SearchBTIB.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PolicyController {
    @Autowired
    PolicyRepository policyRepository;

    @GetMapping("policies/go")
    String policies(Model model) {
        List<Policy> policies = policyRepository.findAll();
        model.addAttribute("policies", policies);
        return "policiesGO";
    }

    @GetMapping("policies/go/create")
    String create() {
        return "createGO";
    }

    @PostMapping("policies/go/create")
    String create(Policy policy) {
        policy.setDateDistr(LocalDate.now());
        policy.setTimeBeg(String.valueOf(LocalTime.now().truncatedTo(ChronoUnit.MINUTES))); //.format(DateTimeFormatter.ISO_LOCAL_TIME));
        policyRepository.save(policy);
        return "createGO";
    }

    /*@PostMapping("search")
    String searchGO(@RequestParam String insuredName, Model model) {
        List<Policy> policies = policyRepository.findByInsuredName(insuredName);
        System.out.println(policies.toString());
        model.addAttribute("policies", policies);
        return "searchGO";
    }*/

    @GetMapping("policies/go/update")
    String update(Model model, String id) {
        Policy policy = policyRepository.findById(id).get();
        model.addAttribute("policy", policy);
        return "updateGO";
    }

    @PostMapping("policies/go/update")
    String update(Policy policy) {
        policyRepository.save(policy);
        return "redirect:/policies/go";
    }

    @GetMapping("policies/go/delete")
    String delete(String id) {
        policyRepository.deleteById(id);
        return "redirect:/policies/go";
    }
}
