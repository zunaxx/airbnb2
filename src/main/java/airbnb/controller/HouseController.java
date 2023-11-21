package airbnb.controller;

import airbnb.model.Agency;
import airbnb.model.House;
import airbnb.repository.AgencyRepository;
import airbnb.service.AgencyService;
import airbnb.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/houses")
@RequiredArgsConstructor
public class HouseController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private AgencyService agencyService;

    @GetMapping
    public String getAllHouses(Model model){
        model.addAttribute("getAllHouses", houseService.getAllHouses());
        return "houses";
    }

    @GetMapping("/createHouse")
    public String createHouse(Model model){
        model.addAttribute("newHouse", new House());
        model.addAttribute("agencies",agencyService.getAllAgencies());
        return "createHouse";
    }

    @PostMapping("/saveHouse")
    public String saveHouse(@ModelAttribute("newHouse") House house){
        houseService.save(house);
        return "redirect:/houses";
    }
    @GetMapping("/{id}")
    public String getHouses(@PathVariable("id") Long id, Model model){
        House house = houseService.getById(id);
        model.addAttribute("newHouse", house);
        return "/house";
    }
    @GetMapping("/{id}/updateHouse")
    public String update(Model model, @PathVariable("id") long id){
        model.addAttribute("newHouse",houseService.getById(id));
        return "updateHouse";
    }

    @PutMapping("/{id}")
    public String edit(@ModelAttribute("newAgency") House house, @PathVariable("id") long id){
        houseService.update(id,house);
        return "redirect:/houses";
    }

    @DeleteMapping("/{id}")
    public String deleteHouse(@PathVariable("id") Long id) {
        houseService.delete(id);
        return "redirect:/houses";
    }
}
