package Geekster.Restaurant.repository;

import Geekster.Restaurant.models.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantDao {
    
    private final List<Restaurant> restaurantList;
    
    public RestaurantDao()
    {
        restaurantList =  new ArrayList<>() ;
        restaurantList.add(new Restaurant("0","Dummy Restaurant",true)) ;

    }

    public List<Restaurant> getRestaurantFromDataSources()
    {
        return restaurantList;
    }

    public boolean save (Restaurant restaurant){
        restaurantList.add(restaurant);
return true;
    }

    public boolean remove(Restaurant restaurant)
    {
        restaurantList.remove(restaurant);
        return true;
    }

    public boolean update (String id,boolean status)
    {
       boolean updateStatus = false;
        for(Restaurant restaurant : restaurantList)
        {
            if(restaurant.getId().equals(id))
            {

               remove(restaurant);

                restaurant.setRestaurantStatus(status);

              save(restaurant);

              return true;
            }
        }
        return false;
    }
}
