package Geekster.Restaurant.services;

import Geekster.Restaurant.repository.RestaurantDao;
import Geekster.Restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;

    public List<Restaurant> getAllRestaurant() {
        return RestaurantDao.getRestaurantFromDataSources();
    }

    public String addMyRestaurant(Restaurant restaurant) {
        boolean insertionStatus = RestaurantDao.save(restaurant);
        if (insertionStatus) {
            return " Restaurant added successfully";
        } else {

            return "Failed..Not possible";
        }
    }

    public Restaurant getRestaurantBaseOnId(String id) {
        List<Restaurant> restaurantListRightNow = RestaurantDao.getRestaurantFromDataSources();
        for (Restaurant restaurant : restaurantListRightNow) {
            if (restaurant.getId().equals(id)) {
                return restaurant;
            }
        }
        return null;
    }

    public String removeRestaurantById(String id) {
        boolean deleteResponse = false;
        String status;
        if (id != null) {
            List<Restaurant> restaurantListRightNow = restaurantDao.getRestaurantFromDataSources();
            for (Restaurant restaurant : restaurantListRightNow) {
                if (restaurant.getId().equals(id)) {
                    deleteResponse = restaurantDao.remove(restaurant);
                    if (deleteResponse) {
                        status = "Restaurant with id " + id + " was deleted";
                    } else {
                        status = "Restaurant with id " + id + " was not deleted";
                    }
                    return status;
                }
            }

            return "Restaurant with id " + id + " was not exist";

        } else {
            return "Invalid Id cannot accept";
        }
    }

    public String updateRestaurantStatusById(String id, String status) {
        boolean updateStatus =  restaurantDao.update(id, Boolean.parseBoolean(status));

        if (updateStatus)
        {
            return "Restaurant with id " + id + " was updated";
        }else {
            return "Restaurant with id " + id + " was not updated";
        }
    }
}
