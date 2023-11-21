 package airbnb.controller;

import airbnb.model.Agency;
import airbnb.model.Customer;
import airbnb.repository.AgencyRepository;
import airbnb.repository.CustomerRepository;
import airbnb.service.AgencyService;
import airbnb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/agencies")
@RequiredArgsConstructor
public class AgencyController {

   private final AgencyService agencyService;

  private final CustomerService customerService;

   @GetMapping("/assign")
   public String showAssignForm(Model model) {
      List<Agency> agencies = agencyService.getAllAgencies();
      List<Customer> customers = customerService.getAllCustomers();
      model.addAttribute("agencies", agencies);
      model.addAttribute("customers", customers);
      return "assignForm";
   }

   @PostMapping("/assign")
   public String assignClientToAgency(@RequestParam Long customerId, @RequestParam Long agencyId) {
      agencyService.assign(customerId, agencyId);
      return "redirect:/agencies";
   }

   @GetMapping
   public String getAllAgencies(Model model){
      model.addAttribute("getAllAgencies", agencyService.getAllAgencies());
      return "agencies";
   }

   @GetMapping("/create")
    public String createAgency(Model model){
       model.addAttribute("newAgency", new Agency());
       return "createAgency";
   }

   @PostMapping("/save")
    public String saveAgency(@ModelAttribute("newAgency") Agency agency){
       agencyService.save(agency);
       return "redirect:/agencies";
   }
    @GetMapping("/{id}")
    public String getAgency(@PathVariable("id") long id, Model model){
        Agency agency = agencyService.getById(id);
        model.addAttribute("newAgency", agency);
        return "agency";
    }
   @GetMapping("/{id}/update")
   public String update(Model model, @PathVariable("id") long id){
      model.addAttribute("newAgency",agencyService.getById(id));
      return "update";
   }

   @PutMapping("/{id}")
   public String edit(@ModelAttribute("newAgency") Agency agency, @PathVariable("id") long id){
      agencyService.update(id,agency);
      return "redirect:/agencies";
   }

   @DeleteMapping("/{id}/delete")
   public String deleteAgency(@PathVariable("id") Long id) {
      agencyService.delete(id);
      return "redirect:/agencies";
   }
   @GetMapping("/search")
   public String searchAgencies(@RequestParam(required = false) String searchTerm, Model model) {
      List<Agency> searchResults = agencyService.searchAgencies(searchTerm);
      model.addAttribute("agencies", searchResults);
      return "agencyList";
   }
}
