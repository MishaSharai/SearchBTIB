package by.btib.SearchBTIB.controller;

import by.btib.SearchBTIB.model.Policy;
import by.btib.SearchBTIB.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    @Autowired
    PolicyRepository policyRepository;

    private LocalDate dateDistrStart;
    private LocalDate dateDistrEnd;

    @GetMapping("search")
    String searchGO(Model model) {
        model.addAttribute("dateDistrStart", LocalDate.parse("2001-01-01"));
        //model.addAttribute("dateDistrEnd", dateDistrEnd);
        return "search";
    }

    @PostMapping("search")
    String search(@RequestParam Map<String, String> params, Model model) throws ParseException {
//        Date dateDistrStart = new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDistrStart"));
//        Date dateDistrEnd = new SimpleDateFormat("yyyy-MM-dd").parse(params.get("dateDistrEnd"));
        dateDistrStart = LocalDate.parse(params.get("dateDistrStart"));
        dateDistrEnd = LocalDate.parse(params.get("dateDistrEnd"));
        model.addAttribute("dateDistrStart", dateDistrStart);
        model.addAttribute("dateDistrEnd", dateDistrEnd);

        if (params.get("typeOfPolicy").equals("GO")) {
            if (!params.get("policyNum").trim().equals("")) {
                //model.addAttribute("isPolicyNum", policyRepository.existsByPolicyNum(String.valueOf(params.get("policyNum")).trim()));
                model.addAttribute("policyNum", params.get("policyNum"));
                model.addAttribute("existPolicyNum",
                        policyRepository.existsByPolicyNumLikeAndDateDistrBetween(String.valueOf(params.get("policyNum")).trim(),
                                dateDistrStart, dateDistrEnd));
            }
            if (!params.get("insuredName").trim().isEmpty()) {
                model.addAttribute("insuredName", params.get("insuredName"));
                model.addAttribute("existInsuredName",
                        policyRepository.existsByInsuredNameLikeAndDateDistrBetween(String.valueOf(params.get("insuredName")).trim(),
                                dateDistrStart, dateDistrEnd));
            }
            if (!params.get("insuredId").trim().isEmpty()) {
                model.addAttribute("insuredId", params.get("insuredId"));
                model.addAttribute("existInsuredId",
                        policyRepository.existsByInsuredIdLikeAndDateDistrBetween(String.valueOf(params.get("insuredId")).trim(),
                                dateDistrStart, dateDistrEnd));
            }
            if (!params.get("vehSign").trim().isEmpty()) {
                model.addAttribute("vehSign", params.get("vehSign"));
                model.addAttribute("existVehSign",
                        policyRepository.existsByVehSignLikeAndDateDistrBetween(String.valueOf(params.get("vehSign")).trim(),
                                dateDistrStart, dateDistrEnd));
            }
            if (!params.get("bodyNo").trim().isEmpty()) {
                model.addAttribute("bodyNo", params.get("bodyNo"));
                model.addAttribute("existBodyNo",
                        policyRepository.existsByBodyNoLikeAndDateDistrBetween(String.valueOf(params.get("bodyNo")).trim(),
                                dateDistrStart, dateDistrEnd));
            }

        } else if (params.get("typeOfPolicy").equals("GC")) {
        }

        /*List<Policy> policies = policyRepository.findByInsuredName(insuredName);
        System.out.println(policies.toString());
        model.addAttribute("policies", policies);*/
        return "search";
    }

    @GetMapping("search/byPolicyNum")
    String searchByPolicy(@RequestParam("policy") String policy,
                          @RequestParam("dateDistrStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrStart,
                          @RequestParam("dateDistrEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrEnd, Model model) throws ParseException {
        List<Policy> policies = policyRepository.findByPolicyNumLikeAndDateDistrBetween(policy.trim(), dateDistrStart, dateDistrEnd);
        model.addAttribute("policies", policies);
        return "policies-result";
    }

    @GetMapping("search/byInsuredName")
    String searchByInsuredName(@RequestParam("name") String insuredName,
                               @RequestParam("dateDistrStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrStart,
                               @RequestParam("dateDistrEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrEnd, Model model) throws ParseException {
//        Date dateDistrStart = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateDistrStart"));
//        Date dateDistrEnd = new SimpleDateFormat("yyyy-MM-dd").parse(searchParams.get("dateDistrEnd"));
        List<Policy> policies = policyRepository.
                //findByInsuredNameLikeAndDateDistrBetween(searchParams.get("insuredName").trim(), dateDistrStart, dateDistrEnd);
                        findByInsuredNameLikeAndDateDistrBetween(insuredName.trim(), dateDistrStart, dateDistrEnd);
        model.addAttribute("policies", policies);
        return "policies-result";
    }

    @GetMapping("search/byInsuredId")
    String searchByInsuredId(@RequestParam("value") String insuredId,
                             @RequestParam("dateDistrStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrStart,
                             @RequestParam("dateDistrEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrEnd, Model model) {
        List<Policy> policies = policyRepository.findByInsuredIdLikeAndDateDistrBetween(insuredId.trim(), dateDistrStart, dateDistrEnd);
        model.addAttribute("policies", policies);
        return "policies-result";
    }

    @GetMapping("search/byVehSign")
    String searchByVehSign(@RequestParam("value") String vehSign,
                           @RequestParam("dateDistrStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrStart,
                           @RequestParam("dateDistrEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrEnd, Model model) {
        List<Policy> policies = policyRepository.findByVehSignLikeAndDateDistrBetween(vehSign.trim(), dateDistrStart, dateDistrEnd);
        model.addAttribute("policies", policies);
        return "policies-result";
    }

    @GetMapping("search/byBodyNo")
    String searchByBodyNo(@RequestParam("value") String bodyNo,
                          @RequestParam("dateDistrStart") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrStart,
                          @RequestParam("dateDistrEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateDistrEnd, Model model) {
        List<Policy> policies = policyRepository.findByBodyNoLikeAndDateDistrBetween(bodyNo.trim(), dateDistrStart, dateDistrEnd);
        model.addAttribute("policies", policies);
        return "policies-result";
    }

}
