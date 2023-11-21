package airbnb.controller;

import airbnb.model.Agency;
import airbnb.model.Customer;
import airbnb.service.AgencyService;
import airbnb.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final AgencyService agencyService;

    @GetMapping
    public String getAllAgencies(Model model){
        model.addAttribute("getAllCustomers", customerService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/createCustomer")
    public String createCustomer(Model model){
        model.addAttribute("newCustomer", new Customer());
        return "createCustomer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/get")
    public String getCustomer(@PathVariable("id") long id, Model model){
        Customer customer = customerService.getById(id);
        model.addAttribute("newCustomer", customer);
        return "customer";
    }
    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") long id){
        model.addAttribute("newCustomer",customerService.getById(id));
        return "updateCustomer";
    }

    @PutMapping("/{id}")
    public String edit(@ModelAttribute("newCustomer") Customer customer, @PathVariable("id") long id){
        customerService.update(id,customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") long id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
