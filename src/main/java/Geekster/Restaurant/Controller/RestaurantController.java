package Geekster.Restaurant.Controller;

import Geekster.Restaurant.models.Restaurant;
import Geekster.Restaurant.services.RestaurantService;
import Geekster.Restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;



    @GetMapping(value = "/getAllRestaurant")
    public List<Restaurant> getAllRestaurant()
    {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping(value = "/addRestaurant")

    public String addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.addMyRestaurant(restaurant);
    }

    @RequestMapping(value = "/getRestaurantById/{id}",method = RequestMethod.GET)
    public Restaurant getRestaurantById(@PathVariable String id)
    {
        return restaurantService.getRestaurantBaseOnId(id);
    }

    @DeleteMapping(value = "/deleteRestaurantById/{id}")

    public String deleteRestaurantById(@PathVariable String id)
    {
        return restaurantService.removeRestaurantById(id);
    }

    @PutMapping(value = "/updateRestaurantById/{id}/{status}")

    public String updateRestaurantById(@PathVariable String id,@PathVariable String status)
    {
        return restaurantService.updateRestaurantStatusById(id,status);
    }

}
